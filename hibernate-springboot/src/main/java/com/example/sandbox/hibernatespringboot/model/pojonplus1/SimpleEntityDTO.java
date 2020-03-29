package com.example.sandbox.hibernatespringboot.model.pojonplus1;

import javax.persistence.Column;
import javax.persistence.Id;

public class SimpleEntityDTO {
    private Long id;
    private String text;
    private Boolean second;

    public SimpleEntityDTO() {
    }

    public SimpleEntityDTO(Long id, String text, Boolean second) {
        this.id = id;
        this.text = text;
        this.second = second;
    }

    public Boolean getSecond() {
        return second;
    }

    public void setSecond(Boolean second) {
        this.second = second;
    }
}
