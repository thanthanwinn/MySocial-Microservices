package com.ttw.userservice.exception;

import java.util.List;

public class UserValidationException extends UserBaseException {
    private static final long serialVersionUID = 1L;

    public UserValidationException(List<String> messages) {
        super(messages);
    }
}
