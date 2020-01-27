package cinema.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
	
	private Integer idPerson;
	private String name;
	private LocalDate birthdate;
	
	public Person(Integer idPerson, String name, LocalDate birthdate) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public Person(String name, LocalDate birthDate) {
		this(null, name, birthDate);
	}
	
	public Person(String name) {
		this(null, name, null);
	}
	
	public Person() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	@Column(nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthDate) {
		this.birthdate = birthDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(name);
		return builder.append(" (").append(birthdate).append("). #").append(idPerson).toString();
	}
	
}
