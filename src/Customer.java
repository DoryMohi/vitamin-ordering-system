/// stores user information such as age and gender.
/// used for generating vitamin recommendations.

public class Customer {

    /// -----------Attributes---------
    private int age;
    private String gender;

    /// ------------Constructors---------
    public Customer(int age, String gender) {
        setAge(age);
        setGender(gender);
    }

    /// ------------Getters and setters------
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
