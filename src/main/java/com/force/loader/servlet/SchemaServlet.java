package com.force.loader.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.force.loader.model.schema.Column;
import com.force.loader.model.schema.Table;
import com.force.loader.service.SchemaService;
import com.force.loader.service.SchemaServiceImpl;

/**
 * Responds to get and post requests with a 'hello, world'
 */
public class SchemaServlet extends HttpServlet {

    SchemaService schemaService = new SchemaServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("TABLES:");
        
        List<Table> tables = schemaService.listTables();
        
        for(Table table : tables) {
            out.println("");
            out.println(table.getName() + ":");
            List<Column> columns = table.getColumns();
            for(Column column : columns) {
                out.println(column.toString());
            }
        }
        
        out.close();        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}

