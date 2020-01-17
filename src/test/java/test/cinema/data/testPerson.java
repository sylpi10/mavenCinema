package test.cinema.data;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import cinema.data.Person;

class testPerson {

	@Test
	void testCreate() {
		Person phoenix = new Person("Joaquin Phoenix", LocalDate.of(1974, 10, 28));
		System.out.println(phoenix + " : " + phoenix.getAge());
		Person darmon = new Person("Gérard Darmon", LocalDate.of(1948, 02, 29));
		System.out.println(darmon + " : " + darmon.getAge());
		Person todd = new Person("Todd Phillips", LocalDate.of(1970, 12, 20));
		System.out.println(todd + " : " + todd.getAge());
	}

}
