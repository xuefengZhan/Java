package _18_工厂模式;

public class TestFactory3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Vechile qq = simpleFactory3.getVehicle("_18_工厂模式.QQ");//QQ
        qq.run();
    }
}

interface Vechile{
    void run();
}

class QQ implements Vechile{

    @Override
    public void run() {
        System.out.println("QQ");
    }
}

class Aoto implements  Vechile{
    @Override
    public void run() {
        System.out.println("奥拓");
    }
}

class simpleFactory3{
    public static Vechile getVehicle(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(className);
        return (Vechile) clazz.newInstance();
    }
}