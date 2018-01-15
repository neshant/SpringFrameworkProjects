package lambda.observable;

public class OverrridingFunctionalInterface {
	public static void main(String[] args) {

		MathOperation addOP = (int a, int b) -> a + b;
		OverrridingFunctionalInterface mtest = new OverrridingFunctionalInterface();
		System.out.println(mtest.operate(4, 5, addOP));
		System.out.println(mtest.operate(6, 7, (int a, int b) -> a * b));


	}

	@FunctionalInterface
	interface MathOperation {
		double operation(int a, int b);
	}

	private double operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	@FunctionalInterface
	interface testNormalInterface {
		double valueOfPi();

		default void valueOfPi2() {

		}

		static double testNew() {
			return 0;
		}
	}

	// the below example is to demonstrate that two functional interfaces can be
	// overridden by a third functional interface provided both the interface being
	// overridden have the same abstract method.

	@FunctionalInterface
	public interface FooExtended extends Baz, Bar {

		@Override
		default void common() {
			// TODO Auto-generated method stub
			Baz.super.common();
		}
	}

	@FunctionalInterface
	public interface Baz {
		String method();

		default void defaultBaz() {
		}

		default void common() {
		}
	}

	@FunctionalInterface
	public interface Bar {
		String method();

		default void defaultBar() {
		}

		default void common() {
		}
	}
}
