package StringTable;

public class StringIntern {
    public static void main(String[] args) {
        String s = new String("1");
        String s1 = s.intern();//这方法其实没啥屌用，调用此方法之前，字符串常量池中已经存在"1"
        String s2 = "1";

        /*
            jdk6：false   jdk7/8：false
            因为 s 指向堆空间中的 "1" ，s2 指向字符创常量池中的 "1"
         */
        System.out.println(s == s2);
        System.out.println(s1==s2); //true


        // 执行完下一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
        String s3 = new String("1") + new String("1");//s3变量记录的地址为：new String("11")
        /*
            如何理解：jdk6:创建了一个新的对象"11",也就有新的地址。
                     jdk7:此时常量中并没有创建"11",而是在常量池中记录了指向堆空间中new String("11")的地址（节省空间）
         */


        s3.intern(); // 在字符串常量池中生成"11"。
        String s4 = "11";//s4变量记录的地址：使用的是上一行代码代码执行时，在常量池中生成的"11"的地址

        // jdk6：false  jdk7/8：true
        System.out.println(s3 == s4);
    }
}
