package com.health_care.java_healthcare_database;

import java.util.ArrayList;

public class transaction {
    public int transactionId;
    public ArrayList<operation> operations = new ArrayList<operation>();
    public ArrayList<recordObj> lockedRecords = new ArrayList<recordObj>();

    public transaction(int transaction_id){
        this.transactionId = transaction_id;
    }

    public int get_transaction_id(){
        return transactionId;
    }

    public ArrayList<operation> get_operations(){
        return operations;
    }

    public void add_operation(operation operation){
        operations.add(operation);
    }

    public void set_transaction_id(int transaction_id){
        this.transactionId = transaction_id;
    }

    public void to_string(){
        System.out.println("Transaction ID: " + transactionId);
        for (int i = 0; i < operations.size(); i++){
            System.out.println(operations.get(i));
        }
    }
}
