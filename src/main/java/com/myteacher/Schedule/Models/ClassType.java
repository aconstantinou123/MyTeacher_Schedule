package com.myteacher.Schedule.Models;

public enum ClassType {
    ONE_ON_ONE("One one one"),
    GROUP("Group"),
    OPEN_SLOT("Open Slot");

    final String type;

    ClassType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
