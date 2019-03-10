package sort.std;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Comparator {
    public static class Student {
        private String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements java.util.Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements java.util.Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingComparator implements java.util.Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static class AgeDescendingComparator implements java.util.Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[]{student1, student2, student3};
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        PriorityQueue<Student> heap = new PriorityQueue<Student>(new IdAscendingComparator());
        heap.add(student3);
        heap.add(student2);
        heap.add(student1);

        while (!heap.isEmpty()) {
            Student student = heap.poll();
            System.out.println(student.age + " " + student.id + " " + student.name);
        }
        System.out.println("=================");

        TreeSet<Student> treeSet = new TreeSet<>(new IdAscendingComparator());
        treeSet.add(student3);
        treeSet.add(student2);
        treeSet.add(student1);

        while (!treeSet.isEmpty()) {
            Student student = treeSet.pollFirst();
            System.out.println(student.age + " " + student.id + " " + student.name);
        }

    }

    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.age + " " + student.id + " " + student.name);
        }
        System.out.println("++++++++++++++");
    }
}
