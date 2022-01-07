package knoldus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
    /**
     * Represents a Student  in the ClassRoom.
     */
    public class StudentTest {
    /**
     * student associated with each new student in ClassRoom.
     */
    Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student("Krishna",4, Optional.of("Java"));
    }

    @Test
    public void testGetName() {
        String expectedName = "Krishna";
        String actualName = student.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testSetName() {
        String expectedName = "Shakti";
        student.setName("Shakti");
        String actualName = student.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetRollNumber() {
        int expectedRollNo = 4;
        int actualRollNo = student.getRollNumber();
        Assert.assertEquals(expectedRollNo, actualRollNo);
    }

    @Test
    public void testSetRollNumber() {
        student.setRollNumber(1);
        int expectedRollNo = 1;
        int actualRollNo = student.getRollNumber();
        Assert.assertEquals(expectedRollNo, actualRollNo);
    }

    @Test
    public void testGetSubject() {
        Optional<String> expectedSubject = Optional.of("Java");
        Optional<String> actualSubject = student.getSubject();
        Assert.assertEquals(expectedSubject, actualSubject);
    }

    @Test
    public void testSetSubject() {
        student.setSubject(Optional.of("Python"));
        Optional<String> expectedSubject = Optional.of("Python");
        Optional<String> actualSubject = student.getSubject();
        Assert.assertEquals(expectedSubject, actualSubject);
    }

    @Test
        public void testToString() {
        String actualResult = student.toString();
        String expectedResult = "Student{name='Krishna', rollNumber=4, subject=Optional[Java]}";
        Assert.assertEquals(expectedResult, actualResult);
    }

}