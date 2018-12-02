package com.myteacher.Schedule.Models;

public enum ClassLevel {
    BEGINNER("Beginner"),
    ELEMENTARY("Elementary"),
    PRE_INT("Pre-intermediate"),
    INT("Intermediate"),
    UPPER_INT("Upper-intermediate"),
    ADVANCED("Advanced");

    final String level;

    ClassLevel(String level){
        this.level = level;
    }

    public String getLevel(){
        return level;
    }
}
