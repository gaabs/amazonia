package models.entities;

public class Status {
    private String statusName;
    public Status(String name){
        statusName = name;
    }

    public void setStatus(String name){
        statusName = name;
    }
}
