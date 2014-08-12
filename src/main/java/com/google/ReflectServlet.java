package com.google;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

public class ReflectServlet
{
    private String suffix = "Action";

    public void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {

    }

    public String[] resolveURI(String uri)
    {
        String[] uriParts = uri.split("/");
        return uriParts; 
    }
    
    public String upClassFirstChar(String className)
    {
        className = className.substring(0,1).toUpperCase() + className.substring(1);
        return className + suffix;
    }
}

