package _12_泛型;


//todo 1.泛型类的声明
public class _02_Student<T> {
    private String name;
    private T score;

    public _02_Student(){}
    public _02_Student(String name,T score){
        this.name = name;
        this.score = score;
    }

    //todo 1.在创建泛型类对象的时候 明确泛型
    public static void main(String[] args) {
        _02_Student<String> s = new _02_Student<>("zxf","优秀");
        _02_Student<Integer> s1 = new _02_Student<>("zxf",11);

    }
}

//todo 2.继承泛型类的时候，在泛型类中指明类型实参
class ChinessStudent extends _02_Student<String>{
}

//todo 3.实现泛型接口时，指定泛型实参
class Employee implements Comparable<Employee>{
    private int id;
    private String name;

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
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

}