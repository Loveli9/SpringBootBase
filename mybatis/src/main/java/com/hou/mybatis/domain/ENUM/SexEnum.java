package com.hou.mybatis.domain.ENUM;

public enum SexEnum {

    MAN(1,"男人"),
    WOMAN(2,"女人");

    private Integer id;
    private String name;

    SexEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
