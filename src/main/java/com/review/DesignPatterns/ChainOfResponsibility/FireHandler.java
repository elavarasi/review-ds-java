package com.review.DesignPatterns.ChainOfResponsibility;

public class FireHandler extends AbstractHandler {

    private static int code = 1;

    public FireHandler(AbstractHandler successor) {
        super(successor);
    }

    public void handleRequest(AbstractRequest request) {
        if (code == request.getRequestCode()) {

        } else {
            super.handleRequest(request);
        }
    }

}
