
package com.health_care.java_healthcare_database;

public class test {
    public static void main(String[] args) {

        transaction t1 = new transaction(1);

        recordObj r1 = new recordObj(1);

        operation read1 = new operation("read", 1, 1);
 
        operation write1 = new operation("write", 1, 5, 1);

        t1.add_operation(read1);
        t1.add_operation(write1);

        locking_protocol protocol = new locking_protocol();

        protocol.addRecord(r1);
        protocol.addTransaction(t1);

        System.out.println("record object list: " + protocol.records);
        System.out.println("record ID list: [");
        for (recordObj r: protocol.records) {
            System.out.println(r.recordId);
        }
        System.out.println("]");

        protocol.lock(read1);
        System.out.println("record R1 state: " + r1.state);
        System.out.println("transaction T1 records: " + t1.lockedRecords);

        protocol.lock(write1);
        System.out.println("record R1 state: " + r1.state);
        System.out.println("transaction T1 records: " + t1.lockedRecords);
    }
}
