package com.force.loader.model.schema;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private String name;
    private List<Column> columns;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Column> getColumns() {
        return columns;
    }
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
    
    public void addColumn(Column column) {
        if(columns == null) {
            columns = new ArrayList<Column>();
        }
        
        columns.add(column);
    }
}
