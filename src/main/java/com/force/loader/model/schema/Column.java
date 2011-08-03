package com.force.loader.model.schema;


public class Column {

    private String name;
    private String typeName;
    private int type;
    private int size;
    private int decimalDigits;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getDecimalDigits() {
        return decimalDigits;
    }
    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }
    
    @Override
    public String toString() {
        return "name: " + name 
            + ", type: " + typeName 
            + ", size: " + size 
            + ", decimal digits: " + decimalDigits;
    }

    
}
