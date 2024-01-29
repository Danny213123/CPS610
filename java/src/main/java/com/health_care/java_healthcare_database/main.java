/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.health_care.java_healthcare_database;


import java.sql.*;

/**
 *
 * @author Danny Guan
 */

public class main {
    
    public static void main(String[] args){
        get_connection connection = new get_connection();
        Connection conn = connection.GetConnection();
    }
}
