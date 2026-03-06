package DAO;

public interface BookDAO {
	void addBook();
    void viewBooks();
    void viewBooksByTitle();
    void updatePriceByBookIdAndBookAuthor();
    void deleteBookByTitle();
    
}
