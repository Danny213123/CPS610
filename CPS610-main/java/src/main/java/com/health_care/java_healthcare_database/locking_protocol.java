package com.health_care.java_healthcare_database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class locking_protocol {

    public List<transaction> transactions = new ArrayList<transaction>();
    public List<recordObj> records = new ArrayList<recordObj>();
    public Integer scheduleLength = 0;


    // create a new function to do 2PL locking
    public ArrayList<transaction> pl_algorithm(ArrayList<transaction> transactions){
        // return the arraylist
        return transactions;
        
    }

    public boolean addRecord(recordObj recordObject) {
        if (!this.records.contains(recordObject)) {
            //this.lockTable.put(recordObject.recordId, "available");
            this.records.add(recordObject);
            this.scheduleLength += 1;
            return true;
        }
        return false;
    }

    public boolean addTransaction(transaction tranEntry) {
        if (!this.transactions.contains(tranEntry)) {
            this.transactions.add(tranEntry); //add transaction to this locking protocol transaction list
            return true;
        }
        return false;
    }

    public boolean lock(operation op) {
        int recordId = op.recordId;
        int tranId = op.transactionId;
        recordObj requestedRecord = null;
        transaction requestingTran = null;
        String currentState = null;
        for (recordObj record : this.records) {
            if (record.recordId == recordId) {
                requestedRecord = record;
                currentState = requestedRecord.state;
                break;
            }
        }
        for (transaction tran : this.transactions) {
            if (tran.transactionId == tranId) {
                requestingTran = tran;
                break;
            }
        }
        if (op.type == "read") {
            if (currentState == "A" && op.type == "read") {
                requestedRecord.state = "S";
                requestedRecord.currentTransaction = requestingTran;
                requestingTran.lockedRecords.add(requestedRecord);
                return true;
            }
            else if (requestingTran.lockedRecords.contains(requestedRecord)) {
                return true;
            }
            else {
                wait(op);
            }
        }
        else if (op.type == "write") {
            if (currentState == "A") {
                requestedRecord.state = "X";
                requestedRecord.currentTransaction = requestingTran;
                requestingTran.lockedRecords.add(requestedRecord);
                return true;
            }
            else if (requestingTran.lockedRecords.contains(requestedRecord)) {
                requestedRecord.state = "X";
                return true;
            }
            else {
                wait(op);
            }
        }
        return false;
    }

    public boolean wait(operation op) {

        return true;
    }

}

