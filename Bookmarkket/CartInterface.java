package com.market.cart;
import java.util.ArrayList;
import com.market.bookitem.Book;

public interface CartInterface {
	void printBookList(ArrayList<Book>);
	boolean isCartInBook(String id);
	void insertBook(Book p);
	void removeCart(int numid);
	void deleteBook();

}
