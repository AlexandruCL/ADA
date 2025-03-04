import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static <BuferedReader> void main(String[] args) {
//        Student[] students = {
//                new Student("Patric", 20),
//                new Student("Alex", 18),
//                new Student("John", 22)
//        };
//
//        Sorter<Student> sorter = new InsertionSorter<>();
//        sorter.sort(students, StudentComparators.BY_NAME);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
//        System.out.println();
//
//        sorter.sort(students, StudentComparators.BY_AGE);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        This was made for testing and for exercising

//        For the integers

        String filePath = "D:\\An_2\\Sem2\\ADA\\Week2\\src\\randomIntegers_1M.txt";
        List<Integer> integers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    integers.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid integer: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Integer[] arr = integers.toArray(new Integer[0]);
        Sorter<Integer> intSorter = new NaturalSort<>();

        intSorter.sort(arr, Comparator.naturalOrder());

//        For the persons

    }
}
