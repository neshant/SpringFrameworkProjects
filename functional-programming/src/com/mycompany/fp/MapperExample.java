package com.mycompany.fp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "sam", "Greg", "Ryan");	

	List<User>	list= names.stream()
		.filter(name -> !name.equalsIgnoreCase("sam"))
		.map(User::new)//calling the constructor using ajeeb way  calling new on object with double colon notation
		.collect(Collectors.toList());//collect is another terminal operation.
	
	System.out.println("-------------");
	
	
	
	int sum =list.stream()
	.mapToInt(user-> user.getAge())
	.sum();
	
	
	int sum2 =list.stream()
			.mapToInt(User::getAge)
			.sum();//sum is a terminal operation
	
	System.out.println(sum +" "+ sum2);
	
	
		
	}
	
	
	

	static class User {
		private String name;
		private Integer age=10;

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
