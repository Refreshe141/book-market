package com.market.bookitem;
public abstract class Item { 
    String bookId;
    String name;
    int unitPrice;

    public Item(String bookId, String name, int unitPrice) {
        this.bookId = bookId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // ❌ 오류 수정: 추상 메서드는 반드시 구현해야 하므로 제거 또는 하위 클래스에서 구현 필요
    public abstract String getBookId(); 
    public abstract String getName();
    public abstract int getUnitPrice();
    
    public abstract void setBookId(String bookId);
    public abstract void setName(String name); // ✔ 변수 이름 수정 (대문자 'N' 제거)
    public abstract void setUnitPrice(int unitPrice);
}



