import java.util.ArrayList;
import java.util.List;

///provides vitamin recommendations based on the user's age and gender
public class VitaminRecommender {
    public static List<String> recommend(Customer customer) {
        List<String> recommended = new ArrayList<>();

        int age = customer.getAge();
        String gender = customer.getGender().toLowerCase();

        /// ----------Underage 12 and below-------
        if(age <= 12 || gender.equals("child")){
            recommended.add("calcium");
            recommended.add("vitamin b12");
            recommended.add("magnesium");
            return recommended;
        }

        /// ----here is the recommendation for females, males and default for unexpected situation
        switch(gender){
            case "female":
                recommended.add("iron");
                recommended.add("calcium");
                recommended.add("vitamin b12");
                break;
            case "male":
                recommended.add("omega-3");
                recommended.add("omega-6");
                recommended.add("magnesium");
                break;
            default:
                System.out.println("Unexpected gender value: " + gender);
                break;
        }

        return recommended;


    }
}
