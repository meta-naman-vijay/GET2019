package question1_b;

import org.junit.Test;

/**
 * @author naman
 *  test class for EmployeeOperations class
 *
 */
public class EmployeeTest {
    /**
     * add the employee and sorted the list on the basis of the name
     */
    @Test
    public void testSortByName() {
        EmployeeOperations employee = new EmployeeOperations();
        employee.addEmployee(new Employee(1, "krishan", "churu"));
        employee.addEmployee(new Employee(5, "vinod", "Udaipur"));
        employee.addEmployee(new Employee(3, "priya", "jaipur"));
        employee.addEmployee(new Employee(4, "ali", "jhalawad"));

        employee.sortEmployeeByName();
        employee.printList();
    }

}