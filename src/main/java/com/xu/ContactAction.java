package com.xu;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import com.baldur.Contact;
import javax.servlet.ServletException;

public class ContactAction
{
    public String list(HttpServletRequest req, HttpServletResponse resp) 
        throws IOException, ServletException
    {
        //resp.getWriter().println("benben");
        System.out.println("xs");
        return "list";
        //List<Contact> contactList = contactService.getAllContactList();
        //req.setAttribute("contactList", contactList);
        
    }
}
