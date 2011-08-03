package com.force.loader.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.force.loader.model.schema.Column;
import com.force.loader.model.schema.Table;

public class SchemaServiceImpl implements SchemaService {

    private static String getJDBCUrl() {
        return System.getenv("MYSQL_JDBC_URL");
    }
    
    private Connection getConnection() {
        
        Connection conn = null;
        
        try {            
            conn = DriverManager.getConnection(getJDBCUrl());
            
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        } 
        
        return conn;
    }
    
    @Override
    public List<Table> listTables() {
        Connection conn = null;
        ResultSet results = null;
        List<Table> tables = new ArrayList<Table>();
        
        try {            
            conn = getConnection();
            
            DatabaseMetaData metaData = conn.getMetaData();
            results = metaData.getTables(null, null, "%", null);
            
            while(results.next()) {
                Table table = new Table();
                table.setName(results.getString("TABLE_NAME"));
                table.setColumns(listColumns(table.getName()));
                tables.add(table); 
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if(results != null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        return tables;
    }

    @Override
    public List<Column> listColumns(String tableName) {
        Connection conn = null;
        ResultSet results = null;
        List<Column> columns = new ArrayList<Column>();
        
        try {            
            conn = getConnection();
            
            DatabaseMetaData metaData = conn.getMetaData();
            results = metaData.getColumns(null, null, tableName, "%");
            
            while(results.next()) {
                Column column = new Column();
                column.setName(results.getString("COLUMN_NAME"));
                column.setTypeName(results.getString("TYPE_NAME"));
                column.setType(results.getInt("DATA_TYPE"));
                column.setSize(results.getInt("COLUMN_SIZE"));
                column.setDecimalDigits(results.getInt("DECIMAL_DIGITS"));
                columns.add(column);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if(results != null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        return columns;
    }

}
