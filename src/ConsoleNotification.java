/// observer implementation that prints notifications to the console
public class ConsoleNotification implements NotificationListener {

    @Override
    public void update(String message) {
        System.out.println("\n========= NOTIFICATION ============");
        System.out.println("  "+message);
        System.out.println("====================================");
    }
}
