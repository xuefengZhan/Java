package 回溯;

public class 剑指Offer13_机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(countSelf(j) + countSelf(i) <=k){
                    res ++;
                }
            }
        }
        return res;
    }

    private int countSelf(int x){
        int res = 0;
        int tmp ;
        while((tmp = x % 10  ) != 0){
            res += tmp;
            x = x/10;
        }
        return res;
    }


    public static void main(String[] args) {
        剑指Offer13_机器人的运动范围 v = new 剑指Offer13_机器人的运动范围();
        int res = v.countSelf(18);
        System.out.println(res);
    }
}
