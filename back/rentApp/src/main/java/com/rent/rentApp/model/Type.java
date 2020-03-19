package com.rent.rentApp.model;

import java.sql.Time;

public class Type {
    private Integer id;
    private String type_name;
    private String type_image;
    private String category_name;
    private Time create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_image() {
        return type_image;
    }

    public void setType_image(String type_image) {
        this.type_image = type_image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Time getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Time create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", type_image='" + type_image + '\'' +
                ", category_name='" + category_name + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
