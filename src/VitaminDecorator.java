/// abstract decorator for adding customisation for vitamin, and answers that all vitamins objects behave regular
public abstract class VitaminDecorator extends Vitamin{ //
    protected Vitamin baseVitamin;


    public VitaminDecorator(Vitamin baseVitamin) {
        super(baseVitamin.getName(), baseVitamin.getBasePrice());
        this.baseVitamin = baseVitamin;
    }


    @Override
    public abstract String getDescription();

    @Override
    public abstract double getPrice();
}
