package dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName leetcode_672_灯泡开关Ⅱ
 * @Author zxf
 * @Date 2023/10/9 17:24
 * @Questinon Describrition
 **/
public class leetcode_672_灯泡开关Ⅱ {

    HashSet<String> set = new HashSet<>();
    HashMap<String,HashSet<String>> map = new HashMap();

    public int flipLights(int n, int presses) {
        char[] chars = new char[n];

        Arrays.fill(chars,'O');

        dfs(presses,chars);

        for (String s : set) {
            System.out.println(s);
        }
        return set.size();
    }


    private void dfs(int presses,char[] chars){
        if(presses == 0){
            set.add(new String(chars));
            return;
        }
        String s = Arrays.toString(chars);
        if(map.containsKey(s)){
            HashSet<String> strings = map.get(s);
            for (String string : strings) {
                dfs(presses - 1,string.toCharArray());
            }
            return;
        }

        map.computeIfAbsent(s, k -> new HashSet<>());




        String key = Arrays.toString(chars);

        for (int i = 0; i < 4; i++) {
            char[] clone = chars.clone();

            if(i == 0){
                presse1(clone);
            }

            if(i == 1){
                presse2(clone);
            }

            if(i == 2){
                presse3(clone);
            }

            if(i == 3){
                presse4(clone);
            }

            String value = Arrays.toString(clone);
            HashSet<String> strings = map.get(key);
            strings.add(value);
            map.put(key,strings);

            dfs(presses-1,clone);
        }


    }

    private void presse1(char[] chars){

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'O'){
                chars[i] = 'X';
            }else{
                chars[i] = 'O';
            }
        }

    }

    private void presse2(char[] chars){
        System.out.println("press 2");
        for (int i = 0; i < chars.length; i = i + 2) {
            if(chars[i] == 'O'){
                chars[i] = 'X';
            }else{
                chars[i] = 'O';
            }
        }
    }

    private void presse3(char[] chars){
        System.out.println("press 3");
        for (int i = 1; i < chars.length; i = i + 2) {
            if(chars[i] == 'O'){
                chars[i] = 'X';
            }else{
                chars[i] = 'O';
            }
        }
    }

    private void presse4(char[] chars){


        for (int i = 0; i < chars.length; i = i + 1) {
            int j = 3 * i ;

            if(j >= chars.length) continue;

            if(chars[j] == 'O'){
                chars[j] = 'X';
            }else{
                chars[j] = 'O';
            }
        }

    }


    public static void main(String[] args) {
        leetcode_672_灯泡开关Ⅱ v = new leetcode_672_灯泡开关Ⅱ();

        int n = 3;
        int presses = 1;

        int i = v.flipLights(n, presses);
        System.out.println(i);
    }
}
