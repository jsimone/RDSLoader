package com.force.loader.service;

import java.util.List;

import com.force.loader.model.schema.Column;
import com.force.loader.model.schema.Table;

public interface SchemaService {

    public List<Table> listTables();
    public List<Column> listColumns(String tableName);
}
