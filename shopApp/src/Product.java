
public class Product {
	private String name;
    private String kind;
    private int num;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, String kind, int num, double price) {
    	this.name = name;
        this.kind = kind;
        this.num = num;
        this.price = price;
	}

	@Override
    public String toString() {
        return name + "\t" + kind + "\t" + num + "\t" + price;
    }
}
