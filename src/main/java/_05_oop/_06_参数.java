package _05_oop;

public class _06_参数 {
    //todo 命令行参数
    // 给main方法传递的参数
    // 如何使用： 运行java程序： java main方法类名 实参列表...
    // 代码中：通过args[i]来使用各种参数
    // 注意：String[] args 是String类型的参数



    //todo 可变参数
    // 使用要求：
    // 一个方法只能有一个可变参数
    // 可变参数的位置一定是最后一个
    // 使用：
    // 非可变参数的部分，实参的类型，个数，顺序与形参仍然要一一对应
    // 可变参数的部分，实参的类型要与形参一致或兼容，个数可以是0~n个，还可以是对应类型的数组
    // 注意：
    // 编译器会将可变参数便以为数组，二者不是重载
//    public static int getSum(int[] array){
//        int sum=0;
//        for(int i=0;i<array.length;i++){
//            sum+=array[i];
//        }
//        return sum;
//    }
    public static int getSum(int... nums){
        int sum=0;
        //编译器把nums编译成int[]
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }


}
