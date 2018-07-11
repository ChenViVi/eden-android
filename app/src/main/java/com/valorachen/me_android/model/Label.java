package com.valorachen.me_android.model;

import com.google.gson.annotations.SerializedName;

public class Label {

    /**
     * id : 987157475
     * node_id : MDU6TGFiZWw5ODcxNTc0NzU=
     * url : https://api.github.com/repos/ChenViViPage/test/labels/%E8%B7%AF%E7%94%B1%E5%99%A8
     * name : 路由器
     * color : 0e8a16
     * default : false
     */

    private int id;
    private String node_id;
    private String url;
    private String name;
    private String color;
    @SerializedName("default")
    private boolean defaultX;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDefaultX() {
        return defaultX;
    }

    public void setDefaultX(boolean defaultX) {
        this.defaultX = defaultX;
    }
}
