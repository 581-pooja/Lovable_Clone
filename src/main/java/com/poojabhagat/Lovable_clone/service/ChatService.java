package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {
    List<ChatResponse> getProjectChatHistory(Long projectId);
}
