import java.util.ArrayList;

abstract class LibraryMember {
  public String id;
  public String name;
  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public Book getBookById(String id) {
    for (Book book : this.borrowedBooks) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }

  public abstract Object getId();
}

class Member extends LibraryMember {
  public Member() {
  }

  @Override
  public Object getId() {
    return this.id;
  }
}

class Student extends LibraryMember {
  private String studentId;

  public Student(String id, String name, String studentId) {
    this.id = id;
    this.name = name;
    this.studentId = studentId;
  }

  @Override
  public void receiveBook(Book book) {
    if (borrowedBooks.size() < 5) {
      borrowedBooks.add(book);
    } else {
      System.out.println("Batas peminjaman buku telah mencapai maksimum");
    }
  }

  @Override
  public Object getId() {
    return this.studentId;
  }
}
