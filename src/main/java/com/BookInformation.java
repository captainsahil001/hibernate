package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book_Information")
public class BookInformation {
	@Id
    @Column(name = "book_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	
	@Column(name = "book_title",nullable=false)
	private String bookTitle;
	
	@Column(name = "book_author",nullable=false,unique=true)
	private String author;
	
	@Column(name = "book_price",nullable=false)
	private double price;
	
	@Column(name = "book_rating",nullable=false)
	private double rating;
	
	public BookInformation() {
		
	}
	public BookInformation(int bookId, String bookTitle, String author, double price, double rating) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.price = price;
		this.rating = rating;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "BookInformation [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + ", price="
				+ price + ", rating=" + rating + "]";
	}
}
