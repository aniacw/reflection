package ObjectManager;

public class Clothing {
    public String name;
    public int size;
    public String colour;
    public double price;

    public Clothing(String name, int size, String colour, double price) {
        this.name = name;
        this.size = size;
        this.colour = colour;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
