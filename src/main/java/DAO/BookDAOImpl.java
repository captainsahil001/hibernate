package DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.BookInformation;

public class BookDAOImpl implements BookDAO{
	EntityManager em;
	
	public BookDAOImpl(EntityManager em) {
		this.em=em;
	}
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addBook() {
		EntityTransaction et = em.getTransaction();
		et.begin(); 
		BookInformation book=new BookInformation();
		System.out.println("Enter book name");
		book.setBookTitle(sc.next());
		System.out.println("Enter book author name");
		book.setAuthor(sc.next());
		System.out.println("Enter book price");
		book.setPrice(sc.nextDouble());
		System.out.println("Enter book rating out of 5");
		book.setRating(sc.nextDouble());
		
		em.persist(book);
		System.out.println("Inserted successfully!!!");
		
		et.commit();
	}

	@Override
	public void viewBooks() {
		String select = "select book from BookInformation book";
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		Query query=em.createQuery(select);
		System.out.println(query);
		
		List<BookInformation> resultSet=query.getResultList();
		if(resultSet.size()!=0) {
			System.out.println("Data available");
			resultSet.stream().forEach(System.out::println);
		} else {
			System.out.println("Data not available");
		}
		et.commit();
	}
	
	@Override
	public void viewBooksByTitle() {
		String select="select book from BookInformation book where book.bookTitle=?1";
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		Query query=em.createQuery(select);
		System.out.println("Enter book title");
		String title=sc.next();
		query.setParameter(1, title);
		
		try {
			BookInformation book = (BookInformation) query.getSingleResult();
			System.out.println("Book name:"+book.getBookTitle());
			System.out.println("Book author:"+book.getAuthor());
			System.out.println("Book price:"+book.getPrice());
			System.out.println("Book rating:"+book.getRating());
		} catch(Exception e) {
			System.out.println("Data not found");
		}
		et.commit();
	}
	
	@Override
	public void updatePriceByBookIdAndBookAuthor() {
		String update="update BookInformation book set book.price=?1 where book.bookId=?2 and book.author=?3";
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query query = em.createQuery(update);
		
		System.out.println("Enter book price");
		double price=sc.nextDouble();
		query.setParameter(1,price);
		System.out.println("Enter book ID");
		int id=sc.nextInt();
		query.setParameter(2,id);
		System.out.println("Enter book author");
		String author=sc.next();
		query.setParameter(3,author);
		
		int rows=query.executeUpdate();
		if(rows!=0) {
			System.out.println("Data updated");
		} else {
			System.out.println("No data updated");
		}
		
		et.commit();
	}

	@Override
	public void deleteBookByTitle() {
		String delete="delete from BookInformation book where book.bookTitle=?1";
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query query = em.createQuery(delete);
		System.out.println(query);
		System.out.println("Enter book title");
		String title=sc.next();
		query.setParameter(1,title);
		
		int rows=query.executeUpdate();
		if(rows!=0) {
			System.out.println("Data deleted");
		} else {
			System.out.println("No data deleted");
		}
		
		et.commit();
	}

}
