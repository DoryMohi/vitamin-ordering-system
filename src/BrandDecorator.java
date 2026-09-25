///decorator that adds a brand level to a vitamin
public class BrandDecorator extends VitaminDecorator{

    private String brand;
    private double brandPrice;

    public BrandDecorator(Vitamin baseVitamin, String brand){
        super(baseVitamin);
        this.brand = brand.toLowerCase();
        this.brandPrice = determinePrice(this.brand);
    }

    private double determinePrice(String b) {
        switch (b) {
            case "generic":
                return 0.0;
            case "premium":
                return 2.0;
            case "organic":
                return 3.0;
            case "pharma":
                return 4.0;
            default:
                System.out.println("Unknown brand. Applying no extra charge.");
                return 0.0;
        }
    }

    @Override
    public String getDescription() {
        return baseVitamin.getDescription() + " [" + brand + "]";
    }

    @Override
    public double getPrice() {
        return baseVitamin.getPrice() +  brandPrice;
    }

    public String getBrand() {
        return brand;
    }
}
