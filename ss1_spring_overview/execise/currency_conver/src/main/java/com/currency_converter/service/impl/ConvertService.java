package com.currency_converter.service.impl;

import com.currency_converter.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double convertUsdToVnd(double usd) {
        double result = usd * 25000;
        return result;
    }

    @Override
    public double convertVndToUsd(double vnd) {
        double result = vnd / 25000;
        return result;
    }
}
