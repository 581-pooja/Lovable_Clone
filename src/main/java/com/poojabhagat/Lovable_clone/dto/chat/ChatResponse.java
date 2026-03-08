package com.poojabhagat.Lovable_clone.dto.chat;

import com.poojabhagat.Lovable_clone.entity.ChatEvent;
import com.poojabhagat.Lovable_clone.entity.ChatSession;
import com.poojabhagat.Lovable_clone.enums.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse (
        Long id,
        ChatSession chatSession,
        MessageRole role,
        List<ChatEventResponse> events,
        String content,
        Integer tokensUsed,
        Instant createdAt
) {

}
