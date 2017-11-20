package lambda.doublecolon;

public class DoubleColonMicrosoftSurface implements DoubleColonComputer {

	int price;
	String name;
	int year;

	public DoubleColonMicrosoftSurface(int i, String string, int j) {
		this.price = i;
		this.name = string;
		this.year = j;

	}

	@Override
	public void turnOnPC() {
		System.out.println("I am" + name);

	}
}
