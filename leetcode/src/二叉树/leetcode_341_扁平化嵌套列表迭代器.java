package 二叉树;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName leetcode_341_扁平化嵌套列表迭代器
 * @Author zxf
 * @Date 2023/2/7 9:09
 **/
public class leetcode_341_扁平化嵌套列表迭代器 {
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

       // @return true if this NestedInteger holds a single integer, rather than a nested list.
       public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
       // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

       // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
 }

/**
 *  递归 写法
 */

//class NestedIterator implements Iterator<Integer> {
//
//    private final Iterator<Integer> iterator;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        dfs(nestedList,list);
//        iterator = list.iterator();
//    }
//
//    private void dfs(List<NestedInteger> nestedList,ArrayList<Integer> list){
//
//        for (NestedInteger nestedInteger : nestedList) {
//            if(nestedInteger.isInteger()){
//                list.add(nestedInteger.getInteger());
//            }else{
//                List<NestedInteger> nestedIntegerList = nestedInteger.getList();
//                dfs(nestedIntegerList,list);
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return iterator.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return iterator.hasNext();
//    }
//}


class NestedIterator implements Iterator<Integer> {

    LinkedList<NestedInteger> que = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            que.offer(nestedInteger);
        }
    }

    @Override
    public Integer next() {
        return hasNext()? que.poll().getInteger() : - 1;
    }

    @Override
    public boolean hasNext() {
        if(que.isEmpty()) return false;

        if(que.getFirst().isInteger()) return true;

        NestedInteger poll = que.poll();
        List<NestedInteger> list = poll.getList();
        //列表拿出来在队头加入
        for (int i = list.size() - 1; i >= 0; i--) {
            que.offer(list.get(i));
        }

        return hasNext();
    }
}