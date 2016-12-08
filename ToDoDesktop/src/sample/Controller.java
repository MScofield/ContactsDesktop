package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ListView list;

    @FXML
    TextField text;

    ObservableList<ToDoItem> items = FXCollections.observableArrayList();

    public void addItem(){
        ToDoItem t = new ToDoItem(text.getText());
        items.add(t);
        text.setText("");
    }
    public void removeItem(){
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        items.remove(item);
    }
    public void toggleItem(){
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        if(item != null) {
            item.isDone = !item.isDone;
            list.refresh();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(items);
    }
}
