/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.health_care.java_healthcare_database;

import java.sql.*;
import java.io.*;

/**
 *
 * @author 666on
 */
public class get_connection {
    // private static final String USERNAME = "";
    // private static final String PASSWORD = "";
    // private static final String CONNECTION = "oracle.scs.ryerson.ca:1521:orcl";
    
    private static Connection conn;
    
    public get_connection (){

        String USERNAME, PASSWORD, CONNECTION;
        String name;
        char grade;
        int credit;

        USERNAME = readEntry("Enter Database account username: ");
        PASSWORD = readEntry("Enter Database account password: ");
        CONNECTION = readEntry("Enter Database connection: ");

        String dbURL1 = "jdbc:oracle:thin:" + USERNAME + "/" + PASSWORD + "@" + CONNECTION;
        try {
            conn = DriverManager.getConnection(dbURL1);
            if (conn != null) {
                System.out.println("Connected with oracle.");

            }
        } catch (SQLException error) {
            System.out.println("Issue: " + error);
        }
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
    
    public static Connection GetConnection(){
        return conn;
    }

}
