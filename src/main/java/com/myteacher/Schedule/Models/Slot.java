package com.myteacher.Schedule.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

public class Slot {
    @Id
    private ObjectId _id;
    private String date;
    private String hour;
    private String username;
    private String classId;
    private String classType;
    private String classLevel;
    private String classDescription;
    private int capacity;
    private ArrayList<String> students;
    private String startTime;
    private String endTime;

    public Slot(){};

    public Slot(ObjectId _id, String date, String hour, String username, String classId, String classLevel, String classType, String classDescription, int capacity, ArrayList<String> students, String startTime, String endTime) {
        this._id = _id;
        this.date = date;
        this.hour = hour;
        this.username = username;
        this.classId = classId;
        this.classLevel = classLevel;
        this.classType = classType;
        this.classDescription = classDescription;
        this.capacity = capacity;
        this.students = students;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
       this.classLevel = classLevel;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<String> getStudents() {
        return students;

    }

    public void setStudents(ArrayList<String> students) {
        this.students = students;
    }

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
