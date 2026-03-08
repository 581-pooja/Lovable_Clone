package com.poojabhagat.Lovable_clone.repository;

import com.poojabhagat.Lovable_clone.entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEventRepository extends JpaRepository<ChatEvent, Long> {
}
