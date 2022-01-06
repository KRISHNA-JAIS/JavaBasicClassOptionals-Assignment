package knoldus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ClassRoom test cases.
 */
public class ClassRoomTest {
    
    /**
     * Lists for the testing .
     */
    List<Student> studentList1;
    List<Student> studentList2;
    ClassRoom firstClassRoom;
    ClassRoom secondClassRoom;

    /**
     * @throws Exception it will throw an Exception class
     */
    @Before
    public void setUpClassRoom() throws Exception {

        Student student1 =
                new Student("Krishna", 1, Optional.of("C"));
        Student student2 =
                new Student("Vijay", 2, Optional.empty());
        Student student3 =
                new Student("Rohit", 3, Optional.empty());
        Student student4 =
                new Student("Advik", 4, Optional.of("Java"));
        Student student5 =
                new Student("Shubham", 5, Optional.of("Python"));
        Student student6 =
                new Student("Govinda", 6, Optional.of("Python"));
        Student student7 =
                new Student("Gautam", 7, Optional.of("Javascript"));
        Student student8 =
                new Student("Naman", 8, Optional.of("Javascript"));
        Student student9 =
                new Student("Vishnu", 9, Optional.of("Javascript"));
        Student student10 =
                new Student("Vinish", 10, Optional.of("PHP"));
        Student student11 =
                new Student("Rohan", 10, Optional.of("PHP"));
        Student student12 =
                new Student("Shakti", 10, Optional.of("CSS"));


        studentList1 = Arrays.asList(student1, student2, student3, student4);
        studentList2 = Arrays.asList(student5, student6, student7, student8,student9,student10,student11,student12);

        firstClassRoom = new ClassRoom("abc", Optional.of(studentList1));
        secondClassRoom = new ClassRoom("xyz", Optional.of(studentList2));

    }

    /**
     * It associated to Get Students Having No Subject And Return Correct List
     */
    @Test
    public void GetStudentsHavingNoSubjectAssociated() {
        List<Student> expectedStudents =
                Arrays.asList(new Student(
                        "Krishna", 2, Optional.empty()),
                        new Student("Shakti", 3, Optional.empty()));
        List<Student> actualStudents = firstClassRoom.toGetStudentsWithoutSubject();
        Assert.assertTrue(actualStudents.size() > 1);
        Assert.assertEquals(expectedStudents.get(0).getRollNumber(), actualStudents.get(0).getRollNumber());
    }

    /**
     * to Get Different Subjects Through RoomId And Correct If any Subjects Found By RoomId
     */
    @Test
    public void GetDifferentSubjectsThroughRoomId() {
        List<Optional<String>> expectedSubjects =
                Arrays.asList(Optional.of("Python"), Optional.of("Javascript"), Optional.of("PHP"),Optional.of("CSS"));
        List<Optional<String>> actualSubjects = secondClassRoom.toGetDistinctSubjectsThroughRoomId("xyz");
        Assert.assertTrue(actualSubjects.size() > 1);
        Assert.assertEquals(expectedSubjects, actualSubjects);
    }
    /**
     * It's used to Get Different Subjects Through RoomId And To Return Null If no Subjects Found
     */
    @Test
    public void GetDifferentSubjectsThroughRoomId_AndToReturnNullIfSubjectsNotFoundByRoomId() {
        List<Optional<String>> finalSubjects = secondClassRoom.toGetDistinctSubjectsThroughRoomId("JV01");
        Assert.assertNull(finalSubjects);
    }
    /**
     * Its test Students And Return a String Message If you Have any Students
     */
    @Test
    public void testStudents() {
        String expectedResult = "Hello Students";
        String actualResult = firstClassRoom.hasStudents();
        Assert.assertEquals(expectedResult, actualResult);
    }
    /**
     * Its test the Students And Return Empty String If Not Have Any Students
     */
    @Test
    public void testStudents_AndReturnEmptyStringIfNotHaveAnyStudents() {
        String expectedResult = "Hello Students";
        firstClassRoom.setStudentList(Optional.empty());
        String actualResult = firstClassRoom.hasStudents();
        Assert.assertEquals(expectedResult, actualResult);
    }
    /**
     *  this is associated to Get a RoomId_ And Return Correct RoomId
     */
    @Test
    public void GetRoomId(){
        String expectedRoomId = "xyz";
        String actualRoomId = secondClassRoom.getClassRoomId();
        Assert.assertEquals(expectedRoomId, actualRoomId);
    }
    /**
     * this is for Set a RoomId And Return Correct RoomId
     */
    @Test
    public void SetRoomId(){
        firstClassRoom.setClassRoomId("J1004");
        String expectedRoomId = "J1004";
        String actualRoomId = firstClassRoom.getClassRoomId();
        Assert.assertEquals(expectedRoomId, actualRoomId);
    }
    /**
     *  this is used to set a StudentList And Return Correct SetStudents List
     */
    @Test
    public void setStudentList(){
        firstClassRoom.setStudentList(Optional.ofNullable(studentList2));
        Optional<List<Student>> expectedList = Optional.ofNullable(studentList2);
        Optional<List<Student>> actualList = firstClassRoom.getStudentList();
        Assert.assertTrue(actualList.get().size() > 2);
        Assert.assertEquals(expectedList.get().get(0).getRollNumber(), actualList.get().get(0).getRollNumber());
    }
}