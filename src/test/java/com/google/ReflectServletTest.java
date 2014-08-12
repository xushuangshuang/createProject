package com.google;

import com.util.XuShuangShuangJunit;

public class ReflectServletTest extends XuShuangShuangJunit
{
    ReflectServlet reflectServlet = new ReflectServlet();
    public void test_分解不以斜杠结尾的Uri依照斜杠()
    {
        String[] uriParts = reflectServlet.resolveURI("/reflect/contact");
        assertEquals("reflect", uriParts[1]);
        assertEquals("contact", uriParts[2]); 
    }
    
    public void test_分解以斜杠结尾的Uri依照斜杠划分()
    {
        String[] uriParts = reflectServlet.resolveURI("/reflect/contact/");
        assertEquals("reflect", uriParts[1]);
        assertEquals("contact", uriParts[2]); 
    }
    public void test_将获取到的类名首字母大写()
    {
        String className = reflectServlet.upClassFirstChar("contact");
        assertEquals("ContactAction", className);
    }
}
