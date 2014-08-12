package com.xu;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class DBService
{
    PreparedStatement pstmt = null;
    Connection conn = null;

    public static DBService newInstance()
    {
        DBService dbService = new DBService();
        try
        {
            dbService.conn = dbService.createConnection();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return dbService;
    }

    static final String JDBCDriver = "com.mysql.jdbc.Driver";
    static final String JDBCURI = "jdbc:mysql://localhost/test?user=root&password=";                 
    public Connection createConnection() throws SQLException
    {
        try
        {
            Class.forName(JDBCDriver).newInstance();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return DriverManager.getConnection(JDBCURI);
    }
    public DBService prepare(String sql) throws SQLException
    {
        pstmt = conn.prepareStatement(sql);
        return this;
    }

    public ResultSet executeQuery() throws SQLException
    {
        return pstmt.executeQuery();
    }

    public ResultSet executeQuery(String sql) throws SQLException
    {
        prepare(sql);
        return pstmt.executeQuery();
    }
}
