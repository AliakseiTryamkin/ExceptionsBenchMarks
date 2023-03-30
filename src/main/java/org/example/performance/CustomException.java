package org.example.performance;

public class CustomException extends Exception {

    private final int metadata;

    public CustomException(int metadata) {
        super();
        this.metadata = metadata;
    }

    public CustomException(CustomException e, int metadata) {
        super(e);
        this.metadata = metadata;
    }
}
