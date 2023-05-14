import java.util.ArrayList;

abstract class Orang {
  public String name;

  public Orang(String name) {
    this.name = name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getname() {
    return name;
  }
}

abstract class LibraryMember extends Orang {
  public String id;
  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

  public LibraryMember(String id, String name) {
    super(name);
    this.id = id;
  }

  public LibraryMember() {
    super("");
  }

  public abstract void receiveBook(Book book);

  public abstract void giveBook(Book book);

  public abstract Book getBookById(String id);
}

class Member extends LibraryMember {
  public String name;

public Member(String id, String name) {
    super(id, name);
  }

  public Member() {
    super("", "");
  }

  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public Book getBookById(String id) {
    for (Book book : this.borrowedBooks) {
      if (book.id.equals(id)) {
        return book;
      }
  }
    return null;
  }
    
  
}
