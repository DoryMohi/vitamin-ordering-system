//represents the omega-3 vitamin with fixed name and base price

public class Omega6 extends Vitamin{

    public Omega6(){
        super("Omega-6",11.0);
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
