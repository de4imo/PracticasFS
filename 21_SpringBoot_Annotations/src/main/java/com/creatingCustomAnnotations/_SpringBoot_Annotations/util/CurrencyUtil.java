package com.creatingCustomAnnotations._SpringBoot_Annotations.util;

import java.util.HashMap;
import java.util.Map;

public class CurrencyUtil {
    public static final Map<CurrencyEnum, Double> currencyValues;
    
    static{
        currencyValues = new HashMap<>();
        currencyValues.put(CurrencyEnum.MXN, 22.95);
        currencyValues.put(CurrencyEnum.GBP, 0.83);
        currencyValues.put(CurrencyEnum.USD, 1.11);
    }
}
