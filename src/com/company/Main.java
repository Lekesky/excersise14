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

    static ArrayList<ToDoItems> toDoLists = new ArrayList<>();

    public static void main(String[] args) {
//       deserialize();
        serialize();
    }

    static void serialize(){
        ToDoItems todo1 = new ToDoItems("Walk the dog", false, 0, 3, "dog");
        ToDoItems todo2 = new ToDoItems("Pay the bills", false, 1, 1, "bills");




        toDoLists.add(todo1);
        toDoLists.add(todo2);



        Gson gson = new Gson();
        try{
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(toDoLists, writer); //Put in arraylist
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

// class ToDoList{
//     private ToDoItem[] todos;

//     public ToDoList(ToDoItems todos) {
//         this.todos = todos;
//     }

//     public ToDoItems getTodos() {
//         return todos;
//     }

//     public void setTodos(ToDoItems todos) {
//         this.todos = todos;
//     }

//     @Override
//     public String toString() {
//         return "ToDoList{" +
//                 "todos=" + todos +
//                 '}';
//     }
// }

//class ToDoList {
//    private ToDoList<> todos;
//
//    public ToDoList(ToDoList[] todos) {
//        this.todos = todos;
//    }
//
//    public ToDoList[] getTodos() {
//        return todos;
//    }
//
//    public void setTodos(ToDoList[] todos) {
//        this.todos = todos;
//    }
//
//    @Override
//    public String toString() {
//        return "ToDoList{" +
//                "todos=" + Arrays.toString(todos) +
//                '}';
//    }
//}