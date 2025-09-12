package com.ttw.userservice.exception;

import java.util.List;

public class UserBusinessException extends UserBaseException {

    public UserBusinessException(String message) {
        super(List.of(message));
    }
}
