package eg.edu.alexu.csd.datastructure.stack.cs88;
/**
 * class to implement the interface IExpressionEvaluator
 * 
 * @author Nada Hassan
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	*throw exception if there is no expression or null and if it enters with a wrong form
	*
	* @param expression
	* infix expression
	* @return postfix expression
	* with spaces
	*/
	
	public String infixToPostfix(String expression) {
		
		
		if (expression == null
				|| expression.length() == 0) {
				throw new UnsupportedOperationException();
				}
		
		StringBuilder exp= form(expression);
		StringBuilder postfix =new StringBuilder();
		Stack s=new Stack();
		Stack t=new Stack();
		
		for(int i=0;i<exp.length() ; i++) {
			
			if(exp.charAt(i)=='(') {
				t.push(exp.charAt(i));
			}
			
			else if(exp.charAt(i)==')' ) {
				
				if(t.size!=0) {t.pop();}
				
				else {throw new UnsupportedOperationException();}
			}
		}
		
		if(t.size()!=0) {throw new UnsupportedOperationException();}
		
		for (int i = 0; i < exp.length() ;) {
			
			if(exp.charAt(i)!=' ' && exp.charAt(i)!='*' && exp.charAt(i)!='+' &&exp.charAt(i)!='/' &&
					exp.charAt(i)!='-' && exp.charAt(i)!='(' && exp.charAt(i)!=')') {
				
				if(postfix.length()==0)
				{
					postfix.append(exp.charAt(i));i++;}
				
				else if(exp.charAt(i-1)!=' ' && exp.charAt(i-1)!='*' && exp.charAt(i-1)!='+' 
						&& exp.charAt(i-1)!='/' &&
						exp.charAt(i-1)!='-' && exp.charAt(i-1)!='(' && exp.charAt(i-1)!=')') 
				{
					postfix.append(exp.charAt(i));i++;
				}
				
				else {
					postfix.append(' ');
					postfix.append(exp.charAt(i));i++;
				}
			}
			
			else if((exp.charAt(i)=='*' || exp.charAt(i)=='+' ||exp.charAt(i)=='/' ||
					exp.charAt(i)=='-' || exp.charAt(i)=='(' )&& s.size==0)
			{
				s.push(exp.charAt(i));i++;
			}
			
			else if(exp.charAt(i)=='(') 
			{s.push(exp.charAt(i));i++;}
			
			else if((exp.charAt(i)=='*' || exp.charAt(i)=='/') 
					&& ((char)s.peek()=='+' || (char)s.peek()=='-')) 
			{
				s.push(exp.charAt(i));i++;
			}
			
			else if((exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='/' || exp.charAt(i)=='*') 
			&& ((char)s.peek()=='*' || (char)s.peek()=='/'|| (char)s.peek()=='+' || (char)s.peek()=='-'))
			{
				postfix.append(' ');
				postfix.append(s.pop());
			}
			
			else if(exp.charAt(i)==')') 
			{
				char c=(char) s.pop();
				
				while(c!='(') {
					postfix.append(' ');
					postfix.append(c);
					c=(char) s.pop();
				}
				i++;
			}
			
			else if (exp.charAt(i)!=' ')
			{s.push(exp.charAt(i));i++;}
			
			else 
			{i++;}
		}
		
		while(s.size!=0) {
			postfix.append(' ');
			postfix.append(s.pop());
		}
		
		return postfix.toString();
	}
	
	
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	* throw exception if there's characters instead of numbers
	*
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	
	
	@Override
	public int evaluate(String expression) {
		
		StringBuilder b=new StringBuilder();
		Stack s=new Stack();
		int result=0;
		
		for(int i=0;i<expression.length() ; i++) {
			
			if(expression.charAt(i)!=' ' && expression.charAt(i)!='-' 
				&& expression.charAt(i)!='+' && expression.charAt(i)!='*' && expression.charAt(i)!='/') {
				b.append(expression.charAt(i));
				
				if(expression.charAt(i+1)==' ') {
					String str=b.toString();
					
					try {
					s.push(Integer.parseInt(str));}
					catch(Exception e) {
						throw new UnsupportedOperationException();
					}
					
					while(b.length()!=0) {
						b.deleteCharAt(0);
					}
				}
			}
			
			else if(expression.charAt(i)=='+') {
				result=(int)s.pop() + (int)s.pop();
				s.push(result);
			}
			
			else if(expression.charAt(i)=='-') {
				result=(int)s.pop() - (int)s.pop();
				s.push(result*-1);
			}
			
			else if(expression.charAt(i)=='*') {
				result=(int)s.pop() * (int)s.pop();
				s.push(result);
			}
			
			else if(expression.charAt(i)=='/'){
				int r1=(int)s.pop();int r2=(int)s.pop();
				if(r1==0) {throw new UnsupportedOperationException();}
				result= r2/r1 ;
				s.push(result);
			}
		}
		
		return (int)s.pop();
	}
	
	/**
	* make sure of its form and remove spaces if any.
	* throw exception if there are two operations adjacant
	* use dummy zero on negative cases  
	*
	* @param expression
	* postfix expression
	* @return the expression in its final form
	*/
	
	StringBuilder form(String s) {
		StringBuilder e=new StringBuilder(s);
		StringBuilder f=new StringBuilder();
		
		for(int i=0; i< e.length(); i++)
		{
			if(e.charAt(i) != ' ') {
			f.append(e.charAt(i));
		}
		}
		StringBuilder n=new StringBuilder();
		
		for(int i=0;i<f.length()-1 ; i++) {
			
			if((f.charAt(i)=='+' || f.charAt(i)=='*' ||f.charAt(i)=='/' || f.charAt(i)=='-') 
					&& (f.charAt(i+1)=='+' || f.charAt(i+1)=='*' ||f.charAt(i+1)=='/')){
				throw new UnsupportedOperationException();
			}
			
			else if(i==f.length()-2 &&(f.charAt(i)=='+' || f.charAt(i)=='*' ||f.charAt(i)=='/' || f.charAt(i)=='-') 
					&& f.charAt(i+1)=='-' ){
				throw new UnsupportedOperationException();
			}
			}
		
		for(int i=0; i< f.length(); i++)
		{
			if(n.length()==0 && f.charAt(i)=='-') {
				n.append('(');
				n.append(0);
				n.append(f.charAt(i));
				n.append(f.charAt(i+1));
				n.append(')');
				i++;
			}
			
			else if(i+2 < f.length() && (f.charAt(i)=='+'|| f.charAt(i) == '*'|| f.charAt(i)=='/'|| f.charAt(i)=='('||f.charAt(i)=='-')&& f.charAt(i+1)=='-'){
				n.append(f.charAt(i));
				n.append('(');
				n.append(0);
				n.append(f.charAt(i+1));
				n.append(f.charAt(i+2));
				n.append(')');
				i=i+2;
			}
			
			else {n.append(f.charAt(i));
				
			}
		}
		
		return n;
		
	}
	}

 
