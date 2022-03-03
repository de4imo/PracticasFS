package com.creatingCustomAnnotations._SpringBoot_Annotations.services;

import com.creatingCustomAnnotations._SpringBoot_Annotations.util.CurrencyEnum;
import com.creatingCustomAnnotations._SpringBoot_Annotations.util.CurrencyUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Override
    public List<CurrencyEnum> index() {
        return Arrays.asList(CurrencyEnum.values());
    }

    @Override
    public Map<String, Double> exchange(CurrencyEnum currency, Double amount) {
        Map<String, Double> response = new HashMap<>();
        Double currencyValue = CurrencyUtil.currencyValues.get(currency);

        Double resultConversion = amount * currencyValue;

        response.put(/*amount+*/" EUR to "+currency.name(), resultConversion);

        return response;
    }
}
