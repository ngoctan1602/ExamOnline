package app.ntnt.recycleviewfinalproject.model;

public class Topic {
    private  int id;
    private String title;
    private String body;

    public Topic(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    //    private int id;
//    private String name;
//    private int sumTest;
//    private int sumQuestion;
//
//    public Topic() {
//    }
//
//    public Topic(int id, String name, int sumTest, int sumQuestion) {
//        this.id = id;
//        this.name = name;
//        this.sumTest = sumTest;
//        this.sumQuestion = sumQuestion;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getSumTest() {
//        return sumTest;
//    }
//
//    public void setSumTest(int sumTest) {
//        this.sumTest = sumTest;
//    }
//
//    public int getSumQuestion() {
//        return sumQuestion;
//    }
//
//    public void setSumQuestion(int sumQuestion) {
//        this.sumQuestion = sumQuestion;
//    }
}
