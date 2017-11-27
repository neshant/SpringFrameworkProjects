package com.mycompany.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;

public class FilterExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "sam", "Greg", "Ryan");

		names.stream().filter(name -> isNotSam(name)).forEach(loopOverData());
		
		names.stream().filter(name -> !name.equalsIgnoreCase("sam")).forEach(name -> {
			System.out.println(name.toLowerCase());
			System.out.println(name.toUpperCase());
//			System.out::print;
		});
		
		names.stream().filter(FilterExample::isNotSam).forEach(name -> {
			System.out.println(name.toLowerCase());
			System.out.println(name.toUpperCase());
//			System.out::print;
		});
//names.stream().collect(new Collector<T, A, R>))
	}

	private static Consumer<? super String> loopOverData() {
		return name -> {
			System.out.println(name.toLowerCase());
			System.out.println(name.toUpperCase());
//			System.out::print;
		};
	}

	private static boolean isNotSam(String name) {
		return !name.equalsIgnoreCase("sam");
	}

}
