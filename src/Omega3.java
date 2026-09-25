///represents the omega-3 vitamin with fixed name and base price

public class Omega3 extends Vitamin{

    public Omega3(){
        super("Omega-3",12.0);
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
