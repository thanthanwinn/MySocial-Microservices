package com.ttw.relationservice.exception;

import java.util.List;

public class AlreadyBlockedException extends BaseException {

    public AlreadyBlockedException(List<String> messages) {
        super(messages);
    }
}
