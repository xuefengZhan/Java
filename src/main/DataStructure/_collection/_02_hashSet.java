package _collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class _02_hashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set=" + hashSet);

        HashSet<String> hashSet1 = new LinkedHashSet<>();

        TreeSet<String> ts = new TreeSet<>();
        ts.add("java");
    }
}
