package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	private int ISBN;
	@Column(nullable=false)
	private String title;
	private String author;
	private String genre;
	private int funLevel;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="shelfNumber")
	private Shelf shelf;
	
	public Book(int iSBN, String title, String author, String genre, int funLevel, Shelf shelf) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.funLevel = funLevel;
		this.shelf = shelf;
	}

	public Book() {
		super();
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getFunLevel() {
		return funLevel;
	}

	public void setFunLevel(int funLevel) {
		this.funLevel = funLevel;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + funLevel;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((shelf == null) ? 0 : shelf.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (ISBN != other.ISBN)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (funLevel != other.funLevel)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (shelf == null) {
			if (other.shelf != null)
				return false;
		} else if (!shelf.equals(other.shelf))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", genre=" + genre + ", funLevel="
				+ funLevel + ", shelf=" +( (shelf!=null)?shelf.getShelfNumber():0 )+ "]";
	}
	
	
	
	
	

}
