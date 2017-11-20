package lambda.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class LambdaObservable {

	
	
	/**
	 * Observalable message board to which will notify all the observers of the change
	 * @author neshant
	 *
	 */
	public class MessageBoard extends Observable {
		public void changeMessage(String message) {
			setChanged();
			notifyObservers(message);
		}
	}

	/**
	 * Type observers which will be oberving an observable and get notified of the change
	 * @author neshant
	 *
	 */
	class Student implements Observer {
		@Override
		public void update(Observable o, Object arg) {
			System.out.println("Message board changed: " + arg);
		}
	}

	public static void main(String args[]) {
		
		LambdaObservable tester = new LambdaObservable();
		
		MessageBoard board = tester.new MessageBoard();
        Student bob = tester.new Student();
        Student joe = tester.new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");

		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		List<String> names = new ArrayList<String>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		names.forEach(System.out::println);
		List<String> collect = names.stream().map(i->i).collect(Collectors.toList());
		System.out.println(collect);
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(11);
		numbers.add(12);
		numbers.add(13);
		numbers.add(14);
		numbers.add(5);

		sumStream(numbers);

		// without parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// with parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	private static void sumStream(List<Integer> list) {
		list.stream().filter(j -> j > 10).limit(2).forEach(System.out::println);
	}
}