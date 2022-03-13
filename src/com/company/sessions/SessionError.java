package com.company.sessions;

public class SessionError implements ISessionError{
    private String errorMsg = "";

    @Override
    public void setErrorMessage(String msg) {
        errorMsg = msg;
    }

    @Override
    public String getErrorMessage() {
        return errorMsg;
    }
}
