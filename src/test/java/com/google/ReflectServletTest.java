package com.google;

import com.util.XuShuangShuangJunit;

public class ReflectServletTest extends XuShuangShuangJunit
{
    public void test_分解指定的Uri依照斜杠()
    {
        ReflectServlet reflectServlet = new ReflectServlet();
        String[] uriParts = reflectServlet.resolveURI("/reflect/contact");
        assertEquals("reflect", uriParts[1]);
        assertEquals("contact", uriParts[2]); 
    }
}
