package com.example.RestWithSQL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;



    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        if (bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id);
        }
        return null;
    }

    public Book addNewBook(Book book){
        if (book.getAuthor()!= null && book.getISBN() != null && book.getTitle() != null && book.getPublishedDate()!=null){
            if (!bookExist(book)){
                return bookRepository.save(book);
            }
            else {
                throw new BookAlreadyExistException("Book with ID: " +book.getId()+" Already exist");
            }
        }
        else {
            throw new InvalidDataException("Data can't be null or blank");
        }
    }

    public Book updateBook(Book book,long id){
        if (!book.getAuthor().isEmpty() && !book.getISBN().isEmpty() && !book.getTitle().isEmpty() && book.getPublishedDate()!=null){
            if (bookExist(book)){
                Book bookAux  = new Book();
                bookAux.setId(book.getId());
                bookAux.setAuthor(book.getAuthor());
                bookAux.setTitle(book.getTitle());
                bookAux.setISBN(book.getISBN());
                bookAux.setPublishedDate(book.getPublishedDate());
                return bookRepository.save(bookAux);
            }
            else {
                throw new BookDoesntExistException("Book with ID: " +book.getId()+" doesn't exist");
            }
        }
        else {
            throw new InvalidDataException("Data can't be null and blank");
        }
    }

    public String deleteBookById(long id){
        if (bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
            return "Book deleted";
        }else{
            throw new BookDoesntExistException("Book with ID: " +id+" doesn't exist");
        }
    }


    private Boolean bookExist(Book book){
        if (!bookRepository.findById(book.getId()).isPresent()){
            return false;
        }
        return true;

    }


}
