package _17_反射._05_反射应用;

import org.junit.Test;

public class _02_CreateClass {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("_01_.AtGuiguDemo");
        Object obj = clazz.newInstance();
        System.out.println(obj.getClass());//class _01_.AtGuiguDemo

    }
}
