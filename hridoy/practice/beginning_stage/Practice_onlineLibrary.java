class Library1 {
    String[] books;
    int num_ofBooks;

    Library1() {
        this.books = new String[100];
        this.num_ofBooks = 0;
    }

    void addBook(String book) {
            this.books[num_ofBooks] = book;
            num_ofBooks++;
        System.out.println("Stored books are " + book);
    }
    void availableBook(){
        System.out.println("Available books are ");
        for(String book : this.books){
            if (book == null){
                continue;
            }
            System.out.println(" * " + book);
        }

    }

    void issuedBook(String book) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == book) {
                System.out.println("Thank you , Your book " + book + " is available ");
                this.books[i] = null;
                return;
            }
        }
        System.out.println("We are apologize,right now your this " + book + " book is not available ");
    }
    void returnBook(String book){
        this.books[num_ofBooks] = book;
    }

}

public class Practice_onlineLibrary {
    public static void main(String[] args) {
        Library1 obj= new Library1();
        obj.addBook("life of pie");
        obj.addBook("jungle book");
        obj.addBook("power of positive thinking");

        obj.issuedBook("hi");
        obj.issuedBook("jungle book");

        obj.availableBook();
        obj.returnBook("jungle book");
        obj.availableBook();




    }
}
