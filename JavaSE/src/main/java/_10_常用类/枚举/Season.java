package _10_常用类.枚举;

public class Season {
    //todo 2.定义静态常量属性，类型为自己
    public static final Season SPRING = new Season();
    public static final Season SUMMER = new Season();
    public static final Season AUTUMN = new Season();
    public static final Season WINTER = new Season();

    //todo 1.私有化构造器
    private Season(){}

    public String toString(){
        if(this == SPRING){
            return "SPRING";
        }else if(this == SUMMER){
            return "SUMMER";
        }else if(this == AUTUMN){
            return "AUTUMN";
        }else{
            return "WINTER";
        }
    }

    public static void main(String[] args) {
        Season s = Season.SPRING;
        System.out.println(s);
    }

}
