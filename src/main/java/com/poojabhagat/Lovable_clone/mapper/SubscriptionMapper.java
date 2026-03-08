package com.poojabhagat.Lovable_clone.mapper;

import com.poojabhagat.Lovable_clone.dto.subscription.PlanResponse;
import com.poojabhagat.Lovable_clone.dto.subscription.SubscriptionResponse;
import com.poojabhagat.Lovable_clone.entity.Plan;
import com.poojabhagat.Lovable_clone.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
