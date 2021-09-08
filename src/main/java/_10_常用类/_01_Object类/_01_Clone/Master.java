package _10_常用类._01_Object类._01_Clone;


public class  Master implements Cloneable {
    private String name;
    private Student student;

    public Master() {
    }

    public Master(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Master{" +
                "name='" + name + '\'' +
                ", student=" + student +
                '}';
    }


        @Override
        public Object clone() throws CloneNotSupportedException {
            // TODO Auto-generated method stub
            //注意以下代码
            Master master = (Master)super.clone();
            master.setStudent( (Student)master.getStudent().clone() );
            return  master;
        }
        public static void main(String[] args) throws CloneNotSupportedException {
            Student s1 = new Student();
            s1.setAge(20);
            s1.setName("张三");

            Master teacher1 = new Master();
            teacher1.setName("小赵老师");
            teacher1.setStudent(s1);

            Master teacher2 = (Master)teacher1.clone();

            teacher2.setName("小明老师");
            Student s2 = teacher2.getStudent();
            s2.setName("李四");
            s2.setAge(30);
            System.out.println("teacher1:"+teacher1); //teacher1:Master{name='小赵老师', student=Student [age=20, name=张三]}
            System.out.println("teacher2:"+teacher2); //teacher2:Master{name='小明老师', student=Student [age=30, name=李四]}

        }

    }

