package com.creatingCustomAnnotations._SpringBoot_Annotations.services;

import com.creatingCustomAnnotations._SpringBoot_Annotations.util.CurrencyEnum;

import java.util.List;
import java.util.Map;

public interface CurrencyService {

    public List<CurrencyEnum> index();

    public Map<String, Double> exchange(CurrencyEnum currency, Double amount);
}
