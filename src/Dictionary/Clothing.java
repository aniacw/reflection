package Dictionary;

public class Clothing {
    private String name;
    private int size;
    private String colour;
    private double price;

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

    public String getColour() {
        return colour;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }
}
