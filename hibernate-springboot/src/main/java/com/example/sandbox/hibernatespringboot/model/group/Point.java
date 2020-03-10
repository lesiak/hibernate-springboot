package com.example.sandbox.hibernatespringboot.model.group;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
public class Point{
    @EmbeddedId
    private PointIdentity pointIdentity;
    private float latitude;
    private float longitude;

    @Embeddable
    public static class PointIdentity implements Serializable {
        private Long id;
        private ZonedDateTime timestamp;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public ZonedDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(ZonedDateTime timestamp) {
            this.timestamp = timestamp;
        }
    }

    public PointIdentity getPointIdentity() {
        return pointIdentity;
    }

    public void setPointIdentity(PointIdentity pointIdentity) {
        this.pointIdentity = pointIdentity;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
