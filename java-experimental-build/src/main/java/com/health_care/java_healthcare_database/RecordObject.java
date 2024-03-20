package com.health_care.java_healthcare_database;

import java.util.ArrayList;

public class RecordObject {

    public Integer recordId;
    public Integer value;

    public LockState lockState;
    public ArrayList<Transaction> transactionsHoldingSharedLock = new ArrayList<Transaction>();
    public Transaction transactionHoldingExclusiveLock = null;

    /**
     * Constructor for the record object
     * @param recordId
     * @param valueInitial
     * 
     */
    public RecordObject (Integer recordId, Integer valueInitial) {
        this.recordId = recordId;
        this.value = valueInitial;
    }

    /**
     * Returns the record id
     * @return recordId
     * 
     */
    public Integer getId(){
        return this.recordId;
    }

    /**
     * Returns the value of the record
     * @return value
     */
    public Integer getValue(){
        return this.value;
    }

    /**
     * Sets the value of the record
     * @param newValue
     * 
     */
    public void setValue(int newValue){
        this.value = newValue;
    }

    /**
     * Returns the lock state of the record
     * @return lockState
     * 
     */
    public LockState getLockState(){
        return this.lockState;
    }

    /**
     * Sets the lock state of the record
     * @param newLockState
     * 
     */
    public void setLockState (LockState newLockState) {
        this.lockState = newLockState;
    }

    /**
     * Returns the transactions holding a shared lock
     * @return transactionsHoldingSharedLock
     * 
     */
    public Transaction getTransactionHoldingExclusiveLock() {
		return this.transactionHoldingExclusiveLock;
	}

    /**
     * Sets the transaction holding a shared lock
     * @param transactionHoldingExclusiveLock
     * 
     */
    public void setTransactionHoldingExclusiveLock(Transaction transactionHoldingExclusiveLock) {
		this.transactionHoldingExclusiveLock = transactionHoldingExclusiveLock;
	}

}
 