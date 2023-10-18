package com.pluarsight;

public class Books {
    public Books(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        isCheckedOut = false;
        checkedOutTo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
    @Override
    public String toString() {
        return "Title: " + title + " | ID:" + id + " | ISBN:" + isbn ;
    }
    public void  checkIn(){
        checkedOutTo = "";
        isCheckedOut = false;
    }

    public void checkOut(String name) {
        checkedOutTo = name;
        isCheckedOut = true;
    }

    private int id;
    private String isbn;
    private String title;
    private Boolean isCheckedOut;
    private String checkedOutTo;

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
}
