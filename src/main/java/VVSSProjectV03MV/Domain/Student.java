package VVSSProjectV03MV.Domain;

public class Student implements HasId<Integer> {
    private Integer id;
    private String name;
    private int group;
    private String email;
    private String teacher;

    public Student(Integer id, String name, int group, String email, String teacher) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.email = email;
        this.teacher = teacher;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return this.id + "#" + this.name + "#" + this.group + "#" + this.email + "#" + this.teacher;
    }
}