package com.ttw.relationservice.exception;

import java.util.List;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<String> messages;

    public BaseException(List<String> messages) {
        this.messages = messages;
    }
}
