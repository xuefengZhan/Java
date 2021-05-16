package _01_;
//todo 99乘法表
public class _99_ {
    public static void main(String[] args) {
        _99_ a = new _99_();
        String result = a.multi(9);
        System.out.println(result);
    }
    private String multi(int n){
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=9;i++){
            for(int j = 1;j<=i;j++){
                int x = j*i;
                sb.append(j).append('*').append(i).append("=").append(x).append(';');
                if(j==i) sb.append('\n');
            }
        }
        return sb.toString();
    }
}
