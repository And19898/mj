package com.mj.pkshi.bmobquery;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * author: Rea.x
 * date: 2017/12/5.
 */

public class SysMsg extends BmobObject implements Serializable{

    private String title;
    private String msg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
