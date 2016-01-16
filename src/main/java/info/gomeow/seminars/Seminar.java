package info.gomeow.seminars;

import java.util.HashSet;
import java.util.Set;

public class Seminar {

    String name;
    Set<Student> students = new HashSet<Student>();

    Main main;

    public Seminar(String n, Main m) {
        name = n;
        main = m;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public boolean isFull() {
        return students.size() >= main.speakers.get(name);
    }

}
