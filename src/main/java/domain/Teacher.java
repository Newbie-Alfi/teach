package domain;

import java.util.Date;

public class Teacher {
    private Long id;
    private String fullName;
    private String academicTitle;
    private String academicDegree;
    private String post;
    private Date createdAt;
    public Teacher() {
    }

    public Teacher(String fullName, String academicTitle, String academicDegree, String post) {
        this.fullName = fullName;
        this.academicTitle = academicTitle;
        this.academicDegree =academicDegree;
        this.post = post;
    }

    public Teacher(Long id, String fullName, String academicTitle,  String academicDegree, String post) {
        this.id = id;
        this.fullName = fullName;
        this.academicTitle = academicTitle;
        this.academicDegree =academicDegree;
        this.post = post;
    }

    public Teacher(Long id, String fullName, String academicTitle, Date createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.academicTitle = academicTitle;

        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String email) {
        this.academicTitle = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id
                + ", fullName="
                + fullName + ", email="
                + academicTitle + ", createdAt="
                + createdAt + "]";
    }
}
