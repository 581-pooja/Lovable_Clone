package com.poojabhagat.Lovable_clone.entity;

import com.poojabhagat.Lovable_clone.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Many Subscription to One User
    @JoinColumn(nullable = false, name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY) // Many Subscription to One Plan
    @JoinColumn(nullable = false, name = "plan_id")
    Plan plan;

    @Enumerated(value = EnumType.STRING)
    SubscriptionStatus status;

    String stripeSubscriptionId; //can be renamed to gatewaySubscriptionId

    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Boolean cancelAtPeriodEnd = false;

    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;
}
