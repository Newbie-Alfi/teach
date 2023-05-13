package domain;

import java.util.Date;

public class Teacher {
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String name;
    private String type;

    public Teacher() {    }

    public Teacher(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Teacher(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Teacher(Long id, String name, String type, Date createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
