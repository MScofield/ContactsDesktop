package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

/**
 * Created by scofieldservices in the future.
 */
public class Contact {

    String name;
    String number;
    String email;

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    @Override
    public String toString(){
        return (name + ", "+ number +", "+ email);
    }

    public static void contactSaver (ObservableList<Contact> madeMen) throws IOException{
        JsonSerializer serializer = new JsonSerializer();
        String jaysunn = serializer.include("*").serialize(madeMen);
        File fwat = new File("controller.json");
        FileWriter writer = new FileWriter(fwat);
        writer.write(jaysunn);
        writer.close();
    }
    public static Contact contactLoader()throws FileNotFoundException {
        File fwhy = new File("controller.json");
        Scanner peepingTom = new Scanner(fwhy);
        peepingTom.useDelimiter("//z");
        String contents = peepingTom.next();
        JsonParser parsThis = new JsonParser();
        return parsThis.parse(contents, Contact.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
