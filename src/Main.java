import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Order order = Order.getInstance();

        order.addNotificationListener(new ConsoleNotification());


        System.out.println("====================================");
        System.out.println("       VITAMIN ORDERING SYSTEM      ");
        System.out.println("====================================\n");
        System.out.println();

        boolean running = true;
        while (running) {
            Customer customer = collectCustomerInfo(scanner);
            List<String> recommendations = VitaminRecommender.recommend(customer);

            System.out.println("\nRecommended vitamins for you:");
            for (String rec : recommendations) {
                System.out.println("- " + rec);
            }

            Vitamin selectedVitamin = chooseVitamin(scanner, recommendations);
            order.startNewOrder(selectedVitamin);
            System.out.println("\nYou selected: " + selectedVitamin.getName());
            System.out.println("Base price: $" + selectedVitamin.getBasePrice());

            String form = applyForm(scanner, order);
            applyBrand(scanner, order);
            applyPackaging(scanner, order);
            applyFlavor(scanner, order, form);
            applySize(scanner, order);

            boolean finished = finalMenu(scanner, order);

            if (!finished) {
                applySize(scanner, order);
                finalMenu(scanner, order);
            }

            System.out.print("\nStart another order? (yes/no): ");
            String again = scanner.next().toLowerCase();
            if (!again.equals("yes")) {
                running = false;
            }
        }

        System.out.println("System shutting down...");

    }

    ///collects age and gender from the user with full validation
    private static Customer collectCustomerInfo(Scanner scanner) {

        int age = -1;
        while (true) {
            System.out.print("Enter your age: ");

            if(scanner.hasNextInt()) {
                age = scanner.nextInt();

                if(age >= 0 && age <= 100) {
                    break;
                }
                else{
                    System.out.println("\n<<< Invalid age. Age must be between 0 and 100. >>>\n");
                }
            }
            else {
                System.out.println("\n<<< Please enter a number >>>\n");
                scanner.next();
            }

        }

        String gender;

        if (age <= 12) {
            gender = "child";
            System.out.println("\nDetected as child. Gender not required.");
        } else {
            while (true) {
                System.out.print("Enter your gender (male/female): ");
                gender = scanner.next().toLowerCase();

                if (gender.equals("male") || gender.equals("female"))
                    break;
                else{
                    System.out.println("\n<<< Invalid gender. Try again. >>> \n");

                }
            }
        }
        return new Customer(age, gender);
    }

    /// lets the user choose a vitamin and validates the choice
    private static Vitamin chooseVitamin(Scanner scanner, List<String> recommendations) {

        System.out.print("\nEnter vitamin you want to order: ");
        String type = scanner.next().toLowerCase();

        Vitamin selected = VitaminFactory.createVitamin(type);

        while (selected == null) {
            System.out.println("\n<<< Please enter a valid vitamin type. >>> \n");
            type = scanner.next().toLowerCase();
            selected = VitaminFactory.createVitamin(type);
        }

        return selected;
    }
    /// applies form customisation through the order class
    private static String applyForm(Scanner scanner, Order order) {

        System.out.println("\nChoose form:");
        System.out.println("tablets | capsules | gummies | liquid");
        System.out.print("\nYour choice: ");

        scanner.nextLine();
        String form = scanner.nextLine().toLowerCase();

        while (!form.matches("tablets|capsules|gummies|liquid")) {
            System.out.println("\n<<< Invalid form. Try again. >>>\n");
            form = scanner.nextLine().toLowerCase();
        }

        order.applyForm(form);
        return form;
    }

    private static void applyBrand(Scanner scanner, Order order) {

        System.out.println("\nChoose brand:");
        System.out.println("generic | premium | organic | pharma");
        System.out.print("\nYour choice: ");

        String brand = scanner.next().toLowerCase();

        while (!brand.matches("generic|premium|organic|pharma")) {
            System.out.println("\n<<< Invalid brand. Try: generic, premium, organic, pharma. >>>\n");
            brand = scanner.next().toLowerCase();
        }

        order.applyBrand(brand);
    }
    private static void applyPackaging(Scanner scanner, Order order) {

        scanner.nextLine(); // <-- IMPORTANT: clears leftover newline

        System.out.println("\nChoose packaging:");
        System.out.println("glass bottle | plastic bottle | eco-pack | container");
        System.out.print("\nYour choice: ");

        String packaging = scanner.nextLine().toLowerCase();

        while (!packaging.matches("glass bottle|plastic bottle|eco-pack|container")) {
            System.out.println("\n<<< Invalid packaging. Try again. >>>\n");
            packaging = scanner.nextLine().toLowerCase();
        }

        order.applyPackaging(packaging);
    }
    private static void applyFlavor(Scanner scanner, Order order, String form) {

        if (!(form.equals("gummies") || form.equals("liquid"))) {
            System.out.println("\nFlavor not applicable for this form.");
            return;
        }

        System.out.println("\nChoose flavor:");
        System.out.println("orange | strawberry | mint | unflavoured");
        System.out.print("\nYour choice: ");

        String flavor = scanner.nextLine().toLowerCase();

        while (!flavor.matches("orange|strawberry|mint|unflavoured")) {
            System.out.println("\n<<< Invalid flavor. Try again. >>>\n");
            flavor = scanner.nextLine().toLowerCase();
        }

        order.applyFlavor(flavor);
    }
    /// applies size customisation and re-prompts if invalid
    private static void applySize(Scanner scanner, Order order) {

        while (true) {
            System.out.println("\nChoose size:");
            System.out.println("30 | 60 | 120");
            System.out.print("\nYour choice: ");

            String input = scanner.next();

            if (!input.matches("\\d+")) {
                System.out.println("\n<<< Invalid input. Please enter a number (30, 60, or 120). >>>\n");
                continue;
            }
            int size = Integer.parseInt(input);
            if (!(size == 30 || size == 60 || size == 120)) {
                System.out.println("\n<<< Invalid size. Enter 30, 60 or 120. >>>\n");
                continue;
            }

            try{
                order.applySize(size);
                break;
            }
            catch (IllegalArgumentException ex) {
                System.out.println("\n<<< Invalid combination. Please choose a different size. >>>\n");
            }
        }
    }
    ///final menu allowing the user to undo, place the order or cancel itt
    private static boolean finalMenu(Scanner scanner, Order order) {

        while (true) {
            System.out.println("\n--- What would you like to do? ---");
            System.out.println("1. Undo last step");
            System.out.println("2. Place order");
            System.out.println("3. Cancel order");
            System.out.print("Choose: ");

            String input = scanner.next();

            if (!input.matches("[1-3]")) {
                System.out.println("<<< Invalid choice. Enter 1, 2, or 3. >>>");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    order.undoLast();
                    return false;

                case 2:
                    order.placeOrder();
                    askSubscription(scanner);
                    return true;

                case 3:
                    order.cancelOrder();
                    return true;
            }
        }
    }
    private static void askSubscription(Scanner scanner) {

        System.out.println("\nWould you like a subscription plan?");
        System.out.println("1. Weekly delivery");
        System.out.println("2. Monthly delivery");
        System.out.println("3. No subscription");
        System.out.print("\nYour choice: ");

        String choice = scanner.next();

        switch (choice) {
            case "1":
                System.out.println("\nWeekly subscription activated. You will receive vitamins every week.");
                break;

            case "2":
                System.out.println("\nMonthly subscription activated. You will receive vitamins every month.");
                break;

            default:
                System.out.println("\nNo subscription added.");
        }
    }
}
