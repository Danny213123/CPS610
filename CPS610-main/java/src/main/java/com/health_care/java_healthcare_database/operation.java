package com.health_care.java_healthcare_database;

public class operation {

    public String type;
    public Integer recordId;
    public Integer value;
    public Integer transactionId;

    public operation(String type, Integer transactionId) {
        this.type = "commit";
        this.recordId = null;
        this.value = null;
        this.transactionId = transactionId;
    }

    public operation(String type, int recordId, Integer transactionId) {
        this.recordId = recordId;
        this.type = "read";
        this.value = null;
        this.transactionId = transactionId;
    }

    public operation(String type, int recordId, int value, Integer transactionId) {
        this.type = "write";
        this.recordId = recordId;
        this.value = value;
        this.transactionId = transactionId;
    }
    
}