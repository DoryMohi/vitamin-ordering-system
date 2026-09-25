/// this is the abstract base class for all vitamins, holds common attributes
public abstract class Vitamin {
    /// ----------Attributes---------
    protected String name;
    protected double basePrice;



    /// ---------Constructors-------
    public Vitamin(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }



    /// ---------Getters------------
    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    /// --------Abstract Methods-----------
    public abstract String getDescription();
    public abstract double getPrice();
}
