package com.util;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import org.reflections.Reflections;
import java.util.Set;

public abstract class XuShuangShuangJunit extends AbstractXSJunit
{
    static int testSuccess = 0;
    static int testClass = 0;
    static int testSum = 0;

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

    public static void assertInput(String[] args) throws Exception
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


    public static void getAllTestPackage(String[] args) throws Exception
    {
        String testPackage;
        for(int paraTestPackage = 0; paraTestPackage< args.length; paraTestPackage++)
        {
            testPackage = args[paraTestPackage];
            System.out.println("TESTING  : " + paraTestPackage+1 
                    + "  PACKAGE " + args[paraTestPackage]);
            getAllTestCaseClass(testPackage);    
        }
    }
    
    public static void getAllTestCaseClass(String testPackage) throws Exception
    {
        Reflections reflections = new Reflections(testPackage);
        Set<Class<? extends XuShuangShuangJunit>> allTestCaseClass = 
                reflections.getSubTypesOf(XuShuangShuangJunit.class);
        getTestCaseClass(allTestCaseClass);
    }

    public static void getTestCaseClass(
            Set<Class<? extends XuShuangShuangJunit>> allTestCaseClass) throws Exception
    {
        for(Class clazz : allTestCaseClass)
        {
            testClass++;
            System.out.println("TESTING CLASS :" + clazz.getName() 
                    + "  It's  " + testClass);
            runAllTest(clazz);
        }
    }
    public static void runAllTest(Class clazz) throws Exception
    {
        for(Method method : getAllMethods(clazz))
        {
            System.out.println("TESTING method :" + method);
            Object obj = clazz.newInstance();
            method.invoke(obj);
        }
    }

    public static List<Method> getAllMethods(Class clazz)
    {
        List<Method> list = new ArrayList<Method>();

        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods)
        {
            testSum++;
            if(method.getName().startsWith("test"))
            {
                list.add(method);
            }
        }
        return list;
    }   
    
    public static void outputTestConsequence(boolean consequence)
    {
        if(consequence)
        {
            System.out.println("TEST CLASS " + testClass 
                    + " TEST SUM " + testSum);
            System.out.println("TEST SUCCESS");
        }
        else
        {
            System.out.println("TEST SUM " + testSum 
                    + "  TEST FAIL " + testFail);
            System.out.println("TEST FAIL");
        }
    }
}
