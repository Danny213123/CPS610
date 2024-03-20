package com.health_care.java_healthcare_database;

import java.util.ArrayList;

public class Transaction {

    public Integer transactionId;
    public ArrayList<Operation> operations = new ArrayList<Operation>();
    public ArrayList<String> acquiredLocks = new ArrayList<String>();
    public TransactionState transactionState;

    /**
     * Constructor for the transaction
     * @param transactionId
     * 
     */
    public Transaction(int transactionId){
        this.transactionId = transactionId;
        this.transactionState = TransactionState.ACTIVE;
    }

    /**
     * Returns the transaction id
     * @return transactionId
     * 
     */
    public int getTransactionId(){
        return transactionId;
    }

    /**
     * Returns the transaction state
     * @return operations
     * 
     */
    public ArrayList<Operation> getOperations(){
        return this.operations;
    }

    /**
     * Adds an operation to the transaction
     * @param operation
     * 
     */
    public void addOperation(Operation operation){
        operations.add(operation);
    }

    /**
     * Returns the transaction state
     * @return transactionState
     * 
     */
    public void setState (TransactionState newState) {
        this.transactionState = newState;
    }
}
