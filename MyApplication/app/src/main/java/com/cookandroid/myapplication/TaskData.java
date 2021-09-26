package com.cookandroid.myapplication;

public class TaskData {

    private int iv_icon;
    private String tv_task;

    /* drag & drop */
    private int number;


    /* 내용 */

    public TaskData(int iv_icon, String tv_task, int number) {
        this.iv_icon = iv_icon;
        this.tv_task = tv_task;
        this.number = number;
    }

    public int getIv_icon() {
        return iv_icon;
    }

    public void setIv_icon(int iv_icon) {
        this.iv_icon = iv_icon;
    }

    public String getTv_task() {
        return tv_task;
    }

    public void setTv_task(String tv_task) {
        this.tv_task = tv_task;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
