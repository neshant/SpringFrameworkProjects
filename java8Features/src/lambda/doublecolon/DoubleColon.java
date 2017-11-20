package lambda.doublecolon;

import java.util.Arrays;
import java.util.List;

public class DoubleColon {

	
	public static void main(String[] args) {
	
	DoubleColonComputer c1 = new DoubleColonMicrosoftSurface(2015, "windows", 100);
	DoubleColonComputer c2 = new DoubleColonMacbookPro(2009, "mac", 100);
	List<DoubleColonComputer> inventory = Arrays.asList(c1, c2);	
	inventory.forEach(DoubleColonComputer::turnOnPC);
	}
	
	
	
}
