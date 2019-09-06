import java.util.*;
public class UseEmployeeLinkedList{
     public static void main(String args[])
     {
         Employee e1=new Employee(1001,"Rakesh","Jaipur",15000.0,25);
         Employee e2=new Employee(1002,"Rajesh","Sikar",25000.0,26);
         Employee e3=new Employee(1003,"Manish","Jaipur",35000.0,25);
         Employee e4=new Employee(1004,"Ramesh","Sikar",40000.0,23);
         Employee e5=new Employee(1005,"Nitesh","Sikar",40000.0,22);
         LinkList empList=new LinkList();
         empList.insertNode(e1);
         empList.insertNode(e2);
         empList.insertNode(e3);
         empList.insertNode(e4);
         empList.insertNode(e5);
         Node list=empList.sortBySalary(empList);
         Employee temp;
         while(list!=null)
         {   
             temp=(Employee)list.data;
             System.out.println(temp.getEmpName());
             list=list.next;
         }
         
         
     }
}