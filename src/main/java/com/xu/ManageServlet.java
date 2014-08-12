package com.xu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.regex.Pattern;
import java.lang.reflect.Method;
import java.util.regex.Matcher;

public class ManageServlet extends HttpServlet
{  
    String projectPackage = "com.xu.";
    Object result = null;
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException
    {    
        System.out.println(req.getRequestURI());
        System.out.println(assertFile(req.getRequestURI()));
        if(!assertFile(req.getRequestURI()))
        {
           doPost(req,resp);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException
    {
        Object result = null;
        try
        {
            String methodName = resolveURI(req.getRequestURI(),3);
            String className = resolveURI(req.getRequestURI(),2);
            Class clazz = Class.forName(projectPackage 
                   + capitalizeFirstLetter(className));
            result = runMethod(clazz, methodName, req, resp);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println((String)result);
        show(req,resp,(String)result);   
    }

    public boolean assertFile(String uri)
    {
        boolean itIsFile = uri.contains(".");
        return  itIsFile;
    }

    public Object runMethod (Class clazz, String methodName, HttpServletRequest req, 
            HttpServletResponse resp) throws Exception
    {
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod(methodName, 
                    HttpServletRequest.class, HttpServletResponse.class);
        System.out.println("DONING :" + method);
     
        return method.invoke(obj, req, resp);
    }

    public String resolveURI(String URI, int index)
    {
        Pattern pattern = Pattern.compile("/");
        String[] resolveURI = pattern.split(URI);
        
        return resolveURI[index];
    }

    public String capitalizeFirstLetter(String className)
    {
        className = className.substring(0,1).toUpperCase()
            + className.substring(1) + "Action";
        System.out.println("CLASS : " + className);
        return className;
    }
    public void show(HttpServletRequest req, HttpServletResponse resp,
            String page) 
        throws IOException , ServletException
    {
         getServletContext()
             .getRequestDispatcher("/WEB-INF/jsp/" + page + ".jsp")
             .forward(req, resp);
    } 
}
