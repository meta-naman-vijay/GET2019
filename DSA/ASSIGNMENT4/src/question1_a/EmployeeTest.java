package question1_a;

import org.junit.Test;

/**
 * @author naman test class for EmployeeOperations class
 *
 */
public class EmployeeTest {
    /**
     * add the employee and sorted the list on the basis of the Id
     */
    @Test
    public void test() {
        EmployeeOperations employee = new EmployeeOperations();
        employee.addEmployee(new Employee(1, "krishan", "churu"));
        employee.addEmployee(new Employee(5, "vinod", "Udaipur"));
        employee.addEmployee(new Employee(3, "ali", "jhalawad"));
        employee.addEmployee(new Employee(4, "jyoti", "jaipur"));
        employee.addEmployee(new Employee(2, "naman", "Jaipur"));
        employee.sortedList();
        employee.printList();
    }

}