package com.example.sandbox.hibernatespringboot.model.common;

public enum JobStatus implements HasCustomName {
    Employed("Employed"),
    Unemployed("Unemployed");

    private final String customName;

    JobStatus(String customName) {
        this.customName = customName;
    }

    @Override
    public String getCustomName() {
        return customName;
    }

}