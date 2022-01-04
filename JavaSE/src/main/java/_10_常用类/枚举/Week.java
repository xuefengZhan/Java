package _10_常用类.枚举;

public enum Week {

    //它们实际上都是public static final修饰的常量对象。
    SPRING,SUMMER,AUTUMN,WINTER;


    public static void main(String[] args) {
        Week s = Week.SPRING;
        switch(s){
            case SPRING:
                System.out.println("春暖花开");break;
            case SUMMER:
                System.out.println("夏日炎炎");break;
            case AUTUMN:
                System.out.println("秋高气爽");break;
            case WINTER:
                System.out.println("白雪皑皑");break;
        }
    }

}
