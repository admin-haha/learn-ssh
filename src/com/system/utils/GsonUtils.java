package com.system.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.system.utils.gson.IgnoreStrategy;

public class GsonUtils {
    private static Gson instance = null;

    public synchronized static Gson getGson(TypeAdapterFactory... adapterFactories) {
        if (instance == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.addSerializationExclusionStrategy(new IgnoreStrategy());
            for (TypeAdapterFactory adapter : adapterFactories) {
                builder.registerTypeAdapterFactory(adapter);
            }
            instance = builder.create();
        }
        return instance;
    }
    
}
