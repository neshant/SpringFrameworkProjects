package lambda.observable;

public class DoubleTestLambda {

	public static void main(String[] args) {

		String s1 = "neshant";
		String s2 = "lifter";

		DoubleTestLambda doubleTestLambda = new DoubleTestLambda();
		doubleTestLambda.callOperation(s1, s2, (String a, String b) -> a + " " + b);

		Person person = doubleTestLambda.new Person();
		person.setName("takla pappu");
		doubleTestLambda.callFunction(person, (Object a1) -> a1.toString());
		doubleTestLambda.callFunction2(person, () -> "hello no args input method");
		MyComparator myComparator = (int a, int b) -> a > b;

		System.out.println(myComparator.compare(5, 4));

	}

	// At first, this annotation seems to be useless. Even without it, your
	// interface
	// will be treated as functional as long as it has just one abstract method.
	// using the interface functional interface enforces that there can be only one
	// abstract method definition inside this interface.
	// this means that only one method is allowed not to have a body which can be
	// defined at a later stage.
	@FunctionalInterface
	interface MyComparator {
		boolean compare(int a, int b);
	}

	@FunctionalInterface
	interface TestOperation {
		String joinStrings(String s1, String s2);
	}

	@FunctionalInterface
	interface TestFunction {
		String printName(Object a1);
	}

	@FunctionalInterface
	interface TestFunction2 {
		String printName();
	}

	public void callFunction(Person person, TestFunction testFunction) {
		System.out.println(testFunction.printName(person));
	}

	public void callFunction2(Person person, TestFunction2 testFunction) {
		System.out.println(testFunction.printName());
	}

	public void callOperation(String s1, String s2, TestOperation testOperation) {
		System.out.println(testOperation.joinStrings(s1, s2));
	}

	public class Person {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name;
		}

	}

}
