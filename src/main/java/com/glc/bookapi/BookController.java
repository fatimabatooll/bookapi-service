package com.glc.bookapi;



import java.util.Collection;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.core.Queue;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository repo;

    public BookController() {
        repo = new BookRepository();
    }

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    // @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        String msg = "This is message from Sender";
        this.template.convertAndSend(queue.getName(),msg);
        System.out.println(" [x] Send '"+msg+"'");
    }


    // saveBook
    @PostMapping("")
    public void save(@RequestBody Book book) {
        this.send();
        repo.saveBook(book);
    }

    // viewAllBook
    @GetMapping("")
    public Collection<Book> view() {
        return repo.viewAllBook();

    }

    // deleteBook
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteBook(id);

    }

    // updateBook
    @PutMapping("")
    public void update(@RequestBody Book book) {
        repo.updateBook(book);
    }
}
