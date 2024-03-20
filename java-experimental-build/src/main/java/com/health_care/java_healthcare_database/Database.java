package com.health_care.java_healthcare_database;

import java.util.HashMap;
import java.util.ArrayList;

public class Database {
    private HashMap<Integer, Transaction> transactions;
    private HashMap<Integer, RecordObject> records;
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
    public void run(){
        ArrayList<Operation> schedule = scheduler();

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
    }
}
