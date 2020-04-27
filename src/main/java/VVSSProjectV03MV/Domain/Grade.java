package VVSSProjectV03MV.Domain;

import java.time.LocalDateTime;

public class Grade implements HasId<Integer> {

    private Integer id;
    private Integer studentId;
    private Integer assignmentId;
    private double value;
    private LocalDateTime ldt;

    public Grade(Integer id, Integer studentId, Integer assignmentId, double value, LocalDateTime ldt) {
        this.id = id;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.value = value;
        this.ldt = ldt;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    @Override
    public String toString() {
        return this.id + "#" + this.studentId + "#" + this.assignmentId + "#" + this.value + "#" + this.ldt;
    }
}