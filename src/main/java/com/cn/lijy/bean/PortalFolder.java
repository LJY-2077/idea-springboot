package com.cn.lijy.bean;

/**
 * @author lijy
 * @descriptin
 * @since
 */

public class PortalFolder {
    //当前pageId
    private String id;
    //父类pageId
    private String pId;
    //名称
    private String name;
    //设置状态为true
    private boolean status = true;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}