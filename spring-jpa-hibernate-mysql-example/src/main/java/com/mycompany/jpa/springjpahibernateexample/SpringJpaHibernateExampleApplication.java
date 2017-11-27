package com.mycompany.jpa.springjpahibernateexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.mycompany.jpa.springjpahibernateexample.repository")
@SpringBootApplication
public class SpringJpaHibernateExampleApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SpringJpaHibernateExampleApplication.class, args);

//		List<Habbit> list1 = new ArrayList<Habbit>();
//		list1.add(new Habbit().setIntensity(10).setType("happy"));
//		list1.add(new Habbit().setIntensity(5).setType("joy"));
//		list1.add(new Habbit().setIntensity(4).setType("sad"));
//		list1.add(new Habbit().setIntensity(3).setType("anger"));
//		list1.add(new Habbit().setIntensity(5).setType("lust"));
//
//		List<Habbit> list2 = new ArrayList<Habbit>();
//		list2.add(new Habbit().setIntensity(1).setType("happy"));
//		list2.add(new Habbit().setIntensity(2).setType("joy"));
//		list2.add(new Habbit().setIntensity(3).setType("sad"));
//		list2.add(new Habbit().setIntensity(4).setType("anger"));
//		list2.add(new Habbit().setIntensity(5).setType("lust"));
//
//		List<Habbit> list3 = new ArrayList<Habbit>();
//		list3.add(new Habbit().setIntensity(10).setType("happy"));
//		list3.add(new Habbit().setIntensity(5).setType("joy"));
//		list3.add(new Habbit().setIntensity(4).setType("sad"));
//		list3.add(new Habbit().setIntensity(3).setType("anger"));
//		list3.add(new Habbit().setIntensity(5).setType("lust"));
//
//		Person p = new Person().setDrivingLicense(123).setFirstName("mayank").setHabbits(list1);
//		Person p3;
//		Person p2 = new Person().setDrivingLicense(123).setFirstName("mayank").setHabbits(list3);
//		p3 = p;
//		System.out.println(p.equals(p3));
//		System.out.println(p.equals(p2));
//
//		System.out.println(p);
//		System.out.println(p2);
	}
}
