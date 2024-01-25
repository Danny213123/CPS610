/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.health_care.java_healthcare_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 666on
 */
public class get_connection {
    private static final String USERNAME = "d1guan";
    private static final String PASSWORD = "08081498";
    private static final String CONNECTION = "oracle.scs.ryerson.ca:1521:orcl";
    
    private static Connection conn1;
    
    public get_connection (){
        
        //patient_editor_app edit = new patient_editor_app(6, "Danny", "Guan", "dannyguan21@gmail.com", "2", 20);
        
        //edit.setVisible(true);
        
        String dbURL1 = "jdbc:oracle:thin:" + USERNAME + "/" + PASSWORD + "@" + CONNECTION;
        try {
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected with oracle.");
            }
        } catch (SQLException error) {
            System.out.println("Issue: " + error);
        }
    }
    
    public static MyResultArrayList ConvertMetaDataToArrayList(int cols, ResultSetMetaData rsmd, ResultSet rs) {
        ArrayList colName = new ArrayList(cols);
        ArrayList data = new ArrayList();

        try {
            for (int i = 1; i <= cols; i++) {
                colName.add(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                ArrayList row = new ArrayList(cols);

                for (int i = 1; i <= cols; i ++) {

                    row.add(rs.getObject(i));

                }

                data.add(row);
            }
        } catch (SQLException error) {
            System.out.println(error);
        }
        
        return new MyResultArrayList(colName, data);
    }
    
    public static MyResultVector ArrayListToVector(int cons, ArrayList colName, ArrayList data) {
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < colName.size(); i++ )
            columnNamesVector.add(colName.get(i));
        
        return new MyResultVector(columnNamesVector, dataVector);
    }
    
    public static JTable createTable(Vector dataVector, Vector columnNamesVector) {
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
        });
        
        return table;
    }
    
    public static void RemoveRow(JTable table, int row) {
        ((DefaultTableModel)table.getModel()).removeRow(row);
    }
    
    public static void GetRow(JTable table, int row) {
        //table.getValueAt(row);
    }
    
    public static Connection GetConnection(){
        return conn1;
    }
    
    public static JTable PopulatePatientTable(Connection conn) {
        String query = "SELECT DISTINCT FirstName, LastName, PhoneNumber, Email FROM Patient ORDER BY LastName";
        
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int cols = rsmd.getColumnCount();
            
            MyResultArrayList ResultArrayList = ConvertMetaDataToArrayList(cols, rsmd, rs);
            
            ArrayList colName = ResultArrayList.getFirst();
            ArrayList data = ResultArrayList.getSecond();
            
            MyResultVector ResultVector = ArrayListToVector(cols, colName, data);
            
            Vector colNameVector = ResultVector.getFirst();
            Vector dataVector = ResultVector.getSecond();
            
            JTable patient_table = createTable(dataVector, colNameVector);
            
            return patient_table;
        } catch (SQLException error) {
            System.out.println(error);
        }
        return null;
    }
    
    public static JTable PopulateDoctorTable(Connection conn) {
        String query = "SELECT DISTINCT Specialization, FirstName, LastName FROM Doctor ORDER BY Specialization";
        
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int cols = rsmd.getColumnCount();
            
            MyResultArrayList ResultArrayList = ConvertMetaDataToArrayList(cols, rsmd, rs);
            
            ArrayList colName = ResultArrayList.getFirst();
            ArrayList data = ResultArrayList.getSecond();
            
            MyResultVector ResultVector = ArrayListToVector(cols, colName, data);
            
            Vector colNameVector = ResultVector.getFirst();
            Vector dataVector = ResultVector.getSecond();
            
            JTable doctor_table = createTable(dataVector, colNameVector);
            
            return doctor_table;
        } catch (SQLException error) {
            System.out.println(error);
        }
        return null;
    }
}
