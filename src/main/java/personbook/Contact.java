package personbook;

import java.util.ArrayList;

public class Contact {
    private int contactId;
    private String name;
    private String dob;
    private boolean personalImportance;
    private boolean proImportance;
    private ArrayList<CaseNote> caseNotes;
    
    private static int currentContact;
    private static int nextId = 1;
    private int numCaseNotes = 0;

    public Contact(){
        nextId++;
    }
    
    public Contact (int contactId, String name, String dob, 
            boolean personalImportance, boolean proImportance) {
        this.contactId = contactId;
        this.name = name;
        this.dob = dob;
        this.personalImportance = personalImportance;
        this.proImportance = proImportance;   
        nextId++;
    }
    
    public String getName(){
        return name;
    }

    public String getDob() {
        return dob;
    }

    public boolean isPersonalImportance() {
        return personalImportance;
    }

    public boolean isProImportance() {
        return proImportance;
    }


    public ArrayList<CaseNote> getCaseNotes() {
        return caseNotes;
    }

    public void setCaseNotes(CaseNote c1) {
        this.caseNotes.add(c1);
        setNumCaseNotes(getNumCaseNotes() + 1);
    }
    
    public void setCaseNotesArray(ArrayList<CaseNote> caseNotes) {
        this.caseNotes = caseNotes;
    }
    
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public static int getNextId() {
        return nextId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPersonalImportance(boolean personalImportance) {
        this.personalImportance = personalImportance;
    }

    public void setProImportance(boolean proImportance) {
        this.proImportance = proImportance;
    }

    public static int getCurrentContact() {
        return currentContact;
    }

    public static void setCurrentContact(int currentContact) {
        Contact.currentContact = currentContact;
    }

    public int getNumCaseNotes() {
        return numCaseNotes;
    }
    
    public void setNumCaseNotes(int i) {
        this.numCaseNotes = i;
    }


}
