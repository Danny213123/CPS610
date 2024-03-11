package com.health_care.java_healthcare_database;

public class write {
    
    private static int record_id;
    private static int value;

    public write(int record_id, int value){
        write.record_id = record_id;
        write.value = value;
    }

    public static int get_record_id(){
        return record_id;
    }

    public static int get_value(){
        return value;
    }
}
