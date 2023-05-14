import java.util.ArrayList;

class Library {
  private ArrayList<Book> books = new ArrayList<Book>();
  private ArrayList<Member> members = new ArrayList<Member>();

  public void addMember(Member member) {
    for (Member m : this.getMembers()) {
      if (m.id.equals(member.id)) {
        System.out.println("Id member ini sudah ada: " + member.id);
        return;
      }
    }
    this.getMembers().add(member);
  }
    public ArrayList<Member> getMembers() {
    return members;
}


public void addMember(String id, String name) {
  Member member = new Member(id, name);
  this.addMember(member);
}

public void setMembers(ArrayList<Member> members) {
    this.members = members;
}
    public ArrayList<Book> getBooks() {
    return books;
}
public void setBooks(ArrayList<Book> books) {
    this.books = books;
}

public void addBook(Book book){
  for (Book m : this.getBooks()) {
    if (m.id.equals(book.id)) {
      System.out.println("Id member ini sudah ada: " + book.id);
      return;
    }
  }
    this.getBooks().add(book);
}

  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    try {
        for (Member member : this.getMembers()) {
            if (member.id.equals(id)) {
                isExist = true;
                break;
            }
        }
    } catch (NullPointerException e) {
        System.out.println("Kesalahan: " + e.getMessage());
    }
    return isExist;
}

  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.getBooks().remove(book);
    Member member = this.getMemberById(memberId);

    int memberIndex = this.getMemberIndex(member);
    
    this.members.get(memberIndex).borrowedBooks.add(book);
  }

  public void receiveBook(String bookId, String memberId) {
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);

    Book book = this.members.get(memberIndex).getBookById(bookId);

    this.getBooks().add(book);
    this.getMembers().get(memberIndex).borrowedBooks.remove(book);
  }


  private int getMemberIndex(Member member) {
    return this.getMembers().indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.getMembers()) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : this.getBooks()) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
}