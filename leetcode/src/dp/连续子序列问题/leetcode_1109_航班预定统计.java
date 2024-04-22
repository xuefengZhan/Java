package dp.连续子序列问题;

/**
 * @ClassName leetcode_1109_航班预定统计
 * @Author zxf
 * @Date 2024/3/20 11:17
 * @Questinon Describrition
 **/
public class leetcode_1109_航班预定统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int a = bookings[i][0];
            int b = bookings[i][1];
            int c = bookings[i][2];

            res[a-1] += c;
            if(b<n) res[b] -= c;

        }

        for (int i = 1; i < res.length; i++) {
            res[i]+=res[i-1];
        }


        return res;
    }

}
