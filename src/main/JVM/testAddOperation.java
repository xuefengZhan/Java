public class testAddOperation {
    public void testAddOperation() {
        //byte、short、char、boolean：都以int型来保存
        byte i = 15;
        long j = 8l;
        long k = i + j;
    }
    public int getSum(){
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    public void testGetSum(){
        //获取上一个栈桢返回的结果，并保存在操作数栈中
        int i = getSum();
        int j = 10;
    }

    public static void main(String[] args) {
        testAddOperation tao = new testAddOperation();
        tao.testAddOperation();
    }

    public void add(){
        //第1类问题：
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;

        //第2类问题：
        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;

        //第3类问题：
        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;

        //第4类问题：
        int i9 = 10;
        int i10 = i9++ + ++i9;
    }
}
