package eg.edu.alexu.csd.datastructure.stack.cs88;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	@Test
	public void test1() {
		Stack s = new Stack();
		 Assert.assertTrue(s.isEmpty());
	     Assert.assertEquals(0,s.size());
		}
 
	@Test(expected = Exception.class)
	public void test2() {
		Stack s = new Stack();
		 Assert.assertTrue(s.isEmpty());
	     Assert.assertEquals(0,s.size());
	     Assert.assertNull(s.peek());
		 }


	@Test(expected = Exception.class)
	public void test3() {
	  Stack s = new Stack();
		 Assert.assertTrue(s.isEmpty());
	     Assert.assertEquals(0,s.size());
	     Assert.assertNull(s.pop());}

	
	@Test
	public void test4() {
		 Stack s = new Stack();
		 s.push(5);
		 s.push(20);
		 s.push(50);
		 Assert.assertFalse(s.isEmpty());
	     Assert.assertEquals(3,s.size());
	     int v=(int) s.pop();
	     Assert.assertEquals(50,v);
	     Assert.assertEquals(2,s.size());
	     int c=(int) s.peek();
	     Assert.assertEquals(20,c);
	     Assert.assertEquals(2,s.size());
	     v= (int) s.pop();
	     v=(int) s.pop();
	     Assert.assertEquals(0,s.size());
	     Assert.assertTrue(s.isEmpty());

	     }

	
	@Test(expected = Exception.class)
	public void test5() {
		 Stack s = new Stack();
		 s.push(5);
		 s.push(20);
		 s.push(50);
		 Assert.assertFalse(s.isEmpty());
	     Assert.assertEquals(3,s.size());
	     int v=(int) s.pop();
	     Assert.assertEquals(50,v);
	     Assert.assertEquals(2,s.size());
	     int c=(int) s.peek();
	     Assert.assertEquals(20,c);
	     Assert.assertEquals(2,s.size());
	     v= (int) s.pop();
	     v=(int) s.pop();
	     Assert.assertEquals(0,s.size());
	     v=(int) s.pop();
	     v=(int) s.peek();
	     Assert.assertTrue(s.isEmpty());

	}

}
