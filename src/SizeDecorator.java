public class SizeDecorator extends VitaminDecorator{

    private int size;
    private double sizePrice;
/// this is the decorator that adds size option to a vitamin
    public SizeDecorator(Vitamin baseVitamin, int size) {
        super(baseVitamin);
/// here it validates if the option is liquid, it cannot be in the size of 120
        if(size == 120 && isLiquidForm(baseVitamin)){
            System.out.println("Error: Liquid vitamins cannot be ordered in 120-count size.");
            throw new IllegalArgumentException("invalid size");
        }
        this.size = size;
        this.sizePrice = determinePrice(size);
    }
/// here calculation is done by adding appropriate amount for each type of size
    private double determinePrice(int size){
        switch(size){
            case 30:
                return 0;
            case 60:
                return 2.0;
            case 120:
                return 5.0;
            default:
                System.out.println("Unknown size selected. Applying no extra charge.");
                return 0;
        }
    }

    private boolean isLiquidForm(Vitamin vitamin) {

        while (vitamin instanceof VitaminDecorator) {
            if (vitamin instanceof FormDecorator) {
                return ((FormDecorator) vitamin).getForm().equals("liquid");
            }
            vitamin = ((VitaminDecorator) vitamin).baseVitamin;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return baseVitamin.getDescription() + " (" + size + "-count)";
    }

    @Override
    public double getPrice() {
        return baseVitamin.getPrice()+sizePrice;
    }

    public int getSize() {
        return size;
    }
}
