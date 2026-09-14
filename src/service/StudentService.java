package service;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students;

    private final String FILE_PATH = "data/students.csv";

    public StudentService() {

        students = new ArrayList<>();

        loadStudents();
    }

    // -----------------------------------------
    // ADD STUDENT
    // -----------------------------------------

    public boolean addStudent(Student student) {

        if (findStudentById(student.getId()) != null) {
            return false;
        }

        students.add(student);

        saveStudents();

        return true;
    }

    // -----------------------------------------
    // FIND STUDENT BY ID
    // -----------------------------------------

    public Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // -----------------------------------------
    // DELETE STUDENT
    // -----------------------------------------

    public boolean deleteStudent(int id) {

        Student student = findStudentById(id);

        if (student != null) {

            students.remove(student);

            saveStudents();

            return true;
        }

        return false;
    }

    // -----------------------------------------
    // UPDATE STUDENT
    // -----------------------------------------

    public boolean updateStudent(
            int id,
            String name,
            String email,
            String course) {

        Student student = findStudentById(id);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        saveStudents();

        return true;
    }

    // -----------------------------------------
    // GET ALL STUDENTS
    // -----------------------------------------

    public List<Student> getAllStudents() {

        return students;
    }

    // -----------------------------------------
    // GET STUDENT COUNT
    // -----------------------------------------

    public int getStudentCount() {

        return students.size();
    }

    // =========================================
    // LOAD STUDENTS FROM CSV
    // =========================================

    private void loadStudents() {

        File file = new File(FILE_PATH);

        if (!file.exists()) {

            System.out.println(
                    "Student CSV file not found. Starting with empty list."
            );

            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            // Skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length >= 4) {

                    int id =
                            Integer.parseInt(
                                    data[0].trim()
                            );

                    String name =
                            data[1].trim();

                    String email =
                            data[2].trim();

                    String course =
                            data[3].trim();

                    Student student =
                            new Student(
                                    id,
                                    name,
                                    email,
                                    course
                            );

                    students.add(student);
                }
            }

            System.out.println(
                    students.size()
                            + " students loaded from CSV."
            );

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading students: "
                            + e.getMessage()
            );
        }
    }

    // =========================================
    // SAVE STUDENTS TO CSV
    // =========================================

    private void saveStudents() {

        File file = new File(FILE_PATH);

        // Make sure data folder exists
        File parent = file.getParentFile();

        if (parent != null) {
            parent.mkdirs();
        }

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(file))) {

            // CSV header
            writer.println(
                    "id,name,email,course"
            );

            for (Student student : students) {

                writer.println(
                        student.getId()
                                + ","
                                + student.getName()
                                + ","
                                + student.getEmail()
                                + ","
                                + student.getCourse()
                );
            }

            System.out.println(
                    "Students saved to CSV."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving students: "
                            + e.getMessage()
            );
        }
    }
}