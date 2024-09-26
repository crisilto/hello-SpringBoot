package com.crisilto.crud.repositories;

import com.crisilto.crud.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

//Indicates that this class is a Spring component that interacts directly with the database.
//This annotation turns the class into a Bean that can be injected into other parts of the code.
@Repository
public class BookRepository {
    //NamedParameterJdbcTemplate is a tool that allows to execute SQL queries and handle interaction with the database.
    //Unlike JdbcTemplate, it allows to use named parameters queries, which makes them cleaner and easier to maintain.
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    //
    private final SimpleJdbcInsert insert;
    //BlockMapper is an internal class that is responsible for mapping each row of the SQL query result to a Book object.
    private final BookMapper mapper = new BookMapper();

    private final String table = "books";

    //Constructor that allows to inject the NamedParameterJdbcTemplate dependency.
    //SpringBoot will automatically inject the NamedParameterJdbcTemplate configured in DatabaseConfig.
    public BookRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                          DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName(table)
                .usingGeneratedKeyColumns("id");
    }

    //Queries

    //Method to get all books from the database.
    //Uses the SQL query to select all records from the books table.
    //The result is then mapped to a list of Book objects using BookMapper.
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM books";
        return namedParameterJdbcTemplate.query(sql, mapper);
    }

    public long createBook(Book newBook) {
        //Generates a new unique id for the new book.
        //The generated id is then used to insert a new record into the "books" table using the insert query.
        //The generated key (id) is returned by the insert query.
        return insert.executeAndReturnKey(new MapSqlParameterSource("name", newBook.name)).longValue();
    }

    public Book getBookById(long id) {
        //Uses the SQL query to select a record from the books table based on its id.
        //The result is then mapped to a Book object using BookMapper.
        String sql = "SELECT * FROM books WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), mapper);
    }

    public Book updateBook(long id, Book updatedBook) {
        //Uses the SQL query to update a record in the books table based on its id.
        //The updated book's name is then used to update the record.
        String sql = "UPDATE books SET name = :name WHERE id = :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id).addValue("name", updatedBook.name));
        //Returns the updated book after updating its name in the database.
        return getBookById(id);
    }

    //Inner class that implements RowMapper, a SpringBoot interface used to map rows from a ResultSet (query result) to an object.
    //In this case, it maps each row of the "books" table to an object of type Book.
    private static class BookMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            //Extracts the values from the "id" and "title" columns of the ResultSet and assigns them to the attributes of the Book object.
            long id = rs.getLong("id");
            String name = rs.getString("name");
            //Returns a new Book object with the extracted values from the ResultSet.
            return new Book(id, name);
        }
    }
}
