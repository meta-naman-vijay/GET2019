package testing;


	import static org.junit.Assert.*;
	import org.junit.Test;

	public class ArrOperationTest {

		ArrOperation arrop = new  ArrOperation(); 
		@Test
		public void testSizeOfLargestMirror1() {
			 int[] arr = new int[]{1, 2, 3,8 ,9 ,3 ,2 , 1}; 
			 int result =  arrop.maxMirror(arr);
			 assertEquals(3, result );
		}
		@Test 
		public void testSizeOfLargestMirror2() {
			 int[] arr = new int[]{7, 1, 4, 9, 7, 4, 1}; 
			 int result =  arrop.maxMirror(arr);
			 assertEquals(2, result );
		}
		@Test	 
		public void testSizeOfLargestMirror3() {
			 int[] arr = new int[]{1, 2, 1, 4}; 
			 int result =  arrop.maxMirror(arr);
			 assertEquals(3, result );
		}
		@Test	 
		public void testSizeOfLargestMirror4() {
			 int[] arr = new int[]{1, 4, 5, 3, 5, 4, 1}; 
			 int result =  arrop.maxMirror(arr);
			 assertEquals(7, result );
		}
		@Test
		public void testFixXY1(){
			int[] arr = new int[]{5, 4, 9, 4, 9, 5};
			int[] expected = new int[]{9, 4, 5, 4, 5, 9};
			int result[] = arrop.fixXY(arr, 4, 5);
			assertArrayEquals(expected, result);
		}
		@Test
		public void testFixXY2(){
			int[] arr = new int[]{1, 4, 1, 5};
			int[] expected = new int[]{1, 4, 5, 1};
			int result[] = arrop.fixXY(arr, 4, 5);
			assertArrayEquals(expected, result);
		}
		@Test
		public void testFixXY3(){
			int[] arr = new int[]{1, 4, 1, 5, 5, 4, 1};
			int[] expected = new int[]{1, 4, 5, 1, 1, 4, 5};
			int result[] = arrop.fixXY(arr, 4, 5);
			assertArrayEquals(expected, result);
		}
		@Test
		public void testNumberOfClumbs1(){
			int[] arr= new int[]{1, 2, 2, 3, 4, 4};
			int result = arrop.numberOfClumps(arr);
			assertEquals(2, result);
		}
		@Test
		public void testNumberOfClumbs2(){
			int[] arr= new int[]{1, 1, 2, 1, 1};
			int result = arrop.numberOfClumps(arr);
			assertEquals(2, result);
		}
		@Test
		public void testNumberOfClumbs3(){
			int[] arr= new int[]{1, 1, 1, 1};
			int result = arrop.numberOfClumps(arr);
			assertEquals(1, result);
		}
		@Test 
		public void testSplitArray1() {
			int[] arr = new int[] {1, 1, 1, 2, 1};
			int result = arrop.splitArray(arr);
			assertEquals(3,result);
		}
		@Test 
		public void testSplitArray2() {
			int[] arr = new int[] {2, 1, 1, 2, 1};
			int result = arrop.splitArray(arr);
			assertEquals(-1,result);
		}
		@Test 
		public void testSplitArray3() {
			int[] arr = new int[] {10,10};
			int result = arrop.splitArray(arr);
			assertEquals(1,result);
		}
		@Test(expected = AssertionError.class)
	    public void testSizeOfLargestMirrorException()
	    {
			 int result =  arrop.maxMirror(new int[0]);
	    }
		@Test(expected = AssertionError.class)
		public void testNumberOfClumpsException()
		{
			int result = arrop.numberOfClumps(new int[0]);
		}
		@Test(expected = AssertionError.class)
		public void testSplitArrayException()
		{
			 int result =  arrop.splitArray(new int[0]);
		}
		@Test(expected = AssertionError.class)
		public void testFixXYEmptyException()
		{
			int result[] = arrop.fixXY(new int[0], 4, 5);
		}
		@Test(expected = AssertionError.class)
		public void testFixXYLastPosException()
		{
			int result[] = arrop.fixXY(new int[]{1,3,5,4,5,4}, 4, 5);
		}
		@Test(expected = AssertionError.class)
		public void testFixXYAdjecentException()
		{
			int result[] = arrop.fixXY(new int[]{1,4,4,5,6,5}, 4, 5);
		}
		@Test(expected = AssertionError.class)
		public void testFixXYUnequalException()
		{
			int result[] = arrop.fixXY(new int[]{4,1,4,5,3}, 4, 5);	
		}

	}

