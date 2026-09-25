import java.util.Stack;

/// Singleton class that manages the user's active vitamin order
/// supports applying decorator, undoing actions and sending notifications
public class Order {

    private static Order instance;

    private Vitamin currentVitamin;
    private Stack<Vitamin> historyStack = new Stack<>();
    private Notifier notifier = new Notifier();


    private Order() {

    }

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public void startNewOrder(Vitamin vitamin) {
        this.currentVitamin = vitamin;
        historyStack.clear();
        notifier.notifyListeners("New vitamin selected: "+vitamin.getDescription());
    }

    public void applyForm(String form) {
        saveState();
        currentVitamin = new FormDecorator(currentVitamin, form);
        notifier.notifyListeners("Form applied: "+form);
    }
    public void applyBrand(String brand) {
        saveState();
        currentVitamin = new BrandDecorator(currentVitamin, brand);
        notifier.notifyListeners("Brand applied: " + brand);
    }
    public void applyPackaging(String packaging) {
        saveState();
        currentVitamin = new PackagingDecorator(currentVitamin, packaging);
        notifier.notifyListeners("Packaging applied: " + packaging);
    }

    public void applyFlavor(String flavor) {
        saveState();
        currentVitamin = new FlavorDecorator(currentVitamin, flavor);
        notifier.notifyListeners("Flavor applied: " + flavor);
    }

    public void applySize(int size){
        saveState();
        try {
            currentVitamin = new SizeDecorator(currentVitamin, size);
            notifier.notifyListeners("Size applied: " + size + "-count");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /// undo the last applied customisation if history available
    public void undoLast(){
        if(!historyStack.isEmpty()){
            currentVitamin = historyStack.pop();
            notifier.notifyListeners("Undo performed. Current product: " + currentVitamin.getDescription());
        }
        else{
            System.out.println("Nothing to undo.");
        }
    }

    /// saves the current vitamin state so it can restored with undo
    private void saveState(){
        historyStack.push(currentVitamin);
    }

    public Vitamin getCurrentVitamin(){
        return currentVitamin;
    }
/// completes the order and prints the final summary
    public void placeOrder(){
        if(currentVitamin == null){
            notifier.notifyListeners("No order to place.");
        }
        else{
            notifier.notifyListeners("Order placed successfully.");
            System.out.println();
            System.out.println("--------ORDER DETAILS-------------");
            System.out.println("Product: "+currentVitamin.getDescription());
            System.out.println("Total price: $"+currentVitamin.getPrice());
        }
    }


    public void cancelOrder(){
        notifier.notifyListeners("Order cancelled.");
        currentVitamin = null;
        historyStack.clear();
    }

    public void addNotificationListener(NotificationListener listener){
        notifier.addListener(listener);
    }


}
