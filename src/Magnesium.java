/// represents the magnesium vitamin with its base price and description
public class Magnesium extends Vitamin {

    public Magnesium() {
        super("Magnesium",9.0);
    }


    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }
}
