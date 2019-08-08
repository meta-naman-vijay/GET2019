package question1_c;

import org.junit.Test;

/**
 * @author naman
 *  test class for EmployeeOperations class
 *
 */
public class EmployeeTest {
    /**
     * test duplicacy on the basis of the Id
     */
    @Test
    public void avoidDuplicateEmptest() {
        EmployeeOperations employee = new EmployeeOperations();
        employee.addEmployee(new Employee(1, "krishan", "jaipur"));
        employee.addEmployee(new Employee(1, "priya", "kanpur"));
        employee.addEmployee(new Employee(3, "murtza ali", "jhalawad"));
        employee.addEmployee(new Employee(4, "vinod sahu", "udaipur"));
        employee.addEmployee(new Employee(2, "jyoti", "Jaipur"));
        employee.printList();
    }

}
