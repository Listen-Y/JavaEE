package com.itheima.book;

public class Book {
	private int id;
	private String title;
	private String author;
	private String publishing;
	private double price;
	private String publicationDate;
	public Book() {
		super();
	}
	public Book(int id, String title, String author, String publishing, double price, String publicationDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishing = publishing;
		this.price = price;
		this.publicationDate = publicationDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishing=" + publishing + ", price="
				+ price + ", publicationDate=" + publicationDate + "]";
	}
	
	
	
	
}
