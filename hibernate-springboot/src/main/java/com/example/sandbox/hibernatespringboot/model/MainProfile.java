package com.example.sandbox.hibernatespringboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MainProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customer_id")
    private String customerId;


    @OneToOne(mappedBy = "mainprofile", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private CommProfile commProfile;

    protected MainProfile() {

    }

    public MainProfile(final String customerId, final CommProfile commProfile) {
        this();
        this.customerId = customerId;
        this.commProfile = commProfile;
        commProfile.setMainprofile(this);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CommProfile getCommProfile() {
        return commProfile;
    }

    public void setCommProfile(CommProfile commProfile) {
        this.commProfile = commProfile;
    }
}
