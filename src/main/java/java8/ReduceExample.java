package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import common.Person;

public class ReduceExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charles", "Dickens", 60),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		people = Arrays.asList(); /*Enable to test null handling*/
		
		System.out.println("Printing ifPresent:");
		people.stream().reduce((a,b) -> a.getAge() > b.getAge() ? a : b).ifPresent(System.out::println);
		
		System.out.println("Printing using local variable 1:");
		Optional<Person> perOptional = people.stream().reduce((a,b) -> a.getAge() > b.getAge() ? a : b);
		Person data1 = perOptional.isPresent() ? perOptional.get() : null;
		System.out.println(data1);
		
		System.out.println("Printing using local variable 2:");
		Person data2 = Optional.ofNullable(people.stream().reduce((a,b) -> a.getAge() > b.getAge() ? a : b)).get().orElse(null);
		System.out.println(data2);
		
		/*
		System.out.println("Printing first/last element based on reduction:");
		people.stream().reduce((a,b) -> b).ifPresent(System.out::println);
		
		people.stream().map(Person::getAge).forEach((a)->System.out.println(a+2));
		people.stream().sorted(Comparator.comparing(Person::getAge, Comparator.reverseOrder())).findFirst().ifPresent(System.out::println);
		

		// Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		people.forEach(System.out::println); 

		// Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println("\n Printing all persons with last name beginning with C");
		people.stream().filter(p -> p.getLastName().startsWith("C")).forEach(System.out::println); 

		System.out.println("\n Printing all persons with first name beginning with C");
		people.stream().filter(p -> p.getFirstName().startsWith("C")).forEach(System.out::println); */

	}

}
