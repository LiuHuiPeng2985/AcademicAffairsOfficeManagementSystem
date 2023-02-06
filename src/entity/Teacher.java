package entity;

/**
 * 老师课程
 */
public class Teacher {
    private Integer id;
    private String username;
    private String classes;
    private String course;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Teacher() {
    }

    public Teacher(Integer id, String username, String classes, String course, String time) {
        this.id = id;
        this.username = username;
        this.classes = classes;
        this.course = course;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", classes='" + classes + '\'' +
                ", course='" + course + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
