package in.lemonco.reportcardapp;

import android.util.Log;

/**
 * Generates a student's report card
 */
public class ReportCard {
    private String studentName;
    /**
     * Student registration number
     */
    private String studentID;
    /**
     * Student class standard
     */
    private String standard;
    private int year;
    private String[][] subjectGrades = new String[10][2];
    private int subjectCounter = 0;

    /**
     * useful for updating student Grades from a file
     *
     * @param studentName
     * @param studentID
     * @param standard
     * @param year
     * @param subjectGrades
     */
    public ReportCard(String studentName, String studentID, String standard, int year, String[][] subjectGrades) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.standard = standard;
        this.year = year;
        this.subjectGrades = subjectGrades;
    }

    /**
     * Creates an empty report card.
     */
    public ReportCard() {
        this.studentID = "";
        this.studentName = "";
        this.standard = "";
        this.year = 0;
        this.subjectGrades = null;
    }

    /**
     * Getter Methods
     */
    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStandard() {
        return standard;
    }

    public String[][] getSubjectGrades() {
        return subjectGrades;
    }

    /**
     * Method to set the basic student info
     *
     * @param name
     * @param id
     * @param standard
     * @param year
     */
    public void setStudentInfo(String name, String id, String standard, int year) {
        this.studentName = name;
        this.studentID = id;
        this.standard = standard;
        this.year = year;
    }

    /**
     * Useful for updating all grades via refrence to a two dimensional array
     *
     * @param subjectGrades Takes a two dimensional String array as input, First element represent the subject and second represents the grade in subject
     */
    public void setSubjectGradeAll(String[][] subjectGrades) {
        this.subjectGrades = subjectGrades;
    }

    /**
     * Updates a single record in the two dimensional subjectGrades array. Useful for updating grades of a single subject in a loop
     * Updates a subjectCounter variable to fill the array and to keep count of subjects
     *
     * @param subject
     * @param grade
     */
    public void setSubjectGrade(String subject, String grade) {
        if (subjectCounter < 10) {
            this.subjectGrades[subjectCounter][0] = subject;
            this.subjectGrades[subjectCounter][1] = grade;
            subjectCounter++;
        } else {
            Log.i("ReportCard", "You have exceeded the maximum number of subjects allowed");
        }
    }

    /**
     * Method to print the report card
     *
     * @return
     */
    @Override
    public String toString() {
        String strSubjectGrades = "";
        for (int i = 0; i < this.subjectGrades.length; i++) {
            strSubjectGrades = subjectGrades[i][0] + "=" + "\'" + subjectGrades[i][1] + "\'" + "\n";
        }
        return "Name: " + this.studentName + "\n" +
                "Student ID: " + this.studentID + "\n" +
                "Standard: " + this.standard + "\n" +
                "Year: " + this.year + "\n" +
                "RESULTS:  Subject Grade" + "\n" +
                strSubjectGrades;

    }


}
