package _16_单例模式;

public class hungry {

}

class hungry01{
    private static hungry01 hg;

    private hungry01(){}

    public static hungry01 getInstance(){
        if(hg == null){
            hg = new hungry01();
        }
        return hg;
    }
}

class hungry02{
    private static hungry02 hg;

    private hungry02(){}

    public synchronized static hungry02 getInstance(){
        if(hg == null){
            hg = new hungry02();
        }
        return hg;
    }
}
class hungry03{
    private static hungry03 hg;

    private hungry03(){}

    public static hungry03 getInstance(){

        if(hg == null){
            synchronized (hungry03.class){
                if(hg == null){
                    hg = new hungry03();
                }
            }
        }
        return hg;
    }
}