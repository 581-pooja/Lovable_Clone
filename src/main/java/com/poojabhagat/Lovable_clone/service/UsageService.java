package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.subscription.PlanLimitsResponse;
import com.poojabhagat.Lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    void recordTokenUsage(Long userId, int actualTokens);
    void checkDailyTokensUsage();
}
