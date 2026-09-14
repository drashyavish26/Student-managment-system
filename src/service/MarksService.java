package service;

import model.Marks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MarksService {

    private List<Marks> marksList;

    private static final String FILE_NAME = "marks.csv";

    public MarksService() {

        marksList = new ArrayList<>();

        loadMarks();
    }

    // =====================================================
    // ADD MARKS
    // =====================================================

    public void addMarks(Marks marks) {

        marksList.add(marks);

        saveMarks();
    }

    // =====================================================
    // GET ALL MARKS
    // =====================================================

    public List<Marks> getAllMarks() {

        return marksList;
    }

    // =====================================================
    // GET MARKS OF A PARTICULAR STUDENT
    // =====================================================

    public List<Marks> getMarksByStudent(int studentId) {

        List<Marks> result =
                new ArrayList<>();

        for (Marks marks : marksList) {

            if (marks.getStudentId() == studentId) {

                result.add(marks);
            }
        }

        return result;
    }

    // =====================================================
    // CALCULATE AVERAGE PERCENTAGE
    // =====================================================

    public double getAveragePercentage(int studentId) {

        List<Marks> studentMarks =
                getMarksByStudent(studentId);

        if (studentMarks.isEmpty()) {

            return 0;
        }

        double total = 0;

        for (Marks marks : studentMarks) {

            total += marks.getPercentage();
        }

        return total / studentMarks.size();
    }

    // =====================================================
    // GET TOTAL NUMBER OF MARK RECORDS
    // =====================================================

    public int getMarksCount() {

        return marksList.size();
    }

    // =====================================================
    // SAVE MARKS TO CSV
    // =====================================================

    private void saveMarks() {

        try (
                PrintWriter writer =
                        new PrintWriter(
                                new FileWriter(FILE_NAME)
                        )
        ) {

            // CSV header
            writer.println(
                    "studentId,subjectCode,marksObtained,maxMarks"
            );

            for (Marks marks : marksList) {

                writer.println(
                        marks.getStudentId()
                                + ","
                                + marks.getSubjectCode()
                                + ","
                                + marks.getMarksObtained()
                                + ","
                                + marks.getMaxMarks()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving marks: "
                            + e.getMessage()
            );
        }
    }

    // =====================================================
    // LOAD MARKS FROM CSV
    // =====================================================

    private void loadMarks() {

        File file =
                new File(FILE_NAME);

        // If marks.csv doesn't exist,
        // create it with the header.

        if (!file.exists()) {

            saveMarks();

            return;
        }

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file)
                        )
        ) {

            String line;

            // Skip CSV header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data =
                        line.split(",");

                if (data.length != 4) {
                    continue;
                }

                try {

                    int studentId =
                            Integer.parseInt(
                                    data[0].trim()
                            );

                    String subjectCode =
                            data[1].trim();

                    double marksObtained =
                            Double.parseDouble(
                                    data[2].trim()
                            );

                    double maxMarks =
                            Double.parseDouble(
                                    data[3].trim()
                            );

                    Marks marks =
                            new Marks(
                                    studentId,
                                    subjectCode,
                                    marksObtained,
                                    maxMarks
                            );

                    marksList.add(marks);

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Skipping invalid marks record: "
                                    + line
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading marks: "
                            + e.getMessage()
            );
        }
    }
}