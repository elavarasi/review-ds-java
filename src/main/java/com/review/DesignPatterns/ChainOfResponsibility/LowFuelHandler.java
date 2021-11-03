package com.review.DesignPatterns.ChainOfResponsibility;

public class LowFuelHandler extends AbstractHandler {
    private static int code = 1;

    public LowFuelHandler(AbstractHandler successor) {
        super(successor);
    }

    public void handleRequest(AbstractRequest request) {
        if (code == request.getRequestCode()) {

        } else {
            super.handleRequest(request);
        }
    }

}
