package DemoProject;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Unit test for Demo App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Private method test
     */
    public void testFullNameMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class targetClass = Person.class;
        // first parameter is the name of the method and the next parameter is the array of "Class" type, which are
        // as argument of the testing method
        Method method_fullName = targetClass.getDeclaredMethod("whatsFullName", new Class[] { String.class });
        method_fullName.setAccessible(true);

        // second parameter of the "invoke" method is argument objects (as an array) which should be passed to the
        // original method when calling it
        String fullName = (String) method_fullName.invoke(person, new Object[] { "Hussain" });
        System.out.println(fullName);

        assertTrue("Barack Hussain Obama".equals(fullName));
    }

    /**
     * Private field test
     */
    public void testFirstNameField() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        Class targetClass = Person.class;

        Field field_firstName = targetClass.getDeclaredField("firstName");
        field_firstName.setAccessible(true);
        field_firstName.set(person, "John");

        String firstName = (String) field_firstName.get(person);
        System.out.println("First Name: " + firstName);

        assertTrue("John".equals(firstName));
    }

}
