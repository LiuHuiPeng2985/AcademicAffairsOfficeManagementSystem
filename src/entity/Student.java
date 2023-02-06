package entity;

/**
 * 学生成绩
 */
public class Student {
    private Integer id;
    private String username;
    private String course;
    private Integer score;

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student() {
    }

    public Student(Integer id, String username, String course, Integer score) {
        this.id = id;
        this.username = username;
        this.course = course;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
