public class EmployeeLinkedList{
    LinkList empList=null;
    public EmployeeLinkedList()
    {
         empList=new LinkList();
    }
    
    public Node add(Employee emp)
    {
         return empList.insertNode(emp);
    }
    
    public Node sortBySalary(EmployeeLinkedList empList)
    {
         Node tempList=empList.head;
         LinkList sortedList=new LinkList();
         int size=0;
         while(tempList!=null)
         {
              size++;
              tempList=tempList.next;
         }
         Node next=null;
         Employee emp1=null,emp2=null;
         Employee tempEmp=null;
         for(int i=0;i<size;i++)
         {
             tempList=empList.head;             
             while(tempList.next!=null)
             {     
                  next=tempList.next;
                  emp1=(Employee)tempList.data;
                  emp2=(Employee)next.data;
                  if(emp1.getEmpSalary()>emp2.getEmpSalary())
                  {
                       tempEmp=emp1;
                       emp1=emp2;
                       emp2=tempEmp;
                  }
                  else
                       if(emp1.getEmpSalary()==emp2.getEmpSalary() && emp1.getEmpAge()<emp2.getEmpAge())
                       {
                            tempEmp=emp1;
                            emp1=emp2;
                            emp2=tempEmp;
                       }
                  tempList=tempList.next;
             }
             sortedList.insertNode(tempList.data);
             Node n=sortedList.head;
             while(n!=null)
             {
                  System.out.println(((Employee)n.data).getEmpName());
                  n=n.next;
             }
         }
         return sortedList.head;
    }
    
}