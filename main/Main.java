package eg.edu.alexu.csd.datastructure.stack.cs88;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		while (true) {
			System.out.println("choose an action: ");
			System.out.println("1 : push");
			System.out.println("2 : pop");
			System.out.println("3 : peek");
			System.out.println("4 : Get size");
			System.out.println("5 : Ckeck if empty");
			System.out.println("6 : end");
			Scanner scan = new Scanner(System.in);
			String input = null;
			input = scan.nextLine();
			int value = 0;
			if (Character.isDigit(input.charAt(0))
				&& input.length() == 1) {
				value = Integer.parseInt(input);
			}
			else {System.out.println("wrong choice!\nenter again");}
			switch (value) {
			case 1:
			while (true) {
				System.out.println("Enter value:");
				stack.push(scan.nextLine());
				break;
				
			}
				break;
			case 2:
				try {
					stack.pop();
				} catch (Exception e) {
				System.out.println("No element to be poped");
				}
				break;
			case 3:
				try {
					System.out.println(stack.peek());
				} catch (Exception e) {
				System.out.println("No element to be peeked");
				}
				break;
			case 4:
				System.out.println(stack.size());
				break;
			case 5:
				if (stack.isEmpty()) {
				System.out.println("Stack is empty");
				} else {
				System.out.println("Stack is not empty");
				}
				break;
			case 6:
				return;
			default:
				break;
			}
		}}
}
