package Tree;



import java.util.Comparator;

public class _00_Test {
    public static void main(String[] args) {
        Student s1 = new Student(7,"詹学丰");
        Student s2 = new Student(4,"二普子");
        Student s3 = new Student(9,"徐紫薇");
        Student s4 = new Student(2,"高业超");
        Student s5 = new Student(5,"徐梅坤");
        Student s6 = new Student(8,"何福祥");
        Student s7 = new Student(11,"林欢");
        Student s8 = new Student(3,"宋雪儿");
        Student s9 = new Student(12,"关静");
        Student s10 = new Student(1,"陈莉");

       _02_BinaryTree bst = new _02_BinaryTree(new StudentComparator());
       bst.add(s1);
       bst.add(s2);
        bst.add(s3);
        bst.add(s4);
        bst.add(s5);
        bst.add(s6);
        bst.add(s7);
        bst.add(s8);
        bst.add(s9);
        bst.add(s10);

        bst.PreorderTraversal();


    }
}
class Student {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}