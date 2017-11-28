package com.mycompany.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapperExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "sam", "Greg", "Ryan");

		

		names.stream()
		.filter(name -> !name.equalsIgnoreCase("sam"))
		.map(new Function<String, User>() {

			@Override
			public User apply(String t) {

				return new User(t);
			}
		})
		.forEach(System.out::println);
		
		names.stream()
		.filter(name -> !name.equalsIgnoreCase("sam"))
		.map(name-> new User(name))
		.forEach(System.out::println);//foreach is a terminal operation after this flow of 
		//stream will stop no other operation can be perfomed after this.
		
		names.stream()
		.filter(name -> !name.equalsIgnoreCase("sam"))
		.map(name-> new User(name))
		.forEach(System.out::println);
		
		
	List<User>	list= names.stream()
		.filter(name -> !name.equalsIgnoreCase("sam"))
		.map(User::new)//calling the constructor using ajeeb way  calling new on object with double colon notation
		.collect(Collectors.toList());//collect is another terminal operation.
	
	System.out.println("-------------");
	
	list.stream()
	.forEach(System.out::println);
		
	}
	
	
	

	static class User {
		private String name;
		private int age;

		public User(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}

		
	}

}
