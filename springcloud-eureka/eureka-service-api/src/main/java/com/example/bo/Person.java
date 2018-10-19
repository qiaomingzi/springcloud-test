package com.example.bo;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 4517889156402771626L;
    private String name;
    private String password;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
