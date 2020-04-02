package eg.edu.alexu.csd.datastructure.stack.cs88;
/**
 * class to implement the interface IStack
 * 
 * @author Nada Hassan
 *
 */
public class Stack implements IStack {
	/**
	 * class represent the element in Stack
	 * and assign it to its value
	 * 
	 * @author Nada Hassan
	 *
	 */
	public class Node {
		
		public Object element;
		
		public Node next;

		public Node(Object value) {
				this.element = value;
		}
	}
	
	Node top;
	int size;
	/**
	 * class to initialize the values of top and size
	 * 
	 * @author Nada Hassan
	 *
	 */
	Stack(){
		top=null;
	size=0;
	}
	/**
	* Removes the element at the top of stack and returns that element.
	* decrements the size of stack 
	*
	*
	* @return top of stack element, or throw exception if empty and top equal null
	*/
	@Override
	public Object pop() {
		if(top==null) {
			throw null;
		}
		Node saved=top;
		top=top.next;
		saved.next=null;
		size--;
		return saved.element;
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or throw exception if empty
	*/
	@Override
	public Object peek() {
		if(size==0) {
			throw null;
		}
		return top.element;
	}
	/**
	* Pushes an item onto the top of this stack.
	* increments the size of stack 
	* @param object
	* to insert
	*/
	@Override
	public void push(Object element) {
		Node saved=new Node(element);
		saved.next=top;
		top=saved;
		size++;
	}
	/**
	* Tests if this stack is empty by its size
	*
	* @return true if stack empty
	*/
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	/**
	* Returns the number of elements in the stack.
	*
	* @return number of elements in the stack
	*/
	@Override
	public int size() {
		return size;
	}

}
