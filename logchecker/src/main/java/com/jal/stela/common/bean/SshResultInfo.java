package com.jal.stela.common.bean;

/**
 * Created by K.Kangai on 2015/07/31.
 */
public class SshResultInfo {

    private String resultString;

    private int resultCode;

    public SshResultInfo(String resultString, int resultCode) {
        this.resultString = resultString;
        this.resultCode = resultCode;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
