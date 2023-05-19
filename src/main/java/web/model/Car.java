package web.model;

public class Car {

    private int id;

    private String vin;

    private String owner;

    private static int count;

    public Car() {
        count++;
        id = count;
        vin = "4J" + Math.round(Math.random() * 100000);
        owner = "Pieter the " + Math.round(Math.random() * 10);
        System.out.println("Car{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", owner='" + owner + '\'' +
                '}');

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
