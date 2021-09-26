package com.cookandroid.myapplication;

public class TaskData {

    private int iv_icon;
    private String tv_task;

    /* 내용 */

    public TaskData(int iv_icon, String tv_task) {
        this.iv_icon = iv_icon;
        this.tv_task = tv_task;
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
}
