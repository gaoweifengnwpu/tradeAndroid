package com.trade.utils;

/**
 * Created by GWF on 2018/1/28.
 */

public class ResultMessage {
    private int resultCode;// 结果码
    private String resultMessage;// 结果信息

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public ResultMessage() {
        // TODO Auto-generated constructor stub
    }

    public ResultMessage(int resultCode, String resultMessage) {
        super();
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
}