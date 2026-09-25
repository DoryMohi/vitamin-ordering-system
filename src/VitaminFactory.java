/// factory method responsible for creating vitamin objects based on user input
public class VitaminFactory {

    public static Vitamin createVitamin(String type){

        /// it checks that it is suitable for type as we entered to our system or not
        if(type == null){
            System.out.println("Invalid vitamin type.");
            return null;
        }
/// here it will return the info related to chosen vitamin types
        switch(type.toLowerCase()){

            case "omega-3":
                return new Omega3();
            case "omega-6":
                return new Omega6();
            case "b12":
                return new VitaminB12();
            case "iron":
                return new Iron();
            case "calcium":
                return new Calcium();
            case "magnesium":
                return new Magnesium();
            default:
                System.out.println("\nVitamin type not recognized: "+type);
                return null;
        }
    }
}
