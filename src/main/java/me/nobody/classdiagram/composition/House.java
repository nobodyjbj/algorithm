package me.nobody.classdiagram.composition;

public class House {
    private me.nobody.classdiagram.composition.Room room;

    public House() {
        this.room = new me.nobody.classdiagram.composition.Room();
    }

    public Room getRoom() {
        return room;
    }
}
