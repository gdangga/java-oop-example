import java.util.ArrayList;

class Library {
  private ArrayList<Book> books = new ArrayList<>();
  private ArrayList<Member> members = new ArrayList<>();

  public void addMember(Member member) {
    for (Member m : this.getMembers()) {
      if (m.id.equals(member.id)) {
        System.out.println("Id member ini sudah ada: " + member.id);
        return;
      } 
    }
    this.getMembers().add(member);
    System.out.println("Member dengan Id " +member.id+ " berhasil ditambahkan");
  }
    public ArrayList<Member> getMembers() {
    return members;
  }
  
  public void setMembers(ArrayList<Member> members) {
    this.members = members;
  }

  public void addBook(Book book) {
    for (Book b : this.books) {
      if (b.getId().equals(book.getId())) {
        System.out.println("Id buku ini sudah ada: " + book.getId());
      } else{
        this.books.add(book);
        System.out.println("Buku dengan ID" + book.getId() + " berjudul " + book.getTitle() + " berhasil ditambahkan");
        return;
      }
    }
    
  }

  public void setBooks(ArrayList<Book> books) {
    this.books = books;
  }

  public ArrayList<Book> getBooks() {
    return books;
  }

  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Member member : this.members) {
      if (member.id == id) {
        isExist = true;
      }
    }
    return isExist;
  }


  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.getBooks().remove(book);
    Member member = this.getMemberById(memberId);

    int memberIndex = this.getMemberIndex(member);
    
    this.members.get(memberIndex).borrowedBooks.add(book);

    try {
      System.out.println("Buku dengan ID " + bookId + " berhasil dipinjam oleh member dengan ID " + memberId);
    } catch (Exception e) {
      System.out.println("Terjadi kesalahan saat mencoba meminjam buku: ");
    }
  }

  public void receiveBook(String bookId, String memberId) {
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);

    Book book = this.members.get(memberIndex).getBookById(bookId);

    try {
      if (book == null) {
        throw new Exception("Buku dengan ID " + bookId + " belum pernah dipinjam.");
      }
  
      this.getBooks().add(book);
      this.getMembers().get(memberIndex).borrowedBooks.remove(book);
      System.out.println("Buku dengan ID " + bookId + " berhasil dikembalikan oleh member dengan ID " + memberId);
    } catch (Exception e) {
      System.out.println("Terjadi kesalahan saat mencoba mengembalikan buku: " + e.getMessage());
    }
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
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }
}