package Bean;

public class student{
    private int id;
    private String name;
    private String gender;
    private int dept_id;

    public student(int id, String name,String gender, int dept_id) {
        this.id = id;
        this.name = name;

        this.gender = gender;
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "_01_.Bean.student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dept_id=" + dept_id +
                '}';
    }
}