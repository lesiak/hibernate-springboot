package com.example.sandbox.hibernatespringboot.model.common;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comm_profile")
@NamedQuery(name = "CommProfile.findAll", query = "SELECT c FROM CommProfile c")
public class CommProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customer_id")
    private String customerId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", foreignKey = @ForeignKey(name = "COMM_PROFILE_MAIN_PROFILE_FK"))
    @MapsId
    private MainProfile mainprofile;



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public MainProfile getMainprofile() {
        return mainprofile;
    }

    public void setMainprofile(MainProfile mainprofile) {
        this.mainprofile = mainprofile;
    }
}