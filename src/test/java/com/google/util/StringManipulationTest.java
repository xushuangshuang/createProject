package com.google.util;

import com.util.XuShuangShuangJunit;

public class StringManipulationTest extends XuShuangShuangJunit
{
    public void test_按照斜杠将Uri分解为字符串数组()
    {
        String[] partsArray = StringManipulation.resolveURI("/reflect/contact/");
        assertTrue(partsArray instanceof String[]);
        assertEquals("reflect", partsArray[1]);
    } 
}
