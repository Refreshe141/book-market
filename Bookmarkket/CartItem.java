package com.market.cart;
import com.market.bookitem.Book;

public class CartItem {
	//private String[]itemBook = new String[7];
	private Book itemBook;
	private String bookID;
	private int quantity;
	private int totalPrice;
	
	
	public CartItem() {
		
		
	}
	//아내 내용 주석처리
	//public CartItem(String[]book){
		//this.itemBook = book;
		//this.bookID = book[0];
		//this.quantity = 1;
		//updateTotalPrice();						
	//}
	
	//public String[]getItemBook(){
		//return itemBook;
	//}
	//public void setItemBook(String[]itemBook) {
		//this.itemBook = itemBook;
	//}
	
	//신규 코드 생성
	public CartItem(Book booklist) {
		this.itemBook = booklist;
		this.bookID = booklist.getBookId();
		this.quantity = 1;
		updateTotalPrice();
	}
	
	public Book getItemBook() {
		return itemBook;
	}
	
	public void setItemBook(Book itemBook) {
		this.itemBook = itemBook;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
		this.updateTotalPrice();	
	}
	public int getquantity() {
		return quantity;		
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();		
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void updateTotalPrice() {
//주석처리 totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity;
		totalPrice = this.itemBook.getUnitPrice() * this.quantity;
	
	}
	

}
