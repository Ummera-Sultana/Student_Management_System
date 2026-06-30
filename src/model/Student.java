package model;

public class Student {
    private  int id;
    private  String name;
    private  String email;
   private  int age;
    private  String course;

    public Student(String name, int age, String course, String email) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }
    public Student(int id,String name, int age, String course, String email) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public  String getEmail() {
        return email;
    }

    public  int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
