package VVSSProjectV03MV.Domain;

public class Assignment implements HasId<Integer> {
    private int id;
    private String description;
    private int deadline;
    private int startline;

    public Assignment(int id, String description, int deadline, int startline) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.startline = startline;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer nr) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getStartline() {
        return startline;
    }

    public void setStartline(int startline) {
        this.startline = startline;
    }

    @Override
    public String toString() {
        return this.id + "#" + this.description + "#" + this.deadline + "#" + this.startline;
    }
}