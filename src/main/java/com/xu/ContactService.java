package com.xu;

import java.util.List;
import java.util.ArrayList;
import com.baldur.Contact;

public class ContactService
{
    ContactDao contactDao = new ContactDao();

    public List<Contact> getAllContactList()
    {
        List<Contact> contactList = contactDao.getAllContactList();

        return contactList;
    }
}
