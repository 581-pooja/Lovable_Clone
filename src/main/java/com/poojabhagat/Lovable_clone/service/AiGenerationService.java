package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.chat.StreamResponse;
import reactor.core.publisher.Flux;

public interface AiGenerationService {
    Flux<StreamResponse> streamResponse(String message, Long projectId);
}
