/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.health_care.java_healthcare_database;

import java.util.ArrayList;

/**
 *
 * @author Danny Guan
 */

public class AccessDatabase {

    public static void main (String[] args) {
        Database test = new Database();
        test.createTransaction(1);
        test.createTransaction(2);
        test.createTransaction(3);
        test.createRecord(1, 22);
        System.out.println(test.getTransaction(1).transactionState);
        Operation op1 = new Operation(1, OperationType.WRITE, 1, 5);
        Operation op2 = new Operation(2, OperationType.READ, 1, 0);

        test.queueOperation(1, op1);
        test.queueOperation(2, op2);

        test.run();

        // turn hashmap records into arraylist
        ArrayList<RecordObject> testRecordArray = new ArrayList<RecordObject>(test.records.values());

        // print out the record array
        for (RecordObject record : testRecordArray) {
            System.out.println("Record ID: " + record.getId() + " Value: " + record.getValue());
            System.out.println("Lock State: " + record.lockState + " Transactions waiting: " + record.transactionsWaitingForLock);
        }

    }
}
