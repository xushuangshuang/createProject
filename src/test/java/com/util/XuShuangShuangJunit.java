package com.util;

public class XuShuangShuangJunit extends AbstractXSJunit
{   
    public void assertEquals(String exceptedResult, String actualResult)
    {
        equals(exceptedResult, actualResult);        
    }

    public void assertNull(Object actualResult)
    {
         equals(null, actualResult);
    }

    public void assertTrue(boolean actualResult)
    {
         equals(true, actualResult);
    }

    public void assertFalse(boolean actualResult)
    {
         equals(false, actualResult);
    }

    public void assertArrayEquals(Object[] exceptedResult, Object[] actualResult)
    {
        if(((Integer)exceptedResult.length).equals((Integer)actualResult.length))
        {
            ergodicArray(exceptedResult, actualResult);
        }
        else
        {
            outputFailResult(exceptedResult, actualResult);
        }
    }

    private void ergodicArray(Object[] exceptedResult, Object[] actualResult)
    {
        for(int index = 0; index < exceptedResult.length; index++)
        {
            equals(exceptedResult[index], actualResult[index]);
        }
    }

    public boolean equals(Object expectedResult, Object actualResult) 
    {
        if(!expectedResult.equals(actualResult))
        {
            outputFailResult(expectedResult, actualResult);
        }
        else
        {
            return true;
        }

        return false;
    }
}
