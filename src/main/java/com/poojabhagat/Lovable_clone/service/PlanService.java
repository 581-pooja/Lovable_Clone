package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
