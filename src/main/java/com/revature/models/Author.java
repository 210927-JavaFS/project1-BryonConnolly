package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private int yearBorn;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id")
	private Language nativeLanguage;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Book> bibliography;
	
	public Author(int id, String firstName, String lastName, int yearBorn, Language nativeLanguage,
			List<Book> bibliography) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.nativeLanguage = nativeLanguage;
		this.bibliography = bibliography;
	}

	public Author(String firstName, String lastName, int yearBorn, Language nativeLanguage, List<Book> bibliography) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.nativeLanguage = nativeLanguage;
		this.bibliography = bibliography;
	}

	public Author() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public Language getNativeLanguage() {
		return nativeLanguage;
	}

	public void setNativeLanguage(Language nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
	}

	public List<Book> getBibliography() {
		return bibliography;
	}

	public void setBibliography(List<Book> bibliography) {
		this.bibliography = bibliography;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bibliography, firstName, id, lastName, nativeLanguage, yearBorn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		return Objects.equals(bibliography, other.bibliography) && Objects.equals(firstName, other.firstName)
				&& id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(nativeLanguage, other.nativeLanguage) && yearBorn == other.yearBorn;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn
				+ ", nativeLanguage=" + nativeLanguage + ", bibliography=" + bibliography + "]";
	} 
	
	
	
	
	
	

}
