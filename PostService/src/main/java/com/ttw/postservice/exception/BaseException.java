package com.ttw.postservice.exception;

import java.util.List;

public class BaseException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    private List<String> messages;

    public BaseException(List<String> messages) {
     this.messages = messages;
    }
}
