package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public void initialize(URL location, ResourceBundle resources){
        homies.setItems(madeMen);
    }

    ObservableList<Contact> madeMen = FXCollections.observableArrayList();

    @FXML
    ListView homies;
    @FXML
    TextField name;
    @FXML
    TextField number;
    @FXML
    TextField email;

    // a method for adding contacts
    public void onDeck() throws IOException {
        if (name.getText().isEmpty() || number.getText().isEmpty() || email.getText().isEmpty()){
            System.out.println("I thought I told you that we don't play. You may not add a contact with blank fields.");
        }else{
            Contact innerCircle = new Contact(name.getText(), number.getText(), email.getText());
            madeMen.add(innerCircle);
            name.setText("");
            number.setText("");
            email.setText("");

            try {
                Contact.contactSaver(madeMen);
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }

    // a method for removing contacts ... forever
    public void cementShoes(){
        Contact name = (Contact) homies.getSelectionModel().getSelectedItem();
        madeMen.remove(name);

        try {
            Contact.contactSaver(madeMen);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
