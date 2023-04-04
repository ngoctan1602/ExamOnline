package app.ntnt.recycleviewfinalproject.model;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String name;

    public Question(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
