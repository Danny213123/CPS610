/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.health_care.java_healthcare_database;

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
        test.createRecord(1, 5);
        System.out.println(test.getTransaction(1).transactionState);
        Operation op1 = new Operation(1, OperationType.WRITE, 1, 5);
        Operation op2 = new Operation(2, OperationType.WRITE, 1, 5);
        Operation op3 = new Operation(3, OperationType.WRITE, 1, 5);
        Operation op4 = new Operation(2, OperationType.COMMIT);
        test.queueOperation(1, op1);
        test.queueOperation(2, op2);
        test.queueOperation(3, op3);
        test.queueOperation(2, op2);
        test.queueOperation(2, op4);
        test.run();
    }
}
