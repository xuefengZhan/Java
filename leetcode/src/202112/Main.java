import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> permute(int[] nums){
        List<Integer> options = new ArrayList<>();

        if(nums == null || nums.length == 0) return res;
        for (int num : nums) {
            options.add(num);
        }

        place(new LinkedList<Integer>(),options);

        return res;

    }

    private void place(LinkedList<Integer> path, List<Integer> options){
        if(path.size() == options.size()){
            res.add(new LinkedList(path));  //这里必须是new一个list，因为path是地址，内容在变化
            return;
        }

        for (int i = 0; i < options.size(); i++) {

            if(path.contains(options.get(i))){
                continue;
            }
            path.add(options.get(i));

            place(path,options); // 1 3 4 ; 1 3 4;
            path.removeLast(); // 1 3 ; 1 3 4;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.permute(new int[]{1,3,4});

        for (List<Integer> re : main.res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
