package fr.univ_orleans.iut45.mud;

import java.util.ArrayList;
import com.google.gson.Gson;


public class Box {

    private ArrayList<Thing> contents = new ArrayList<>();
    private boolean ouverte;
    private int capacity;

    public Box(){
        this.contents = new ArrayList<>();
        this.ouverte = false;
        this.capacity = -1;
        System.out.println("Box créée");
    }

    public Box(int capacity){
        this.contents = new ArrayList<>();
        this.ouverte = false;
        this.capacity = capacity;
        System.out.println("Box créée");
    }

    public Box(int capacity, boolean ouverte){
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
}
