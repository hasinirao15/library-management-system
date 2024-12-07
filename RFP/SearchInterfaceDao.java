package com.cvr;

import java.util.List;

public interface SearchInterfaceDao {
    BookDetails getBookById(String bookId);
	 List<BookDetails> getAllBooks(); 
}
