package com.rent.rentApp.model;

public class Category {
    private Integer classId;
    private String className;



    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public String toString() {
        return "Category{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
