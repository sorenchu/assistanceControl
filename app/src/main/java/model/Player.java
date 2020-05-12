package model;

public class Player {

    private String name;
    private String surname;
    private Category category;

    public Player() {
        this.name = "";
        this.surname = "";
        this.category = Category.U6;
    }

    public Player(String name, String surname, Category category) {
        this.name = name;
        this.surname = surname;
        this.category = category;
    }
}
