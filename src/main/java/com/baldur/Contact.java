package com.baldur;

public class Contact
{
    private String username;
    private String email;
    private Long mobile;
    private int vpmn;
    private String home_address;
    private String office_address;
    private String memo;
    private String groups;
    private String job;
    private int job_level;
    private Long id;
    
    public void setId(Long id)
    {
        this.id = id;
    }   
    public Long getId()
    {
        return id;
    } 
    public void setJob(String job)
    {
        this.job = job;
    }
    public String getJob()
    {
        return job;
    }
    public void setJobLevel(int job_level)
    {
        this.job_level = job_level;
    }
    public int getJobLevel()
    {
        return job_level;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getUsername()
    {
        return username;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }
    public void setMobile(Long mobile)
    {
        this.mobile = mobile;
    }
    public Long getMobile()
    {
        return mobile;
    }
    public void setVpmn(int vpmn)
    {
        this.vpmn = vpmn;
    }
    public int getVpmn()
    {
        return vpmn;
    }
    public void setHomeAddress(String home_address)
    {
        this.home_address = home_address;
    }
    public String getHomeAddress()
    {
        return home_address;
    }
    public void setOfficeAddress(String office_address)
    {
        this.office_address = office_address;
    }
    public String getOfficeAddress()
    {
        return office_address;
    }
    public void setMemo(String memo)
    {
        this.memo = memo;
    }
    public String getMemo()
    {
        return memo;
    }
    public void setGroups(String groups)
    {
        this.groups = groups;
    }
    public String getGroups()
    {
        return groups;
    }
}
