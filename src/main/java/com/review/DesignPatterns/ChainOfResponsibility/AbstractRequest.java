package com.review.DesignPatterns.ChainOfResponsibility;

public class AbstractRequest {
    private int requestCode;

    public AbstractRequest(int requestCode) {
        this.requestCode = requestCode;
    }

    public int getRequestCode() {
        return requestCode;
    }
}
