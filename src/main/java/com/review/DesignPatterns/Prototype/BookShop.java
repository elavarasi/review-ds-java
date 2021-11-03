//package com.review.DesignPatterns.Prototype;
//
//import java.awt.print.Book;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookShop implements Cloneable{
//    private String shopName;
//    List<Book> books = new ArrayList<>();
//
//    public String getShopName() {
//        return shopName;
//    }
//
//    public void setShopName(String shopName) {
//        this.shopName = shopName;
//    }
//
//    public List<Book> getBook() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
//
//    public void loadData() {
//        for (int i = 0; i <= 10; i++) {
//            Book b = new Book();
//            b.setBid(i);
//            b.setBname("Book");
//            getBook().add(b);
//        }
//
//    }
//
//    @Override
//    protected BookShop clone() {
//        BookShop bs = new BookShop();
//        for (Book b : getBooks()) {
//            shop.getBooks().add(b);
//        }
//
//        return bs;
//    }
//}
