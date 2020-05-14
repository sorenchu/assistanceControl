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

    public String getNameAndSurname() {
        return String.format("%s %s", this.name, this.surname);
    }

    public String getSurnameAndName() {
        return String.format("%s, %s", this.surname, this.name);
    }

    public Category getCategory() {
        return this.category;
    }

}
