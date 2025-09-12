package com.ttw.userservice.payload.utils;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalSanitizer {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        Object target = binder.getTarget();
        if (target != null) {
            SanitizationHelper.sanitizeObject(target);
        }
    }
}
