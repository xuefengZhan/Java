public class Customer{
    int id = 1001;
    String name;
    Account acct;

    {
        name = "匿名客户";
    }
    public Customer(){
        acct = new Account();
    }

}
class Account{

}

/**
 * @author shkstart  shkstart@126.com
 * @create 2020  17:16
 */
class ObjectTest {
    public static void main(String[] args) {
        Object obj = new Object();
    }
}
