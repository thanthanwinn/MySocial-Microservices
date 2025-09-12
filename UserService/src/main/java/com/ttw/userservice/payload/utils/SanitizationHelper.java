package com.ttw.userservice.payload.utils;

import java.lang.reflect.Field;

public class SanitizationHelper {
    public static void sanitizeObject(Object obj){
        if(obj == null) return;

        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field f : fields){
            if(f.getType().equals(String.class)){
                f.setAccessible(true);
                try{
                    String value = (String)f.get(obj);
                    if (value != null) {
                        // Generic sanitization: remove unwanted characters
                        f.set(obj, value.trim().replaceAll("[^a-zA-Z0-9_\\s.,!?@-]", ""));
                    }
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
