package com.health_care.java_healthcare_database;

public class operation {

    public String type;
    public Integer recordId;
    public Integer value;

    public operation(String type){
        this.type = type;
        this.recordId = null;
        this.value = null;
    }

    public operation(String type, int recordId){
        this.recordId = recordId;
        this.type = type;
        this.value = null;
    }

    public operation(String type, int recordId, int value){
        this.type = type;
        this.recordId = recordId;
        this.value = value;
    }
    
}