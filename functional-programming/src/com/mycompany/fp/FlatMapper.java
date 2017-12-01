package com.mycompany.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapper {

	public static void main(String[] args) {

		List<User> names = Arrays.asList(new User("Peter", 30, Arrays.asList("1", "4")),
				new User("japan", 30, Arrays.asList("3", "6")), new User("tesla", 30, Arrays.asList("2", "7")),
				new User("apple", 30, Arrays.asList("10", "5")), new User("cat", 30, Arrays.asList("8", "9")));

		Predicate<? super String> isAuthorized = new Predicate<String>() {

			@Override
			public boolean test(String user) {
				// TODO Auto-generated method stub
				return user.equals("5");
			}
		};

		Optional<Object> abc = names.stream().map(user -> user.getPhoneNumbers().stream()).flatMap(new Function<Stream<String>, Stream<?>>() {

			@Override
			public Stream<?> apply(Stream<String> t) {
				return t.filter(
						
					new Predicate<String>() {

						public boolean test(String t) {
							// TODO Auto-generated method stub
							return t.equals("r5");
						}
						
					}

				);
			}

		}).findAny();
		
		
		Optional<String> abc2 = names.stream().map(user -> user.getPhoneNumbers().stream()).flatMap(phonStream->phonStream.filter(phone->phone.equals("6"))).findAny();

		
		abc2.ifPresent(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				// TODO Auto-generated method stub
				
			}
		});
		
		abc2.ifPresent(System.out::println);
		
		System.out.println("here");
		abc2.ifPresent(data->System.out.println(data));

	}
	

	static class User {
		private String name;
		private int age;
		private List<String> phoneNumbers;

		public User(String name, int age, List<String> phoneNum) {
			super();
			this.name = name;
			this.age = age;
			this.phoneNumbers = phoneNum;
		}

		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNum(List<String> phoneNum) {
			this.phoneNumbers = phoneNum;
		}

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
