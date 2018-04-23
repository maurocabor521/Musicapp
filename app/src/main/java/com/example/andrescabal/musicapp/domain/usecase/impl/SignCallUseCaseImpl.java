package com.example.andrescabal.musicapp.domain.usecase.impl;

import com.example.andrescabal.musicapp.domain.usecase.SignCallUseCase;
import com.example.andrescabal.musicapp.helpers.StringUtilities;

import java.util.Map;
import java.util.TreeMap;



/**
 * Created by krlosf on 15/04/18.
 * Caso de uso encargado de realizar la firma de metodos requerida por el API de Last.fm
 */

public class SignCallUseCaseImpl implements SignCallUseCase {

    private static SignCallUseCase instance;

    public static SignCallUseCase getInstance() {
        if(instance == null) {
            instance = new SignCallUseCaseImpl();
        }

        return instance;
    }

    @Override
    public String signature(String method, Map<String, String> params, String secret) {
        params = new TreeMap<>(params);
        params.put("method", method);
        StringBuilder b = new StringBuilder(100);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            b.append(entry.getKey());
            b.append(entry.getValue());
        }
        b.append(secret);
        return StringUtilities.md5(b.toString());
    }

}
