package com.health_care.java_healthcare_database;

import java.util.ArrayList;

public class transaction {
    public static int transaction_id;
    public static ArrayList<operation> operations = new ArrayList<operation>();

    public transaction(int transaction_id){
        transaction.transaction_id = transaction_id;
    }

    public int get_transaction_id(){
        return transaction_id;
    }

    public ArrayList<operation> get_operations(){
        return operations;
    }

    public void add_operation(operation operation){
        operations.add(operation);
    }

    public void set_transaction_id(int transaction_id){
        transaction.transaction_id = transaction_id;
    }

    public void to_string(){
        System.out.println("Transaction ID: " + transaction_id);
        for (int i = 0; i < operations.size(); i++){
            System.out.println(operations.get(i));
        }
    }
}
