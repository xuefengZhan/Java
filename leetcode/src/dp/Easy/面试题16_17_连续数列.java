package dp.Easy;

/**
 * @ClassName 面试题16_17_连续数列
 * @Author zxf
 * @Date 2023/8/23 11:07
 * @Questinon Describrition
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 **/
public class 面试题16_17_连续数列 {
    public class Status {
        public int lSum, rSum, mSum, iSum;

        // lSum 表示 [l,r][l,r][l,r] 内以 l 为左端点的最大子段和
        // rSum 表示 [l,r][l,r][l,r] 内以 r 为右端点的最大子段和
        // mSum 表示 [l,r][l,r][l,r] 内的最大子段和
        // iSum 表示 [l,r][l,r][l,r] 的区间和

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }


    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }

        int m = (l + r) >> 1;

        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
