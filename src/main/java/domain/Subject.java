package domain;

import java.util.Date;

public class Subject {
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

    public Subject() {    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Subject(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Subject(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Subject(Long id, String name, String type, Date createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

}
