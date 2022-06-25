package com.api.book.bootrestbook1.services;

import java.util.List;

import com.api.book.bootrestbook1.Entities.Book;
import com.api.book.bootrestbook1.dao.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
//     private static List<Book> list = new ArrayList<>();
   
//    static{     
//          list.add(new Book(12,"JavaComplete Reference","XYZ"));
//          list.add(new Book(36,"Head First Java","ABC"));
//          list.add(new Book(46,"Think in Java","PQR"));
//      }
      
    //get all books
    public List<Book> getAllBooks(){

        // return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        try{                    
        // book = list.stream().filter(e->e.getId()==id).findFirst().get();
        book = this.bookRepository.findById(id);

        }catch(Exception e){

          e.printStackTrace(); 
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b){
    //   list.add(b);
    Book result = bookRepository.save(b);
      return result;        
    }

    //deleting the book
    public void delete(int bid){
   //// list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    //   list = list.stream().filter(book->{
    //        if(book.getId() != bid){
    //            return true;
    //        }else{
    //            return false;
    //        }
    //    }).collect(Collectors.toList()); 
    bookRepository.deleteById(bid);
    }

   
    //updating the book
    public void update(Book book, int bookId){
      
    //    list = list.stream().map(b->{
    //        if(b.getId() == bookId){
    //            b.setTitle(book.getTitle());
    //            b.setAuthor(book.getAuthor());
    //        } 
    //       return b;
    //     }).collect(Collectors.toList());
     
    book.setId(bookId);
    
    bookRepository.save(book);
    }
}
