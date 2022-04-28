package com.company;

import com.google.gson.Gson;

import javax.sql.RowSetMetaData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        serialize();
//        deserialize();
    }

    static void serialize(){
        ToDoItems todo1 = new ToDoItems("Walk the dog", false, 0, 3, "dog");
        ToDoItems todo2 = new ToDoItems("Pay the bills", false, 1, 1, "bills");

        ToDoList todoList = new ToDoList();
        ArrayList<ToDoItems> toDoLists = new ArrayList<>();
        toDoLists.add(todo1);
        toDoLists.add(todo2);



        Gson gson = new Gson();
        try{
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(todo1, writer);
            System.getProperty("line.separator");
            gson.toJson(todo2, writer);
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void deserialize(){
        String todoToJson = "{\"todos\":[{\"body\":\"Walk the dog\",\"done\":false,\"id\":0,\"priority\":3,\"title\":\"dog\"},{\"body\":\"Pay the bills\",\"done\":false,\"id\":1,\"priority\":1,\"title\":\"bills\"}]}";
        Gson gson = new Gson();
        ToDoItems list = gson.fromJson(todoToJson, ToDoItems.class);
        System.out.println(todoToJson.toString());

    }
}

class ToDoItems{
    private String body;
    private boolean isDone;
    private int id;
    private int priority;
    private String title;

    public ToDoItems(String body, boolean isDone, int id, int priority, String title) {
        this.body = body;
        this.isDone = isDone;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDos{" +
                "body='" + body + '\'' +
                ", isDone=" + isDone +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}

class ToDoList{
    private ToDoItems todos;

    public ToDoList(ToDoItems todos) {
        this.todos = todos;
    }

    public ToDoItems getTodos() {
        return todos;
    }

    public void setTodos(ToDoItems todos) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "todos=" + todos +
                '}';
    }
}

