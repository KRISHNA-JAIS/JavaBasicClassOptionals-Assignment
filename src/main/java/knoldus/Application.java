package knoldus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

     /**
     */
public final class Application {
    private Application() {
    }
     /**
     * @param argument
     */
    public static void main(final String[] argument) {
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

        //   * It's used to Creating student list.
        Optional<List<Student>> studentList = Optional
                .of(Arrays.asList(student1, student2, student3, student4));

    //   * It's used to Creating a student list.
        Optional<List<Student>> studentList2 = Optional
                .of(Arrays.asList(student5, student6,
                        student7, student8, student9, student10, student11, student12));

    //   * It's used to Creating classroom list.
        List<ClassRoom> classRooms = new ArrayList<>();
        classRooms.add(new ClassRoom("abc", studentList));
        classRooms.add(new ClassRoom("xyz", studentList2));

        List<Student> studentsWithoutSubject = classRooms
                .get(0).toGetStudentsWithoutSubject();
        out.println("Student list having no Sunject associated ");
        studentsWithoutSubject.forEach(out::println);

        List<Optional<String>> subjectsList = classRooms.get(1)
                .toGetDistinctSubjectsThroughRoomId("xyz");
        out.println("Unique subject List of ClassRoom xyz");
        subjectsList.forEach(out::println);

        String finalString = classRooms.get(1).hasStudents();
        out.println(finalString);
    }
}
