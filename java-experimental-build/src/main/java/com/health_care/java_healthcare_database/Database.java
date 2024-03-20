package com.health_care.java_healthcare_database;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Database {
    public HashMap<Integer, Transaction> transactions;
    public HashMap<Integer, RecordObject> records;
    public ArrayList<Integer> transactionPointer; 

    /* 
     * Constructor for the database
     * 
     */
    public Database(){
        transactions = new HashMap<Integer, Transaction> ();
        records = new HashMap<Integer, RecordObject> ();
        transactionPointer = new ArrayList<Integer> ();
    }

    /* 
     * Creates a transaction with the given transaction id
     * @param transactionId the transaction id
     * 
     */
    public void createTransaction (Integer transactionId) {
        if (!transactions.containsKey(transactionId)) {
            Transaction newTransaction = new Transaction(transactionId);
            transactions.put(transactionId, newTransaction);
            transactionPointer.add(transactionId);

            System.out.println("Transaction with transaction id: " + transactionId + " was successfully created.");
        } else {
            System.out.println("Transaction with transaction id: " + transactionId + " already exists.");
        }
    }

    /*
     * Queues the operation with the given transaction id
     * @param transactionId the transaction id
     * @param operation the operation
     * 
     */
    public void queueOperation(Integer transactionId, Operation operation) {
		if(transactions.containsKey(transactionId) && operation.getTransactionId() == transactionId) {
			transactions.get(transactionId).addOperation(operation);
        } else { 
            System.out.println("Operation with id: " + operation.getTransactionId() + " failed to be queued.");
        }
	}

    /* 
     * Creates a record with the given record id and record value
     * @param recordId the record id
     * @param recordValue the record value
     * 
     */
    public void createRecord(Integer recordId, Integer recordValue) {
        if (!records.containsKey(recordId)) {
            RecordObject newRecord = new RecordObject(recordId, recordValue);
            records.put(recordId, newRecord);

            System.out.println("Record with transaction id: " + recordId + " was successfully created.");
        } else {
            System.out.println("Record with transaction id: " + recordId + " already exists.");
        }
    }

    /*
     * Schedules the transactions
     * @return the schedule
     * 
     */
    public ArrayList<Operation> scheduler (){
        int n = transactionPointer.size();
        Object[] hashToArray = transactions.values().toArray();
        Operation[][] transactionArray = new Operation[n][];
        
        for (int i = 0; i < hashToArray.length; i++){
            Transaction tempTransaction = (Transaction) hashToArray[i];
            ArrayList<Operation> tempTransactionOperations = tempTransaction.getOperations();
            Operation[] tempOperationsList = new Operation[tempTransactionOperations.size()];

            tempOperationsList = tempTransactionOperations.toArray(tempOperationsList);
            transactionArray[i] = tempOperationsList;
        }

        // System.out.println(transactionArray[0]);
        // System.out.println(transactionArray[0].length);

        // System.out.println(transactionArray[1]);
        // System.out.println(transactionArray[1].length);

        ArrayList<Operation> schedule = new ArrayList<Operation>();

        int index = 0;
        int arr_index = 0;

        for (int i = 0; i < n * n; i++) {

            if (index >= transactionArray[arr_index].length) {
                //
            } else {
                schedule.add(transactionArray[arr_index][index]);
            }

            arr_index++;

            if (arr_index == n) {
                arr_index = 0;
                index++;
            }

        }

        return schedule;

    }

    /*
     * Returns the transaction with the given transaction id
     * @param transactionId the transaction id
     */
    public Transaction getTransaction(Integer transactionId) {
        return transactions.get(transactionId);
    }

    /*
     * Runs the scheduler
     * 
     */
    @SuppressWarnings("unlikely-arg-type")
    public void run(){
        ArrayList<Operation> schedule = scheduler();

        /*
        int index = 0;
        do {
            Operation operation = schedule.get(index);
            System.out.println(operation.getOperationType());
            switch (operation.getOperationType()){
                case READ:
                    System.out.println(operation);
                    break;
                case WRITE:
                    System.out.println(operation);
                    break;
                case COMMIT:
                    transactions.get(operation.getTransactionId()).setState(TransactionState.COMMITED);
                    System.out.println(operation.getTransactionId() + " was committed.");
                    break;
                default: 
                    System.out.println("Unknown operation: " + operation);
                    break;
            }
            index++;
        } while (index < schedule.size());
        */

        // iterator
        Iterator<Operation> iterator = schedule.iterator();
        while (iterator.hasNext()) {
            Operation operation = iterator.next();
            System.out.println(operation.getOperationType());
            switch (operation.getOperationType()){
                case READ:
                    RecordObject record = records.get(operation.getRecord());

                    System.out.println("record has lock state " + record.getLockState() + " and value " + record.getValue() + " and is being read by transaction " + operation.getTransactionId() + ".");
                    System.out.println(record + " was read with value: " + record.getValue());

                    // If no lock existed on that record from any transactions, a Shared Lock can be acquired on it by the current transaction
                    if (record.getLockState() == LockState.NONE) {
                        record.setLockState(LockState.SHARED);
                        record.addTransactionHoldingSharedLock(transactions.get(operation.getTransactionId()));
                    } else if (record.getLockState() == LockState.SHARED) {
                        // if another transaction holds a shared lock on the record, the current transaction is added to the list of transactions holding the lock
                        record.addTransactionHoldingSharedLock(transactions.get(operation.getTransactionId()));
                    } else if (record.getLockState() == LockState.EXCLUSIVE) {
                        // If the record is locked by another transaction, the current transaction is added to the list of transactions waiting for the lock
                        record.addTransactionWaitingForLock(transactions.get(operation.getTransactionId()));
                    }

                    break;
                case WRITE:
                    RecordObject recordWrite = records.get(operation.getRecord());

                    System.out.println("record has lock state " + recordWrite.getLockState() + " and value " + recordWrite.getValue() + " and is being written by transaction " + operation.getTransactionId() + ".");
                    System.out.println(recordWrite + " was written with value: " + operation.getValue());

                    // If no lock existed on that record from any transactions, an Exclusive Lock can be acquired on it by the current transaction
                    if (recordWrite.getLockState() == LockState.NONE) {
                        recordWrite.setLockState(LockState.EXCLUSIVE);
                        recordWrite.setTransactionHoldingExclusiveLock(transactions.get(operation.getTransactionId()));
                    } else if (recordWrite.getTransactionsHoldingSharedLock().contains(operation.getTransactionId())) {
                        // if the current transaction holds a shared lock on the record, it can be upgraded to an exclusive lock
                        recordWrite.setLockState(LockState.EXCLUSIVE);
                        recordWrite.setTransactionHoldingExclusiveLock(transactions.get(operation.getTransactionId()));
                    } else if (recordWrite.getTransactionHoldingExclusiveLock() != transactions.get(operation.getTransactionId())) {
                        // If the record is locked by another transaction, the current transaction is added to the list of transactions waiting for the lock
                        transactions.get(operation.getTransactionId()).addRecordWaiting(recordWrite);
                    }
                    break;
                case COMMIT:
                    transactions.get(operation.getTransactionId()).setState(TransactionState.COMMITED);

                    // remove all locks
                    for (RecordObject recordObject : records.values()) {
                        recordObject.removeLocks(transactions.get(operation.getTransactionId()));
                        
                        // if recordobject has no locks, set lock state to none
                        if (recordObject.getTransactionHoldingExclusiveLock() == null && recordObject.getTransactionsHoldingSharedLock().size() == 0) {
                            recordObject.setLockState(LockState.NONE);
                        }

                        // if recordObject has an exclusive lock made by the transaction, remove the lock
                        if (recordObject.getTransactionHoldingExclusiveLock() == transactions.get(operation.getTransactionId())) {
                            recordObject.setTransactionHoldingExclusiveLock(null);
                        }
                    }
                    System.out.println(operation.getTransactionId() + " was committed.");
                    break;
                default: 
                    System.out.println("Unknown operation: " + operation);
                    break;
            }
            iterator.remove();
        }
    }
}
