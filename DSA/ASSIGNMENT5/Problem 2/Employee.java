/**
 * POJO class for Employee
 */
public class Employee{
	    private int empId;
	    private String empName;
	    private String empAddress;
     private double salary;
     private int age;
     
	    public Employee(int empId, String empName, String empAddress,double salary,int age) 
     {
		       this.empId = empId;
		       this.empName = empName;
		       this.empAddress = empAddress;
         this.salary=salary;
         this.age=age;
	    }
     /**
      * Method to get Employee Id
      * @return empId
      */
	    public int getEmpId() 
     {
		       return empId;
	    }
     /**
      * Method to set Employee Id
      * @param empId
      */
	    public void setEmpId(int empId) 
     {
		       this.empId = empId;
	    }
     /**
      * Method to get Employee name
      * @return empName
      */
	    public String getEmpName() 
     {
		       return empName;
	    }
     /**
      * Method to set Employee name
      * @param empName
      */
	    public void setEmpName(String empName) 
     {
		       this.empName = empName;
	    }
     /**
      * Method to get Employee address
      * @return empAddress
      */     
	    public String getEmpAddress() 
     {
		       return empAddress;
	    }
     /**
      * Method to set Employee address
      * @param empAddress
      */
	    public void setEmpAdresses(String empAddress) 
     {
		       this.empAddress = empAddress;
	    }
     /**
      * Method to get Employee salary
      * @return salary
      */     
     public double getEmpSalary() 
     {
		       return salary;
	    }
     /**
      * Method to set Employee salary
      * @param salary
      */
     public void setEmpSalary(double salary) 
     {
		       this.salary = salary;
	    }
     /**
      * Method to get Employee age
      * @return age
      */     
     public int getEmpAge() 
     {
		       return age;
	    }
     /**
      * Method to set Employee age
      * @param age
      */
	    public void setEmpAge(int age) 
     {
		       this.age = age;
	    }
	   
}