package lambda.observable;

public class CodeBlock {

	public static void main(String[] args) {

		CodeBlock codeBlock = new CodeBlock();

		// http://www.baeldung.com/java-8-lambda-expressions-tips
		
//		8.
		//8.1 Avoid Blocks of Code in Lambda’s Body. here you can see the usage of testmethod as a way to avoid multiple lines
		
		//8.2 Avoid Specifying Parameter Types (int num) -> codeBlock.testMethod(num);
		
		//8.3 Avoid Parentheses Around a Single Parameter (num)  -> codeBlock.testMethod(num);
		
		//8.4 Avoid Return Statement and Braces  num -> { return codeBlock.testMethod(num); };
		
		ExecuteThis executeThis =  num ->  codeBlock.testMethod(num);
		
		
//	8.5	Use Method References. this is very differnt way of using lambdas.notice we have not defined an input parameter as per the definition.
		//we have mentioned the class name and the method . here the method toLower case also expects a string input which is same as the interface
		//method definition also it returns string. Here you can call the methods already implemented from existing classes using double colon notation and 
		ExecuteThis2 executeThis2 = String::toLowerCase;
		
		
//		9. Use “Effectively Final” Variables
		
		
//		String localVariable = "Local";
		//new method definition of interface 
		 executeThis2 = parameter -> {
	        String localVariable = parameter;
	        return localVariable;
	    };
		
		ExecuteThis3 executeThis3 = System.out::println;
		

		executeThis3.methodExec("lols systout ln");
		
			
		System.out.println(executeThis2.methodExec("TOOFAN"));
		
		System.out.println(executeThis.methodExec(6));
		
		
		//. 10. Protect Object Variables from Mutation
		//Although objects are effectively final if they are used inside lambdas that is to say they can not be modified inside lambdas once assigned.
		//This does not mean that the object refrences inside are also final. 
		//in below example the total is effectively final. It can not be ressiagined or its value changed however the value of the elements inside the array can be modified.
		//Hence take extra caution while writing the code. The variables are only effectively final not the value inside them.
		int[] total = new int[1];
		System.out.println(total[0]);
		Runnable r = () -> total[0]++;
		r.run();
		
		System.out.println(total[0]);
		
	}

	
	@FunctionalInterface
	interface ExecuteThis3 {

		void methodExec(String num);
	

	}
	
	
	@FunctionalInterface
	interface ExecuteThis2 {

		String methodExec(String num);

	}


	@FunctionalInterface
	interface ExecuteThis {

		String methodExec(int num);


	}
	
	
	
	public String testMethod(int num) {
		if (num > 5)
			return "greater";

		return "smaller";

	}
	
	
}
