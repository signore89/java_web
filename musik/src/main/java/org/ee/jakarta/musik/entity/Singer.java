package org.ee.jakarta.musik.entity;

public class Singer {
    private int id;
    private String name = "unknown artist";
    private String urlImg;

    public Singer() {
    }

    public Singer(int id, String name, String urlImg) {
        this.id = id;
        this.name = name;
        this.urlImg = urlImg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
