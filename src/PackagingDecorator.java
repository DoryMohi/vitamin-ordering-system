///decorator that adds packaging type to the vitamin.
public class PackagingDecorator extends VitaminDecorator {

    private String packaging;
    private double packagingPrice;

    public PackagingDecorator(Vitamin baseVitamin, String packaging) {
        super(baseVitamin);
        this.packaging = packaging.toLowerCase();
        this.packagingPrice = determinePrice(this.packaging);
    }

    private double determinePrice(String p) {
        switch (p) {
            case "glass bottle": return 2.0;
            case "plastic bottle": return 1.0;
            case "eco-pack": return 1.5;
            case "container": return 2.5;
            default:
                System.out.println("Unknown packaging. No extra charge.");
                return 0;
        }
    }

    @Override
    public String getDescription() {
        return baseVitamin.getDescription() + " {" + packaging + "}";
    }

    @Override
    public double getPrice() {
        return baseVitamin.getPrice() + packagingPrice;
    }

    public String getPackaging() {
        return packaging;
    }
}