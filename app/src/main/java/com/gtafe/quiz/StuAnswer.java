package com.gtafe.quiz;

/**
 * Created by ZhouJF on 2018/1/7.
 */

class StuAnswer {

    /**
     * IsSucess : true
     * Msg : 成功
     * Data : {"1":"Y","2":"B"}
     */

    private boolean IsSucess;
    private String Msg;
    private String Data;

    public boolean isIsSucess() {
        return IsSucess;
    }

    public void setIsSucess(boolean IsSucess) {
        this.IsSucess = IsSucess;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
}
