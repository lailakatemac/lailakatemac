package personbook;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SecondaryController {
    @FXML 
    private TextField nameField, dField, mField, yField;
    
    @FXML
    private CheckBox personalTick, professionalTick;
    
    @FXML 
    private Label errorMsgL;
    
    @FXML
    public void initialize() {
        
        errorMsgL.setVisible(false);
        Contact editingContact = new Contact();
        //only if edit button clicked
        if (editingContact.getCurrentContact() != 0){
            editingContact = currentContact();
            
            //set all fields 
            nameField.setText(editingContact.getName());
            dField.setText(editingContact.getDob().substring(0,2));
            mField.setText(editingContact.getDob().substring(3,5));
            if(editingContact.getDob().length() > 5){
                yField.setText(editingContact.getDob().substring(6,10));
            }
            if (editingContact.isPersonalImportance()){
                personalTick.setSelected(true);
            }
            if (editingContact.isProImportance()){
                professionalTick.setSelected(true);
            }        
        }  
    }

    @FXML
    private void saveChanges() throws IOException {
        //if id exists in file then already a contact 
        //if id doesn't exist then no contact
        Contact newContact = new Contact();
        if (checkFields()){
            if(newContact.getCurrentContact() == 0){
                //must create new contact as create button was pressed
                DataHelper.contacts.add(newContact);
                newContact.setContactId(newContact.getNextId());
            } else {
                newContact = currentContact();
            }
            //set all fields
            //name
            newContact.setName(nameField.getText());
            //dob
            if (yField.getText().isEmpty()){
                newContact.setDob(dField.getText() + "/" + mField.getText());
            } else {
                newContact.setDob(dField.getText() + "/" + mField.getText() 
                    + "/" + yField.getText());
            }
            //personal and professional contact check
            if (personalTick.isSelected()){
               newContact.setPersonalImportance(true);            
            }
            if (professionalTick.isSelected()){
                newContact.setProImportance(true);
            }
            App.setRoot("masterDetail");

        } else {
            errorMsgL.setText("Error: Must fill in all fields except birthday year.");
            errorMsgL.setVisible(true);
        }
    }
    
    @FXML 
    void switchToMasterView() throws IOException {
            App.setRoot("masterDetail");
    }
    
    @FXML
    private boolean checkFields(){
        if (nameField.getText().equals("") || dField.getText().equals("") 
                || mField.getText().equals("")){
            return false;
        } else {
            return true;
        }
    }
    
    //function that returns the object of the current ID
    @FXML
    private Contact currentContact(){        
        Contact currentContact = new Contact();
            for(Contact contact: DataHelper.contacts){
                if (contact.getCurrentContact() == contact.getContactId()) {
                    currentContact = contact;
                }
            }
        return currentContact;
    }
}