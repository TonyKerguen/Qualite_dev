package fr.univ_orleans.iut45.mud;

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