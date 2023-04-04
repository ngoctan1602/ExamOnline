package app.ntnt.recycleviewfinalproject.model;

public class Subject {
    private int id;
    private String name;
    private int sumTest;
    private int sumQuestion;

    public Subject(int id, String name, int sumTest, int sumQuestion) {
        this.id = id;
        this.name = name;
        this.sumTest = sumTest;
        this.sumQuestion = sumQuestion;
    }

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumTest() {
        return sumTest;
    }

    public void setSumTest(int sumTest) {
        this.sumTest = sumTest;
    }

    public int getSumQuestion() {
        return sumQuestion;
    }

    public void setSumQuestion(int sumQuestion) {
        this.sumQuestion = sumQuestion;
    }
}
