package eg.edu.alexu.csd.datastructure.stack.cs88;

import java.util.Scanner;

class Mainevaluate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flag=1;
		ExpressionEvaluator exp=new ExpressionEvaluator();
	   while (flag==1) {
		   System.out.println("Enter the infix expression: ");
		   Scanner scan = new Scanner(System.in);
		   String input = null;
		   input = scan.nextLine();
		   try {
			   
			   String postfix= exp.infixToPostfix(input);
			   System.out.println("The postfix expression:");
			   System.out.println(postfix);
			   try {
					   int v=exp.evaluate(postfix);
					   System.out.println("the value:");
					   System.out.println(v);
				   }catch (Exception e) {
					   System.out.println("can't be evaluated");
				   }  
			   
			   
		   }catch (Exception e) {
			   System.out.println("wrong expression!");
		   }
		   
		   System.out.println(" to enter again >>1    exit>>0");
		   flag  = scan.nextInt();
			while(flag!=0&&flag!=1){
				System.out.println("Invalid choice !");
				System.out.println(" to enter again>>1    exit>>0");
				flag=scan.nextInt();
			}

	   }		
		
		
	}

}
