package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book_shelves")
public class Shelf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shelfNumber;
	private String color;
	private int dustLevel;
	@OneToMany(mappedBy="shelf", fetch=FetchType.EAGER)/*mappedBy determines the field that is representing the relationship
	 fetch determines if the object is pulled direction (EAGER) or if a proxy is returned first (LAZY).*/
	private List<Book> books;
	
	public Shelf(int shelfNumber, String color, int dustLevel, List<Book> books) {
		super();
		this.shelfNumber = shelfNumber;
		this.color = color;
		this.dustLevel = dustLevel;
		this.books = books;
	}

	public Shelf(String color, int dustLevel, List<Book> books) {
		super();
		this.color = color;
		this.dustLevel = dustLevel;
		this.books = books;
	}

	public Shelf() {
		super();
	}

	public int getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDustLevel() {
		return dustLevel;
	}

	public void setDustLevel(int dustLevel) {
		this.dustLevel = dustLevel;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + dustLevel;
		result = prime * result + shelfNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shelf other = (Shelf) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dustLevel != other.dustLevel)
			return false;
		if (shelfNumber != other.shelfNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shelf [shelfNumber=" + shelfNumber + ", color=" + color + ", dustLevel=" + dustLevel + ", books="
				+ books + "]";
	}
	
	

}
