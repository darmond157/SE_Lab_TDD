package test.classes;

import org.junit.jupiter.api.Test;
import main.classes.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void checkStudentExistence() {
        Library library = new Library();
        Book book = new Book("Book-2", "Author-1", 11);
        Student student = new Student("Not-registered-student", 13);
        library.addBook(book);
        boolean expected = false;
        boolean actual = library.lendBook(book, student);
        assertEquals(expected, actual);
    }

    @Test
    void checkBookRemove(){
        Library library = new Library();
        Book book = new Book("Book-1", "Author-1", 1);
        Student student = new Student("student-1", 13);

        library.addBook(book);
        library.addStudent(student);
        library.lendBook(book,student);
        library.returnBook(book,student);

        boolean actual = student.hasBook(book);
        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    void SearchStudentById() {
        Library library = new Library();
        Book book1 = new Book("Book-1", "Author-1", 11);
        Book book2 = new Book("Book-2", "Author-2", 22);
        Book book3 = new Book("Book-3", "Author-3", 33);

        Student student0 = new Student("student0", 13);
        Student student1 = new Student("student1", 12);
        Student student2 = new Student("student2", 11);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addStudent(student0);
        library.addStudent(student1);
        library.addStudent(student2);

        ArrayList<Object> keys = new ArrayList<>();
        SearchByType searchByType = SearchByType.ID;
        keys.add(1);
        keys.add(2);
        keys.add(11);

        ArrayList<Student> expected = new ArrayList<>();
        expected.add(student2);

        ArrayList<Student> actual = library.searchStudents(searchByType, keys);
//        assertArrayEquals(expected.toArray(), actual.toArray());
        assertEquals(new HashSet<Student>(actual), new HashSet<>(expected));

    }

    @Test
    void SearchStudentByName() {
        Library library = new Library();
        Book book1 = new Book("Book-1", "Author-1", 11);
        Book book2 = new Book("Book-2", "Author-2", 22);
        Book book3 = new Book("Book-3", "Author-3", 33);

        Student student0 = new Student("student0", 13);
        Student student1 = new Student("student1", 12);
        Student student2 = new Student("student2", 11);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addStudent(student0);
        library.addStudent(student1);
        library.addStudent(student2);

        ArrayList<Object> keys = new ArrayList<>();
        SearchByType searchByType = SearchByType.NAME;
        keys.add("student0");
        keys.add("student10");
        keys.add("student1");

        ArrayList<Student> expected = new ArrayList<>();
        expected.add(student0);
        expected.add(student1);

        ArrayList<Student> actual = library.searchStudents(searchByType, keys);
        assertEquals(new HashSet<Student>(actual), new HashSet<>(expected));

    }

    @Test
    void SearchStudentByTitleAndAuthor() {
        Library library = new Library();
        Book book1 = new Book("Book-1", "Author-1", 11);
        Book book2 = new Book("Book-2", "Author-2", 22);
        Book book3 = new Book("Book-3", "Author-3", 33);

        Student student0 = new Student("student0", 13);
        Student student1 = new Student("student1", 12);
        Student student2 = new Student("student2", 11);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addStudent(student0);
        library.addStudent(student1);
        library.addStudent(student2);

        ArrayList<Object> keys = new ArrayList<>();
        SearchByType searchByType = SearchByType.AUTHOR;

        ArrayList<Student> expected = null;

        ArrayList<Student> actual = library.searchStudents(searchByType, keys);
        assertEquals(actual, expected);

        searchByType = SearchByType.TITLE;
        actual = library.searchStudents(searchByType, keys);
        assertEquals(expected,actual);
    }

}