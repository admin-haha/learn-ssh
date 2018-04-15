package com.system.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapterFactory;
import com.system.utils.gson.IgnoreStrategy;

public class GsonUtils {
    private static Gson instance = null;

    private static JsonParser parser = null;
    
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
    
    public synchronized static JsonParser getJsonParser() {
        if (parser == null) {
            parser = new JsonParser();
        }
        return parser;
    }
    
    public static JsonObject parseString2JsonObject(String jsonStr) {
    	if (parser == null) {
            parser = getJsonParser();
        }
    	return parser.parse(jsonStr).getAsJsonObject();
    }
    
    public static JsonArray list2JsonArray(List<String> datas) {
    	JsonArray array = new JsonArray();
		if(datas!=null&&datas.size()>0) {
			
			for(String item:datas) {
				array.add(GsonUtils.parseString2JsonObject(item));
			}
		}
		return array;
    	
    }
}
