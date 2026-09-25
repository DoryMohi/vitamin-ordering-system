///represents vitamin b12 with fixed description and base price
public class VitaminB12 extends Vitamin {

    public VitaminB12() {
        super("Vitamin B12",10.0);
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
