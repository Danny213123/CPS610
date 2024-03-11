package com.health_care.java_healthcare_database;

import java.util.ArrayList;

public class transaction {
    private static int transaction_id;
    private static ArrayList<Object> operations = new ArrayList<Object>();

    public transaction(int transaction_id){
        transaction.transaction_id = transaction_id;
    }

    public int get_transaction_id(){
        return transaction_id;
    }

    public ArrayList<Object> get_operations(){
        return operations;
    }

    public void add_operation(Object operation){
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
