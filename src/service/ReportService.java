package service;

import model.Marks;
import java.util.List;

public class ReportService {

    private MarksService marksService;

    public ReportService(MarksService marksService) {
        this.marksService = marksService;
    }

    // Generate a performance report for a student
    public String generateStudentReport(int studentId, String studentName) {

        List<Marks> studentMarks = marksService.getMarksByStudent(studentId);

        if (studentMarks.isEmpty()) {
            return "No marks available for this student.";
        }

        StringBuilder report = new StringBuilder();

        report.append("===== STUDENT PERFORMANCE REPORT =====\n\n");
        report.append("Student ID   : ").append(studentId).append("\n");
        report.append("Student Name : ").append(studentName).append("\n\n");

        double totalPercentage = 0;

        for (Marks marks : studentMarks) {

            report.append("Subject : ").append(marks.getSubjectCode()).append("\n");
            report.append("Marks   : ")
                    .append(marks.getMarksObtained())
                    .append("/")
                    .append(marks.getMaxMarks())
                    .append("\n");

            report.append("Percentage : ")
                    .append(String.format("%.2f", marks.getPercentage()))
                    .append("%\n");

            report.append("Grade      : ")
                    .append(marks.getGrade())
                    .append("\n\n");

            totalPercentage += marks.getPercentage();
        }

        double average = totalPercentage / studentMarks.size();

        report.append("--------------------------------------\n");
        report.append("Average Percentage : ")
                .append(String.format("%.2f", average))
                .append("%\n");

        report.append("Overall Grade      : ")
                .append(calculateOverallGrade(average))
                .append("\n");

        report.append("Status             : ")
                .append(average >= 40 ? "PASS" : "FAIL")
                .append("\n");

        report.append("======================================");

        return report.toString();
    }

    // Calculate overall grade
    private String calculateOverallGrade(double percentage) {

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}