/// represents the calcium vitamin with its fixed name and base price
public class Calcium extends Vitamin {

    /// ----------Constructr
    public Calcium() {
        super("Calcium",8.0);
    }


    /// -----------Overrides--------
    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }
}
