package com.poojabhagat.Lovable_clone.repository;

import com.poojabhagat.Lovable_clone.entity.ChatSession;
import com.poojabhagat.Lovable_clone.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
