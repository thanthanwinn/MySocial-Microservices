package com.ttw.userservice.exception;

import java.util.List;

public class UserBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<String> messages ;

    public UserBaseException(List<String> messages) {
        this.messages = messages;
    }

}
