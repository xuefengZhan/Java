package 创建型模式.单例模式;

/**
 *    todo 01
 *
 *    懒汉模式
 */
public class LazySingleton {
    //todo step2.提供自身类型的一个属性标识位，当为空的时候 new新的，不为空 直接返回 实现单例
    private LazySingleton instance = null;

    //todo step1.构造器私有化
    private LazySingleton(){}


}
