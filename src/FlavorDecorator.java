///decorator that adds flavor to the vitamin, only applicable for gummies and liquid forms.
public class FlavorDecorator extends VitaminDecorator {

    private String flavor;
    private double flavorPrice;

    public FlavorDecorator(Vitamin baseVitamin, String flavor) {
        super(baseVitamin);
        this.flavor = flavor.toLowerCase();
        this.flavorPrice = determinePrice(this.flavor);
    }

    private double determinePrice(String f) {
        switch (f) {
            case "orange": return 1.0;
            case "strawberry": return 1.0;
            case "mint": return 1.0;
            case "unflavoured": return 0;
            default:
                System.out.println("Unknown flavor. No extra charge.");
                return 0;
        }
    }

    @Override
    public String getDescription() {
        return baseVitamin.getDescription() + " <" + flavor + ">";
    }

    @Override
    public double getPrice() {
        return baseVitamin.getPrice() + flavorPrice;
    }

    public String getFlavor() { return flavor; }
}