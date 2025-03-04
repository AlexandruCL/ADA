import java.util.Comparator;

public class StudentComparators {
    public static final Comparator<Student> BY_NAME = Comparator.comparing(Student::getName);
    public static final Comparator<Student> BY_AGE = Comparator.comparing(Student::getAge);
}
