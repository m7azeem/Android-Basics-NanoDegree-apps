package com.example.android.reportcard;

/**
 * Created by Muhammad Azeem on 25/06/2016.
 */
public class ReportCard {

    final public String STUDYLEVEL = "Grade 12-Science";

    private int mathGrade;
    private int physicsGrade;
    private int chemistryGrade;
    private int biologyGrade;

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public int getPhysicsGrade() {
        return physicsGrade;
    }

    public void setPhysicsGrade(int physicsGrade) {
        this.physicsGrade = physicsGrade;
    }

    public int getChemistryGrade() {
        return chemistryGrade;
    }

    public void setChemistryGrade(int chemistryGrade) {
        this.chemistryGrade = chemistryGrade;
    }

    public int getBiologyGrade() {
        return biologyGrade;
    }

    public void setBiologyGrade(int biologyGrade) {
        this.biologyGrade = biologyGrade;
    }

    public ReportCard(int mathGrade, int physicsGrade, int chemistryGrade, int biologyGrade) {
        this.mathGrade = mathGrade;
        this.physicsGrade = physicsGrade;
        this.chemistryGrade = chemistryGrade;
        this.biologyGrade = biologyGrade;
    }

    @Override
    public String toString() {
        String result=STUDYLEVEL + "\n" +
                "Math = " + mathGrade + "\n" +
                "Physics = " + physicsGrade + "\n" +
                "Chemistry = " + chemistryGrade + "\n" +
                "Biology = " + biologyGrade + "\n" +
                "--END--";
        return result;
    }
}
