package com.health_care.java_healthcare_database;

public class recordObj {
    public int recordId;
    public String state;
    public transaction currentTransaction;

    public recordObj (int recordId) {
        this.recordId = recordId;
        this.state = "A"; //A for available, S for shared locked, X for exclusively locked
        this.currentTransaction = null;
    }
}
 