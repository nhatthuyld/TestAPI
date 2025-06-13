package dataObject;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TodoitemObject {
    private String title;
    private boolean doneStatus;
    private String description;
    public  TodoitemObject()
    {

        this.title = "default tilte";
        this.doneStatus = false;
        this.description = "default description";
    }

    public TodoitemObject(String title, boolean doneStatus, String description)
    {
        this.title = title;
        this.doneStatus = doneStatus;
        this.description = description;
    }



}
