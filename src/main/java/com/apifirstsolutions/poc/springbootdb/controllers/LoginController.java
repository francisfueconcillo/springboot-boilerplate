package com.apifirstsolutions.poc.springbootdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apifirstsolutions.poc.springbootdb.services.Authentication;

@RestController
public class LoginController {

  @Autowired
  private Authentication authService;

  @GetMapping("/login")
  public ResponseEntity<String> getAllBooks() {
      return new ResponseEntity<>("success", HttpStatus.OK);
  }

  
  
  // @GetMapping("/api/books/lang/{lang}")
  // public ResponseEntity<List<Book>> getBooksByLanguage(@PathVariable String lang) {
  //     List<Book> booksList = booksService.getBooksByLanguage(lang);
  //     return new ResponseEntity<>(booksList, HttpStatus.OK);
  // }
  
}
