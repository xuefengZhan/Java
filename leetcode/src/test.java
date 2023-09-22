public class test {
    public int countEven(int num) {
        int res = 0;
        for(int i = 1;i<= num;i++){
            if(isEven(sum(i))) res++;
        }
        return res;
    }


    private int sum(int num){
        int res = 0;
        while(num != 0){
            int next = num % 10;   // 112 % 10 = 2
            num  = num / 10;        //11

            res += next;
        }

        return res;
    }


    private boolean isEven(int num){
        return (num ^ 1) != num;  //10 ^ 1 == 11
    }

    public static void main(String[] args) {
        System.out.println(11 / 10);
        System.out.println(11 % 10);
        System.out.println(5 / 10);
        System.out.println(2 ^ 1);
    }
}
