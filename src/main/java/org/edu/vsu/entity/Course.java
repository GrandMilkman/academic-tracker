package org.edu.vsu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "academic_id")
    private Academic academic;

    @Column(name = "name")
    private String name;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "term_num")
    private Integer termNumber;

    @Column(name = "semester_num")
    private Integer semesterNumber;

    @Column(name = "student_amount")
    private Long studentsAmount;

    @Column(name = "lecture_hours_amount")
    private Long lectureHoursAmount;

    @Column(name = "practice_hours_amount")
    private Long practiceHoursAmount;

    @Column(name = "lab_hours_amount")
    private Long labHoursAmount;

    @Column(name = "has_credit")
    private Boolean hasCredit;

    @Column(name = "has_exam")
    private Boolean hasExam;

    @Column(name = "tests_amount")
    private Long testAmount;

    @Column(name = "course_hours_amount")
    private Long courseGeneralHoursAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Academic getAcademic() {
        return academic;
    }

    public void setAcademic(Academic academic) {
        this.academic = academic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getTermNumber() {
        return termNumber;
    }

    public void setTermNumber(Integer termNumber) {
        this.termNumber = termNumber;
    }

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public Long getStudentsAmount() {
        return studentsAmount;
    }

    public void setStudentsAmount(Long studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public Long getLectureHoursAmount() {
        return lectureHoursAmount;
    }

    public void setLectureHoursAmount(Long lectureHoursAmount) {
        this.lectureHoursAmount = lectureHoursAmount;
    }

    public Long getPracticeHoursAmount() {
        return practiceHoursAmount;
    }

    public void setPracticeHoursAmount(Long practiceHoursAmount) {
        this.practiceHoursAmount = practiceHoursAmount;
    }

    public Long getLabHoursAmount() {
        return labHoursAmount;
    }

    public void setLabHoursAmount(Long labHoursAmount) {
        this.labHoursAmount = labHoursAmount;
    }

    public Boolean getHasCredit() {
        return hasCredit;
    }

    public void setHasCredit(Boolean hasCredit) {
        this.hasCredit = hasCredit;
    }

    public Boolean getHasExam() {
        return hasExam;
    }

    public void setHasExam(Boolean hasExam) {
        this.hasExam = hasExam;
    }

    public Long getTestAmount() {
        return testAmount;
    }

    public void setTestAmount(Long testAmount) {
        this.testAmount = testAmount;
    }

    public Long getCourseGeneralHoursAmount() {
        return courseGeneralHoursAmount;
    }

    public void setCourseGeneralHoursAmount(Long courseGeneralHoursAmount) {
        this.courseGeneralHoursAmount = courseGeneralHoursAmount;
    }

    @Override
    public String toString() {
        return "Course{" +
                "academic=" + academic +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", termNumber=" + termNumber +
                ", semesterNumber=" + semesterNumber +
                ", studentsAmount=" + studentsAmount +
                ", lectureHoursAmount=" + lectureHoursAmount +
                ", practiceHoursAmount=" + practiceHoursAmount +
                ", labHoursAmount=" + labHoursAmount +
                ", hasCredit=" + hasCredit +
                ", hasExam=" + hasExam +
                ", testAmount=" + testAmount +
                ", courseGeneralHoursAmount=" + courseGeneralHoursAmount +
                '}';
    }
}
