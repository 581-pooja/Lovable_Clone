package com.poojabhagat.Lovable_clone.mapper;

import com.poojabhagat.Lovable_clone.dto.chat.ChatResponse;
import com.poojabhagat.Lovable_clone.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}