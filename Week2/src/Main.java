public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Patric", 20),
                new Student("Alex", 18),
                new Student("John", 22)
        };

        Sorter<Student> sorter = new InsertionSorter<>();
        sorter.sort(students, StudentComparators.BY_NAME);
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();

        sorter.sort(students, StudentComparators.BY_AGE);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
