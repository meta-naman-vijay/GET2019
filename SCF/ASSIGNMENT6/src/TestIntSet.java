import static org.junit.Assert.*;
import org.junit.Test;

public class TestIntSet {
	//To check set values are between 1 to 1000
	@Test(expected = AssertionError.class)
	public void testInRange() {
		int []set = new int[]{1,4,99,2000};
		IntSet obj = new IntSet(set);
	}
	
	//To check set values are different
	@Test(expected = AssertionError.class)
	public void testIsDifferent() {
		int []set = new int[]{1,3,4,4,9};
		IntSet obj = new IntSet(set);
	}
	
    //isMember Test Cases
	@Test
    public void testIsMemberPersent(){
		int []set=new int[]{1, 3, 4, 5};
		IntSet test = new IntSet(set);
		boolean check = test.isMember(4);
		assertEquals(true ,check);
	}
	@Test
    public void testIsMemberNotPresent(){
		int []set=new int[]{2, 3, 4, 5};
		IntSet test = new IntSet(set);
		boolean check = test.isMember(9);
		assertEquals(false ,check);
	}
	@Test
    public void testIsMemberFirst(){
		int []set=new int[]{2, 3, 4, 1000};
		IntSet test = new IntSet(set);
		boolean check = test.isMember(2);
		assertEquals(true ,check);
	}
	@Test
    public void testIsMemberLast(){
		int []set=new int[]{2, 3, 4, 5};
		IntSet test = new IntSet(set);
		boolean check = test.isMember(5);
		assertEquals(true ,check);
	}
	//if element is not between 1 to 1000
	@Test(expected = AssertionError.class)
    public void testIsMemberOutOfSet(){
		int []set=new int[]{2, 3, 4, 5};
		IntSet test = new IntSet(set);
		boolean check = test.isMember(1200);
	}
	
	//size Test Cases
	@Test
	public void testSize(){
		int []set = new int[]{2,3,4,5};
		IntSet test = new IntSet(set);
		int result = test.size();
		assertEquals(4 ,result);
	}
	@Test
	public void testSizeEmpty(){
		int []set = new int[0];
		IntSet test = new IntSet(set);
		int result = test.size();
		assertEquals(0 ,result);
	}
	
	//isSubSet Test Cases
	@Test
	public void testIsSubSetYes() {
		int[]set = new int[]{1,2,3,4,5,6,7};
		IntSet setObj = new IntSet(set);
		int[]subSet = new int[]{2,4,7};
		IntSet subSetObj = new IntSet(subSet);
		boolean result = setObj.isSubSet(subSetObj);
		assertEquals(true , result);
	}
	@Test
	public void testIsSubSetNo() {
		int[]set = new int[]{1,2,3,4,5,6,7};
		IntSet setObj = new IntSet(set);
		int[]subSet = new int[]{2,4,9};
		IntSet subSetObj = new IntSet(subSet);
		boolean result = setObj.isSubSet(subSetObj);
		assertEquals(false , result);
	}
	//getComplement Test Cases
	@Test
	public void testComplement(){
		int []set = new int[]{1,2,3,4,5};
		int []expected=new int[995];
		for(int i=0 ; i<995 ;i++){
			expected[i] = i+6;
		}
		IntSet test = new IntSet(set);
		int result[] = test.getComplement();
		assertArrayEquals(expected,result);
	}
	public void testComplementEmpty(){
		int []set = new int[0];
		int []expected=new int[995];
		for(int i=0 ; i<1000 ;i++){
			expected[i] = i+1;
		}
		IntSet test = new IntSet(set);
		int result[] = test.getComplement();
		assertArrayEquals(expected,result);
	}
	//union Test Cases
	@Test
	public void testUnionAllDifferent(){
		IntSet firstSetObj = new IntSet(new int[]{1,2,3,4,5});
		IntSet secondSetObj = new IntSet(new int[]{6,7,8,9,10,11});
		int[] expected = new int[]{1,2,3,4,5,6,7,8,9,10,11};
		int result[] = secondSetObj.union(firstSetObj, secondSetObj);
        assertArrayEquals(expected,result);
	}
	@Test
	public void testUnionAllSame(){
		IntSet firstSetObj = new IntSet(new int[]{1,2,3,4,5});
		IntSet secondSetObj = new IntSet(new int[]{1,2,3,4,5});
		int[] expected = new int[]{1,2,3,4,5};
		int result[] = secondSetObj.union(firstSetObj, secondSetObj);
        assertArrayEquals(expected,result);
	}
	@Test
	public void testUnion() {
		IntSet firstSetObj = new IntSet(new int[]{1,2,4,5,7});
		IntSet secondSetObj = new IntSet(new int[]{1,2,3,6,7,8});
		int[] expected = new int[]{1,2,3,4,5,6,7,8};
		int result[] = secondSetObj.union(firstSetObj, secondSetObj);
        assertArrayEquals(expected,result);
	}
}