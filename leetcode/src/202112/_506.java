import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/relative-ranks/
 *
 * score[i] 是第 i 位运动员在比赛中的得分
 */
public class _506 {
    public String[] findRelativeRanks(int[] score) {

        int[] tmp = Arrays.copyOf(score, score.length);
        Arrays.sort(tmp);  //正序

        HashMap<Integer,Integer> scoreRank= new HashMap<>();

        for (int i = 0; i < tmp.length; i++) {
            scoreRank.put(tmp[i],tmp.length- i);
        }

        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int num = score[i];
            Integer rank  = scoreRank.get(num);
            switch(rank){
                case 1 : {
                    res [i] = "Gold Medal";
                    break;
                }
                case 2 : {
                    res [i] = "Silver Medal";
                    break;
                }
                case 3 : {
                    res [i] = "Bronze Medal";
                    break;
                }
                default:
                    res [i] = rank + "";
                    break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _506 v = new _506();
        int[] score = {10,3,8,9,4};
        String[] relativeRanks = v.findRelativeRanks(score);
        System.out.println(Arrays.toString(relativeRanks));
    }
}
