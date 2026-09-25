/// decorator that adds a form (tablets, capsules, gummies, liquid) to the selected vitamin and adjusts its price.

public class FormDecorator extends VitaminDecorator{
    /// ------------Attributes ---------------
    private String form;
    private double formPrice;

    /// --------------Constructirs-------------
    public FormDecorator(Vitamin baseVitamin, String form) {
        super(baseVitamin);
        this.form = form.toLowerCase();
        this.formPrice = determinePrice(form);
    }

    /// it helps to determine the price by its form
    private double determinePrice(String form) {
        switch (form.toLowerCase()) {
            case "tablets":
                return 0;
            case "capsules":
                return 1.0;
            case "gummies":
                return 2.0;
            case "liquid":
                return 3.0;
            default:
                System.out.println("... applying no extra charge.");
                return 0;
            }
        }

        /// -----------Getters-------
    @Override
    public String getDescription() {
        return baseVitamin.getDescription()+" ("+form+")";
    }

    @Override
    public double getPrice() {
        return baseVitamin.getPrice()+formPrice;
    }

    public String getForm() {
        return form;
    }
}

