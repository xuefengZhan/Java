public class tmp {

    public int getTruth(int num){
        int cur = num;
        int count = 0;
        while(cur >= 3){
            String sc = Integer.toString(cur);
            if(sc.contains("4")){
                count ++;
            }
            cur --;
        }
        return num - count;
    }

    public static void main(String[] args) {
        tmp tmp = new tmp();
        int res = tmp.getTruth(500);

        System.out.println(res);
    }
    // 1 2 3 4 5 6 7 8 9  10 11 12 13 14 15
    // 1 2 3 5 6 7 8 9 10 11 12 13 15
}
