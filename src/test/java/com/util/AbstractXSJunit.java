package com.util;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import org.reflections.Reflections;
import java.util.Set;

public abstract class AbstractXSJunit
{
    static Boolean consequence = true;
    static int testSuccess = 0; 
    static int testFail = 0;
    static int testClass = 0;

    public static void main(String[] args)
    {
        try
        {
            assertInput(args);
            outputTestConsequence(consequence);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    protected static void assertInput(String[] args) throws Exception
    {
        if(args.length > 0)
        {
            getAllTestPackage(args);
        }
        else
        {
            System.out.println("DO not input testpackage");
        }
    }


    protected static void getAllTestPackage(String[] args) throws Exception
    {
        String testPackage;
        for(int paraTestPackage = 0; paraTestPackage< args.length; paraTestPackage++)
        {
            System.out.println("TESTING  : " + paraTestPackage);
            testPackage = args[paraTestPackage];
            getAllTestCaseClass(testPackage);    
        }
    }
    
    protected static void getAllTestCaseClass(String testPackage) throws Exception
    {
        Reflections reflections = new Reflections(testPackage);
        Set<Class<? extends AbstractXSJunit>> allTestCaseClass = 
                reflections.getSubTypesOf(AbstractXSJunit.class);
        getTestCaseClass(allTestCaseClass);
    }

    protected static void getTestCaseClass(Set<Class<? extends AbstractXSJunit>> allTestCaseClass) throws Exception
    {
        for(Class clazz : allTestCaseClass)
        {
            System.out.println("TESTING CLASS :" + clazz.getName() + "It's" + testClass++);
            runAllTest(clazz);
        }
    }
    protected static void runAllTest(Class clazz) throws Exception
    {
        for(Method method : getAllMethods(clazz))
        {
            System.out.println("TESTING method :" + method);
            Object obj = clazz.newInstance();
            method.invoke(obj);
        }
    }

    protected static List<Method> getAllMethods(Class clazz)
    {
        List<Method> list = new ArrayList<Method>();

        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods)
        {
            if(method.getName().startsWith("test"))
            {
                System.out.println("TESTING :" + method);
                list.add(method);
            }
        }
        return list;
    }

    protected static void outputTestConsequence(boolean consequence)
    {
        if(consequence)
        {
            System.out.println("TEST SUCCESS");
        }
        else
        {
            System.out.println("TEST FAIL");
        }
    }   
    protected void outputFailResult(Object expectedResult, Object actualResult)
    {
         testFail++;
         consequence = false;
         System.err.println(" ERROR  EXCEPTED : " 
                 + expectedResult + " BUT ACTUAL : " + actualResult);  
    }

}
