package personbook;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHelper {
    
    public static ArrayList<Contact> contacts = new ArrayList<>();
    
    public static void preloadData() {
        
        Contact c1 = new Contact(1, "John Smith", "30/03/2001", true, true);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(), "Kerry Woods", "22/11/1998", true, false);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(), "Lola Nickleson", "13/03", true, false);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(), "Sam Jones", "17/12/2004", false, true);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"Jason Li", "01/01/1984", false, false);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"Sarah Williams", "23/09/1968", true, true);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"Neeraj Praja", "16/11", false, true);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"Sophie Link", "29/07/1936", true, false);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"Amanda Rin", "05/06/1976", false, false);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"Jolene Parton", "31/01/2000", false, true);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"David Kerrigan", "27/05/1994", false, true);
        DataHelper.contacts.add(c1);
        c1 = new Contact(c1.getNextId(),"Mikayla Chen", "28/02/1988", true, false);
        DataHelper.contacts.add(c1);
        
        
        
    }
            
}

