package assignment_prog6112_st10365488;

public class Student {
   
    private String studentName;
    private int studentAge;
    
    public Student(String name, int age) {
        this.studentName = name;
        this.studentAge = age;
    }
    
    public String getName() {
        return studentName;
    }
    
    @Override
    public String toString() {
        return "Name: " + studentName + ", Age: " + studentAge;
    }
}
