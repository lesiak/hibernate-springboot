package com.example.sandbox.hibernatespringboot.model;

import com.example.sandbox.hibernatespringboot.model.converters.JobStatusConverter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(schema = "dcsdba", name = "User")
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.DIRTY)
public class User {

    @Id
    @Column(name = "User_Id", updatable = false)
    private String userId;

    @Column(name = "Title", updatable = false)
    private String title;

    @Column(name = "Job_Status")
    @Convert(converter = JobStatusConverter.class)
    JobStatus jobStatus;

    @Column(name = "Reason")
    @Length(max = 12)
    private String reason;

    @Column(name = "Updated_At")
    private Instant updatedAt;

    public User() {
    }

    public User(String userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    public User(String userId, String title,
                JobStatus jobStatus,
                String reason,
                Instant updatedAt) {
        this.userId = userId;
        this.title = title;
        this.jobStatus = jobStatus;
        this.reason = reason;
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    void setJobStatus(JobStatus lockStatus, String reason, Instant instant) {
        if (this.jobStatus != lockStatus) {
            this.reason = reason;
            this.updatedAt = instant;
        }
        this.jobStatus = lockStatus;
    }

    public String getReason() {
        return reason;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", jobStatus=" + jobStatus +
                ", reason='" + reason + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
