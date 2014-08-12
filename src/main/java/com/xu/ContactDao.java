package com.xu;

import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baldur.Contact;

public class ContactDao
{
    public List<Contact> getAllContactList()
    {
        DBService dbService = DBService.newInstance();
        List<Contact> listContact = new ArrayList<Contact>();
        String listSql = "SELECT * FROM contant";
        
        try
        { 
            ResultSet rs = dbService.executeQuery(listSql);
            while(rs.next())
            {
                Contact contact = new Contact();
                contact.setUsername(rs.getString("contant_name"));
                contact.setEmail(rs.getString("contant_email"));
                contact.setMobile(rs.getLong("phone"));
                contact.setHomeAddress(rs.getString("address"));
                listContact.add(contact);
            }
            System.out.println("RESULT : " + listContact);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return listContact;
    }
}
