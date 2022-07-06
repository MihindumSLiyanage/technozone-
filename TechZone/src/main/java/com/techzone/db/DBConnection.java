package com.techzone.db;

import com.techzone.item.Cart;
import com.techzone.item.ComboItem;
import com.techzone.item.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class DBConnection {
    
    public final static String[] LAPTOP_COLUMNS     = {"itemNumber","model","brand","processor","graphicCard","ram","diskType","diskDescription","operatingSystem","price","quantity","warranty"};
    public final static String[] ACCESSORY_COLUMNS  = {"itemNumber","model","brand","itemType","description","price","quantity","warranty"};
    public final static String[] PRINTER_COLUMNS    = {"itemNumber","model","brand","color","speed","price","quantity","warranty"};
    public final static String[] CUSTOMER_COLUMS    = {"customerid","firstname","lastname","email","contactnumber"};
    
    
    public static Connection getConnection(){
      
        Connection connection = null;
      
        String url = "jdbc:mysql://localhost:3306/technozone";
        String user = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is Successful to the database" + url);

        } catch (Exception e) {
            System.out.println("Unable to connect to database : " + e.getMessage());
        }
        return connection;
    }
    
    public void loadTableData(DefaultTableModel tableModel, String query, String[] columns){
        Connection connection = null;
        try {
            connection = getConnection();
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            tableModel.setRowCount(0);  
            
            while (resultSet.next()) {
                Object rowData[] = new Object[columns.length];
                int i = 0;
                for(String column : columns){
                    rowData[i] = resultSet.getString(column);
                    i++;
                }                                      
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Unable to get the results : " + ex.getMessage() );
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Unable to close the connection");
                }
            }
        }        
    }
    
    public boolean saveItem(String query){
        Connection connection = null;
        boolean success = false;
        try {
            connection = getConnection();
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();   
            
            success = true;
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());
            success = false;
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Unable to close the connection");
                }
            }
        }
        return success;
    }
    
    public int getItemCount(String query){
        Connection connection = null;
        int rowCount = 0;
        System.out.println("HHHHHHHHHHHHHHHHHHH");
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            rowCount = resultSet.getInt(1);  
            System.out.println("sssssssssssss = " +rowCount);
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Unable to close the connection");
                }
            }
        }
        return rowCount;
    }
    
    public boolean removeItem(String table, String id){
        Connection connection = null;
        boolean success = false;
        try {
            connection = getConnection();
            String query = "DELETE FROM " + table + " WHERE itemnumber = '" + id + "'";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            success = true;
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());
            success = false;
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Unable to close the connection");
                }
            }
        }
        return success;
    }
    
    public ResultSet getItem(String table, String id){
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String query = "SELECT * FROM " + table + " WHERE itemnumber = '" + id + "'";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(); 
            
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        }
        return resultSet;
    }
    
    public ResultSet getUser(String table, String id){
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String query = "SELECT * FROM " + table + " WHERE customerid = '" + id + "'";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(); 
            
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        }
        return resultSet;
    }
    
    public ResultSet updateItem(String query){
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate(); 
            
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        }
        return resultSet;
    }
    
    public void setComboValues(JComboBox<String> jComboBox1, String query, String column){
        Connection connection;
        try {
            connection = getConnection();
                        
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while(resultSet.next()){
                String brand = resultSet.getString(column);
                jComboBox1.addItem(brand);
            }            
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        }
    }
    
    public void setModelComboValues(JComboBox<ComboItem> jComboBox1, String query, String column){
        Connection connection;
        try {
            connection = getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while(resultSet.next()){
                String model = resultSet.getString(column);
                String id = resultSet.getString("itemnumber");
                jComboBox1.addItem(new ComboItem(id, model));
            }            
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        }
    }
    
    public void setUserComboValues(JComboBox<ComboItem> jComboBox1){
        Connection connection;
        try {
            connection = getConnection();
            String query = "SELECT * FROM customer"; 
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            jComboBox1.removeAllItems();           
            while(resultSet.next()){
                String id = resultSet.getString("customerid");
                String fName = resultSet.getString("firstname");
                String lName = resultSet.getString("lastname");
                jComboBox1.addItem(new ComboItem(id, fName + " " + lName));
            }            
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        }
    }
    
    public void saveCart(Cart cart, int index){
        
        String cQuery = "SELECT COUNT(*) FROM bill";
        int count = getItemCount(cQuery);
        System.out.println("count = " + count);
        String query = "INSERT INTO bill(Bid,itemtype,itemid,customerid,salesprice,date) VALUES ";
        
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String imQuery = "";
        Item[] items = cart.getItems();
        for(int i = 0; i < index; i++ ){
            int itemId = count + i + 1;
            String subQuery = "('S" + itemId + "','";
            if(items[i].getItemNumber().startsWith("L")){
                subQuery = subQuery + "LAPTOP','" + items[i].getItemNumber() + "','" 
                        + cart.getCustomer().getCustomerid() + "'," + items[i].getPrice() + ",'" + date + "')" ;
            }
            else {
               subQuery = subQuery + "ACCESSORY','" + items[i].getItemNumber() + "','"
                       + cart.getCustomer().getCustomerid() + "'," + items[i].getPrice() + ",'" + date + "')";
            }   
            imQuery = imQuery + subQuery;
            if(i != index -1){
               imQuery = imQuery + ","; 
            }
        }
        query = query + imQuery;

        Connection connection = getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    
    public void getSalesforDate(DefaultTableModel tableModel, String query){
               
        Connection connection;
        try {
            connection = getConnection();
            String dbquery = "SELECT * FROM bill WHERE " + query;
            System.out.println(dbquery);
            PreparedStatement preparedStatement = connection.prepareStatement(dbquery);
            ResultSet resultSet = preparedStatement.executeQuery();
            tableModel.setRowCount(0);  
            
            while (resultSet.next()) {
                Object rowData[] = new Object[4];
                rowData[0] = resultSet.getString("itemtype");                     
                rowData[3] = resultSet.getString("salesprice");
                if(resultSet.getString("itemid").startsWith("L")){
                    ResultSet resultSet1 = getItem("laptop", resultSet.getString("itemid"));
                    resultSet1.next();
                    rowData[1] = resultSet1.getString("model");   
                    rowData[2] = resultSet1.getString("brand"); 
                }
                else {
                    ResultSet resultSet1 = getItem("accessory", resultSet.getString("itemid"));
                    resultSet1.next();
                    rowData[1] = resultSet1.getString("model");   
                    rowData[2] = resultSet1.getString("brand");
                }
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Unable to get the results : " + ex.getMessage() );        
        } 
    }
    
    public void removeCustomer(String query){
        Connection connection;
        try {
            connection = getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeQuery();            
        } catch (SQLException ex) {           
            System.out.println("Unable to get the results : " + ex.getMessage());            
        }
    }
}
