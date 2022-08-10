package com.board.common.log;

public class LogMessage {
    public String getErrorMessage(StackTraceElement[] ste) {
        return  new StringBuilder("Method : ")
                .append(ste[0].getClassName())
                .append(".")
                .append(ste[0].getMethodName())
                .append(" File : ")
                .append(ste[0].getFileName())
                .append(" by ")
                .append(ste[0].getLineNumber())
                .append(" line").toString();
    }
}
