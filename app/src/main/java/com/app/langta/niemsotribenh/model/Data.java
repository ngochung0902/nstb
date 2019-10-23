package com.app.langta.niemsotribenh.model;

import java.io.Serializable;

public class Data implements Serializable {

    int id = 0, dolinhnghiem = 0;
    String sobenh, tenbenh, ghichu, url_image;

    public Data(int id, int dolinhnghiem, String sobenh, String tenbenh, String ghichu) {
        this.id = id;
        this.dolinhnghiem = dolinhnghiem;
        this.sobenh = sobenh;
        this.tenbenh = tenbenh;
        this.ghichu = ghichu;
    }

    public Data(int id, int dolinhnghiem, String sobenh, String tenbenh, String ghichu, String url_image) {
        this.id = id;
        this.dolinhnghiem = dolinhnghiem;
        this.sobenh = sobenh;
        this.tenbenh = tenbenh;
        this.ghichu = ghichu;
        this.url_image = url_image;
    }

    public int getDolinhnghiem() {
        return dolinhnghiem;
    }

    public void setDolinhnghiem(int dolinhnghiem) {
        this.dolinhnghiem = dolinhnghiem;
    }

    public String getSobenh() {
        return sobenh;
    }

    public void setSobenh(String sobenh) {
        this.sobenh = sobenh;
    }

    public String getTenbenh() {
        return tenbenh;
    }

    public void setTenbenh(String tenbenh) {
        this.tenbenh = tenbenh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
