package com.health_care.java_healthcare_database;

public class read {
    
    private static int record_id;

    public read(int record_id){
        read.record_id = record_id;
    }

    public static int get_record_id(){
        return record_id;
    }

}
