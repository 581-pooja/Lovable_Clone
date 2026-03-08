package com.poojabhagat.Lovable_clone.entity;

import com.poojabhagat.Lovable_clone.enums.MessageRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.simpleframework.xml.Order;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "chat_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false),
            @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    })
    ChatSession chatSession;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    MessageRole role; // USER, ASSISTANT

    @OneToMany(mappedBy = "chatMessage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("sequenceOrder ASC")
    List<ChatEvent> events;  // empty unless ASSISTANT role

    @Column(columnDefinition = "text", nullable = false)
    String content; // NULL unless USER role

    Integer tokensUsed = 0;

    @CreationTimestamp
    Instant createdAt;
}

// Each ChatMessage belongs to one ChatSession, and that ChatSession is uniquely identified by (project_id + user_id)

// USER sends one complete message → no streaming
// ASSISTANT streams response → many events


// One ChatMessage can have multiple ChatEvents representing streamed AI output.
// The relationship is mapped by the owning side in ChatEvent, uses lazy loading for performance,
// and cascade ALL for lifecycle management.