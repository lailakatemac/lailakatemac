package personbook;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
        
public class PrimaryController {
    
    @FXML
    private ListView contactList, caseNoteList;
    
    @FXML
    private Label txtCaseNote, impProL, nameL, impPersL, birthdayL, yobL, nameContact, 
            bdayContact, impProContact, impPerContact, yobContact, txtContactDetails;
    
    @FXML
    private TextField newCaseNoteF;
    
    @FXML
    private Button newContactB, newCaseNoteB, editContactB;
    
    @FXML
    private Line lineDivider;
        
    @FXML
    public void initialize() {
        setVisibility(false, false, false);

        if (DataHelper.contacts.size() > 0){
            //contacts have already been added
            for (Contact c1 : DataHelper.contacts){
                //load contact list
                contactList.getItems().add(c1.getName());
            }
        }
    }        

    @FXML
    private void createContact() throws IOException {
        Contact c = new Contact();
        //set currentcontact to 0 so there's no prefilled data in second screen
        c.setCurrentContact(0); 
        App.setRoot("contactForm");
    }
    
    @FXML
    private void editContact() throws IOException {
        App.setRoot("contactForm");
    }
    
    @FXML
    public void addCaseNote() throws IOException {
        Contact c = new Contact();
        for(Contact contact: DataHelper.contacts){
            if(contact.getCurrentContact() == contact.getContactId()){
                c = contact;
            }
        }
        //establish local date/time
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy     HH:mm:ss");  
        LocalDateTime timeNow = LocalDateTime.now();  
        
        //create new note
        CaseNote newNote = new CaseNote((String)dateTime.format(timeNow), newCaseNoteF.getText());
        
        //check if casenote arrayList has been initialised for the contact person
        if(checkCaseNotes(c) == false){//no case notes
            //create new note list & assign it to the contact person
            ArrayList<CaseNote> newNoteList = new ArrayList<CaseNote>();
            c.setCaseNotesArray(newNoteList);
        }
        //add newCase note to the Contact's caseNote array
        c.setCaseNotes(newNote);
        
        //show relevant GUI labels & add new note to listview
        newCaseNoteF.setText("");
        caseNoteList.getItems().add(newNote.toString());//THIS ONLY BIT W LISTVIEW OTHER SECTION CASENOTES ARE ADDED
        caseNoteList.setVisible(true);
    }
    
    @FXML 
    public void contactClicked() throws IOException {
        //clear casenote listview from previous contact (if any)
        caseNoteList.getItems().clear();
            
        //get selected person from listview
        String contactName = (String) contactList.getSelectionModel().getSelectedItem();
        Contact contact;
        contact = new Contact();
        
        //identify selected person from arraylist of contacts
        for(Contact c : DataHelper.contacts) {
            if (c.getName().equals(contactName)){
                contact = c;
            }
        }
        
        //show contact detail on right side of screen
        showContactDetail(contact);
        
        if (checkCaseNotes(contact) == true){//has caseNotes to display
            for (CaseNote caseNote: contact.getCaseNotes()){
                //add all items to caseNote List screen
                caseNoteList.getItems().add(caseNote.toString());//THIS IS OTHER SECTION CASENOTES ARE ADDED
            }
            caseNoteList.setVisible(true); 
        }
        //update current contact that listview is selecting
        contact.setCurrentContact(contact.getContactId());
    }
    
    @FXML 
    private void setVisibility(boolean b, boolean c, boolean d) {        
        //buttons
        editContactB.setVisible(b);
        newCaseNoteB.setVisible(b); 
        
        //labels
        nameL.setVisible(b); 
        birthdayL.setVisible(b); 
        impProL.setVisible(b); 
        impPersL.setVisible(b);
        txtCaseNote.setVisible(b);
        txtContactDetails.setVisible(b);
        lineDivider.setVisible(b);

        //contact info
        nameContact.setVisible(b);
        bdayContact.setVisible(b);
        impPerContact.setVisible(b);
        impProContact.setVisible(b);
        newCaseNoteF.setVisible(b);
        
        //optional fields (year of birth, case notes)
        caseNoteList.setVisible(d);
        yobContact.setVisible(c);
        yobL.setVisible(c);
    }
    
    @FXML
    private boolean checkCaseNotes(Contact c){
        if(c.getNumCaseNotes() == 0){
            return false;
        } else {
            return true;
        }     
    }
    
    @FXML
    private void showContactDetail(Contact contact){
        //set all information on right view when name clicked in list
        boolean dobEntered = false;
        nameContact.setText(contact.getName());
        bdayContact.setText(contact.getDob().substring(0,5));
        if(contact.getDob().length() == 10){
            //year is included
            yobContact.setText(contact.getDob().substring(6,10));
            dobEntered = true;
        }
        
        if(contact.isPersonalImportance()){
            impPerContact.setText("Yes");
        } else {
            impPerContact.setText("No");
        }

        if(contact.isProImportance()){
            impProContact.setText("Yes");
        } else {
            impProContact.setText("No");
        }
        
        setVisibility(true, dobEntered, false);

    }

    
}
