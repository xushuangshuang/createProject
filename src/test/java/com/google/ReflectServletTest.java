package com.google;

import com.util.XuShuangShuangJunit;

public class ReflectServletTest extends XuShuangShuangJunit
{
    public void test_将获取来的Uri进行分解并获取指定的部分()
    {
        ReflectServlet reflectServlet = new ReflectServlet();
        String[] uriParts = reflectServlet.resolveURI("/reflect/contact");
        assertEquals("reflect", uriParts[1]);
        assertEquals("contact", uriParts[2]);
    }
}
