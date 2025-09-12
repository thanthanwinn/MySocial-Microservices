package com.ttw.relationservice.exception;

import java.util.List;

public class RelationException extends BaseException{

    private static final long serialVersionUID = 1L;

    public RelationException(List<String> messages) {
        super(messages);
    }
    public RelationException(String message) {
        super(List.of(message));
    }
}
