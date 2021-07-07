package StringTable;

/**
 * @author shkstart  shkstart@126.com
 * @create 2020  23:44
 */
public class StringExer {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public void change(int a , int b){
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a="+a+";b="+b);
    }


    public static void main(String[] args) {
        StringExer ex = new StringExer();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best

        int a = 5;
        int b = 10;
        ex.change(5,10);//a=10;b=5
        System.out.println("a="+a+";b="+b);//a=5;b=10
    }



}
