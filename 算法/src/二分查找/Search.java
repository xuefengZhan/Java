package 二分查找;

public class Search {


    int search_bad( int array[],  int n,  int v){
        int left, right, middle;

        //todo 1.初始化区间 [0,n)
        left = 0;
        right = n;

        while (left < right){
            middle = (left + right) / 2;

            if (array[middle] > v) {
                //todo 这里右边变成闭合的了 错误
                right = middle - 1;
            }else if (array[middle] < v) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // 左臂右臂
    int search2( int array[],  int n,  int v) {
        int left, right, middle;

        left = 0;
        right = n - 1;

        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] > v) {
                right = middle - 1;
            } else  if (array[middle] < v) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    // 左闭右开
    int search3( int array[],  int n,  int v)
    {
        int left, right, middle;

        left = 0;
        right = n;

        while (left < right)
        {
            middle = (left + right) / 2;

            if (array[middle] > v)
            {
                right = middle;
            }
            else  if (array[middle] < v)
            {
                left = middle + 1;
            }
            else
            {
                return middle;
            }
        }

        return -1;
    }

    //todo 死循环
    int search_bad2( int array[],  int n,  int v)
    {
        int left, right, middle;

        left = 0;
        right = n - 1;

        while (left <= right)
        {
            middle = (left + right) / 2;
            if (array[middle] > v) {
                right = middle;
            } else  if (array[middle] < v) {
                left = middle;
            } else {
                return middle;
            }
        }

        return -1;
    }

    //todo 溢出问题
    //在循环体内,计算中间位置的时候,使用的是这个表达式:
    //middle = (left + right) / 2;
    //假如,left与right之和超过了所在类型的表示范围的话,那么middle就不会得到正确的值.
    //所以,更稳妥的做法应该是这样的:
    //middle = left + (right - left) / 2;

}
