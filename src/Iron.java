/// represents the iron vitamin with its fixed base price
public class Iron extends Vitamin {

    public Iron() {
        super("Iron",9.0);
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
