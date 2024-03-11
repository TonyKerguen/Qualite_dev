package fr.univ_orleans.iut45.mud;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;


class Thing{

    private String name;
    private int volume;

    public Thing(String name){
        this.name = name;
        this.volume = 0;
    }

    public Thing(String name, int volume){
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean hasName(String name) {
        return this.name == name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Box {

    private ArrayList<Thing> contents = new ArrayList<>();
    private String name;
    private boolean ouverte;
    private int capacity;

    public Box(){
        this.name = "boite";
        this.contents = new ArrayList<>();
        this.ouverte = true;
        this.capacity = -1;
        System.out.println("Box créée");
    }

    public Box(String name){
        this.name = name;
        this.contents = new ArrayList<>();
        this.ouverte = true;
        this.capacity = -1;
        System.out.println("Box créée");
    }

    public Box(String name, int capacity){
        this.name = name;
        this.contents = new ArrayList<>();
        this.ouverte = true;
        this.capacity = capacity;
        System.out.println("Box créée");
    }

    public Box(String name, int capacity, boolean ouverte){
        this.name = name;
        this.contents = new ArrayList<>();
        this.ouverte = ouverte;
        this.capacity = capacity;
        System.out.println("Box créée");
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void add(Thing truc) {
        this.contents.add(truc);
    }

    public boolean estDedans(Thing thing) {
        return this.contents.contains(thing);
    }

    public void enleverDeLaBoite(Thing thing) {
        try {
            this.contents.remove(thing);
        } catch (Exception e) {
            System.err.println("L'objet n'est pas dans la boite");
        }
    }

    public boolean isOpen() {
        return this.ouverte;
    }

    public void open() {
        this.ouverte = true;
    }

    public void close() {
        this.ouverte = false;
    }

    public boolean hasRoomFor(Thing t) {
        if(this.getCapacity() == -1) {
            return true;
        }
        else{
            if(t.getVolume() <= this.getCapacity()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void actionAdd(Thing t){
        if(this.hasRoomFor(t) && this.isOpen()){
            this.add(t);
            this.setCapacity(this.getCapacity()-t.getVolume());
        }
    }

    public Thing find(String name) {
        if(this.isOpen()) {
            for(Thing t : this.contents) {
                if(t.hasName(name)){
                    return t;
                }
            }
        }
        return null;
        
    }

    public String actionLook() {
        String listString = "";
        for(Thing t: this.contents) {
            listString += t.toString()+", ";
        }
        // listString.substring(0, listString.length() - 5);
        return "la boite contient: "+listString;
    }

    public static Box fromJSON(String chemin) throws FileNotFoundException {
        FileReader reader = new FileReader(chemin);
        Gson gson = new Gson();
        Box box = gson.fromJson(reader, Box.class);
        return box;
        
    }
}
