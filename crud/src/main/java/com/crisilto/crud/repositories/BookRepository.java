package com.crisilto.crud.repositories;

import com.crisilto.crud.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Indicates that this class is a Spring component that interacts directly with the database.
//This annotation turns the class into a Bean that can be injected into other parts of the code.
@Repository
public class BookRepository {
    //NamedParameterJdbcTemplate is a tool that allows to execute SQL queries and handle interaction with the database.
    //Unlike JdbcTemplate, it allows to use named parameters queries, which makes them cleaner and easier to maintain.
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    //BlockMapper is an internal class that is responsible for mapping each row of the SQL query result to a Book object.
    private final BookMapper mapper = new BookMapper();

    //Constructor that allows to inject the NamedParameterJdbcTemplate dependency.
    //SpringBoot will automatically inject the NamedParameterJdbcTemplate configured in DatabaseConfig.
    public BookRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    //Queries

    //Method to get all books from the database.
    //Uses the SQL query to select all records from the books table.
    //The result is then mapped to a list of Book objects using BookMapper.
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM books";
        return namedParameterJdbcTemplate.query(sql, mapper);
    }

    //Inner class that implements RowMapper, a SpringBoot interface used to map rows from a ResultSet (query result) to an object.
    //In this case, it maps each row of the "books" table to an object of type Book.
    private static class BookMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            //Extracts the values from the "id" and "title" columns of the ResultSet and assigns them to the attributes of the Book object.
            long id = rs.getLong("id");
            String title = rs.getString("title");
            //Returns a new Book object with the extracted values from the ResultSet.
            return new Book(id, title);
        }
    }
}
