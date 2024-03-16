package com.health_care.java_healthcare_database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class locking_protocol {

    private final Map<Integer, String> lockTable = new HashMap<>(); //key: record_id, value: state
    private List<transaction> transactions;



    // create a new function to do 2PL locking
    public ArrayList<transaction> pl_algorithm(ArrayList<transaction> transactions){

        // return the arraylist
        return transactions;
        
    }
    public void addTransaction(transaction tranEntry) {
        this.transactions.add(tranEntry);
        for (int i = 0; i < tranEntry.operations.size(); i++) {

            operation op = transaction.operations.get(i);
            if (op instanceof read || op instanceof write) {
                lockTable.put(op.record_id, "available");
            } 
        }
    }

    public boolean lock(operation op) {
        int recordId = op.record_id;
        String currentState = lockTable.get(recordId);
        if (currentState == "available" && op instanceof read) {
            lockTable.put(recordId, "shared locked"); 
            return true;
        }
        else if (currentState == "available" && op instanceof write) {
            lockTable.put(recordId, "exclusively locked"); 
            return true;

        }
        return false;
    }

}
