package sample;

/**
 * Created by scofieldservices on 11/30/16.
 */
public class ToDoItem {
    String text;
    boolean isDone;

    public ToDoItem(String text) {
        this.text = text;
        this.isDone = false;
    }

    @Override
    public String toString() {
        if(isDone){
            return text + "(done";
        }
        return text;
    }
}

