package model;

public class Subject {

    private String subjectCode;
    private String subjectName;
    private int maxMarks;

    public Subject(String subjectCode, String subjectName, int maxMarks) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    @Override
    public String toString() {
        return subjectCode + " - " + subjectName;
    }
}
