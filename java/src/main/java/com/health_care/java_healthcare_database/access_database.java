/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.health_care.java_healthcare_database;


import java.io.IOException;
import java.sql.*;

/**
 *
 * @author Danny Guan
 */

public class access_database {
    
    public static void main(String[] args){
        Connection conn = get_connection.return_connection();

        try {
            part_one(conn);
        } catch (SQLException error) {
            System.out.println("Issue: " + error);
        }
    }

    // Returns the grade point average of a student given their name
    public static void part_one(Connection conn) throws SQLException {
        String name;
        String grade;
        int credit;

        String stmt1 = "SELECT G.grade, C.credit_hours FROM student S, grade_report G, section SEC, course C WHERE G.student_number=S.student_number AND G.section_identifier=SEC.section_identifier AND SEC.course_number=C.course_number AND S.name=?"; // Remove the semicolon at the end of the SQL statement

        PreparedStatement p = conn.prepareStatement(stmt1);
        name = readEntry("Please enter your name: ");
        p.clearParameters();
        p.setString(1, name);
        ResultSet r = p.executeQuery();
        double count=0, sum=0, avg=0;
        while(r.next()) {
            System.out.println(r.getString(1) + " " + r.getInt(2));
            grade = r.getString(1);
            credit = r.getInt(2);
            switch (grade) {
                case "A": sum=sum+(4*credit); count=count+1; break;
                case "B": sum=sum+(3*credit); count=count+1; break;
                case "C": sum=sum+(2*credit); count=count+1; break;
                case "D": sum=sum+(1*credit); count=count+1; break;
                case "F": sum=sum+(0*credit); count=count+1; break;
                default: System.out.println("This grade "+grade+" will not be calculated."); break;
            }
        }
        avg = sum/count;
        System.out.println("Student named "+name+" has a grade point average "+avg+".");
        r.close();
    }

    static String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while(c != '\n' && c != -1) {
                buffer.append((char)c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }
}
