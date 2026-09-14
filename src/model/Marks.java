package model;

public class Marks {

    private int studentId;
    private String subjectCode;
    private double marksObtained;
    private double maxMarks;

    public Marks(int studentId, String subjectCode, double marksObtained, double maxMarks) {
        this.studentId = studentId;
        this.subjectCode = subjectCode;
        this.marksObtained = marksObtained;
        this.maxMarks = maxMarks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public double getMaxMarks() {
        return maxMarks;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public double getPercentage() {
        if (maxMarks == 0) {
            return 0;
        }

        return (marksObtained / maxMarks) * 100;
    }

    public String getGrade() {
        double percentage = getPercentage();

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

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", Subject: " + subjectCode
                + ", Marks: " + marksObtained + "/" + maxMarks
                + ", Percentage: " + String.format("%.2f", getPercentage())
                + "%, Grade: " + getGrade();
    }
}