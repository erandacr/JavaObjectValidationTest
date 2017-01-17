package DemoProject;

/**
 * Created by eranda on 1/17/17.
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person() {
        this.firstName = "Barack";
        this.lastName = "Obama";
    }

    private String whatsFullName(String middleName) {
        return firstName + " " + middleName + " " + lastName;
    }
}
