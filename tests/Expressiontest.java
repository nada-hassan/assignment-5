package eg.edu.alexu.csd.datastructure.stack.cs88;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;



public class Expressiontest {

	@Test
	public void test1() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="2 + 3 * 4";
		String postfix= e.infixToPostfix(str);
		int v=e.evaluate(postfix);
		String expected ="2 3 4 * +";
		 assertEquals(expected, postfix);
		 assertEquals(14, v);
		}
 
	@Test(expected = Exception.class)
	public void test2() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="a * b + 5";
		String postfix= e.infixToPostfix(str);
	    e.evaluate(postfix);
		String expected ="a b * 5 +";
		assertEquals(expected, postfix);
		 }


	@Test
	public void test3() {
	    ExpressionEvaluator e = new ExpressionEvaluator();
		String str="(1 + 2) * 7";
		String postfix= e.infixToPostfix(str);
		int v=e.evaluate(postfix);
		String expected ="1 2 + 7 *";
		 assertEquals(expected, postfix);
		 assertEquals(21, v);}

	
	@Test(expected = Exception.class)
	public void test4() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="a * b / c";
		String postfix= e.infixToPostfix(str);
		e.evaluate(postfix);
		String expected ="a b * c /";
		assertEquals(expected, postfix);}

	
	@Test(expected = Exception.class)
	public void test5() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="(a / (b - c + d)) * (e - a) * c";
		String postfix= e.infixToPostfix(str);
		e.evaluate(postfix);
		String expected ="a b c - d + / e a - * c *";
		assertEquals(expected, postfix);
	}

	@Test(expected = Exception.class)
	public void test6() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="a / b - c + d * e - a * c";
		String postfix= e.infixToPostfix(str);
		e.evaluate(postfix);
		String expected ="a b / c - d e * + a c * -";
		assertEquals(expected, postfix);
	}

	@Test(expected = Exception.class)
	public void test7() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="a / b - c + d * e - a * c";
		String postfix= e.infixToPostfix(str);
		e.evaluate(postfix);
	}
	
	@Test
	public void test8() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="5*-2 + 3/-1 -4";
		String postfix= e.infixToPostfix(str);
		int v=e.evaluate(postfix);
		String expected ="5 0 2 - * 3 0 1 - / + 4 -";
		 assertEquals(expected, postfix);
		 assertEquals(-17, v);
		}

	@Test(expected = Exception.class)
	public void test9() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="2 + 3 ** 4";
		String postfix= e.infixToPostfix(str);
		e.evaluate(postfix);
		
		}
	@Test(expected = Exception.class)
	public void test10() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="2 +++ 34";
		String postfix= e.infixToPostfix(str);
		e.evaluate(postfix);
		
		}
	@Test
	public void test11() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="20*5 + (6/2)";
		String postfix= e.infixToPostfix(str);
		int v=e.evaluate(postfix);
		String expected ="20 5 * 6 2 / +";
		 assertEquals(expected, postfix);
		 assertEquals(103, v);
		}
	@Test(expected = Exception.class)
	public void test12() {
		ExpressionEvaluator e = new ExpressionEvaluator();
		String str="3+7+((8)*5))-3*4";
		String postfix= e.infixToPostfix(str);
		e.evaluate(postfix);
		 }
}
