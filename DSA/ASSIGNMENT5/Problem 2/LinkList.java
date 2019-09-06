public class LinkList{
	   Node head=null;
	  /**
	   * Method will create new Node 
	   * takes Parameter as data of ineger type
	   * Returns the head of LinkList
	   */
	   public Node insertNode(Object data)
	   {
		      if(head==null)
		      {
			         head=new Node(data);
		      }
        else
        {
			         Node nextNode=head;
			         while(nextNode.next!=null)
			         {
				            nextNode=nextNode.next;
			         }
			         nextNode.next=new Node(data);
		      }
        return head;		
	   }
   /**
	   * Method sorts the list of employee according to their salary in decending order 
	   * takes Parameter of LinkList of employee
	   * Returns the sorted LinkList head node
	   */
    public Node sortBySalary(LinkList empList)
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
         System.out.println("List comin");
         tempList=empList.head;
         while(tempList!=null)
         {
              System.out.println(((Employee)tempList.data).getEmpName());
              tempList=tempList.next;
         }
         System.out.println("out");
         for(int i=0;i<size;i++)
         {
             tempList=empList.head;             
             while(tempList.next!=null)
             {     
                  next=tempList.next;
                  emp1=(Employee)tempList.data;
                  emp2=(Employee)next.data;
                  if(emp1.getEmpSalary()<emp2.getEmpSalary())
                  {     
                       tempEmp=emp1;
                       emp1=emp2;
                       emp2=tempEmp;
                       tempList.data=emp1;
                       next.data=emp2;
                  }
                  else
                       if(emp1.getEmpSalary()==emp2.getEmpSalary() && emp1.getEmpAge()>emp2.getEmpAge())
                       {
                            tempEmp=emp1;
                            emp1=emp2;
                            emp2=tempEmp;
                            tempList.data=emp1;
                            next.data=emp2;
                       }
                  tempList=tempList.next;
             }
         }
         return empList.head;
    }  
}
