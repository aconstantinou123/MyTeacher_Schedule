package com.myteacher.Schedule.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Slot {
    @Id
    private ObjectId _id;
    private String date;
    private String hour;
    private String username;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
