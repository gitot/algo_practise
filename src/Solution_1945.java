import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_1945 {

    public int getLucky(String s, int k) {
        //获取数字串
        char[] arr = s.toCharArray();
        int len = arr.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int num = arr[i] - 'a' + 1;
            if(num / 10 != 0) list.add(num / 10); //十位数
            list.add(num % 10);//个位数
        }

        //循环k次进行转化
        List<Integer> tmp = list;
        for(int i = 0; i < k; i++){
            int sum = sum(tmp);
            if (i == k - 1) {
                return sum;
            }

            //将sum转化为数字列表
            LinkedList<Integer> next = new LinkedList<>();
            int reminder = sum;
            while(reminder != 0){
                int n = reminder % 10;//取最后一位数字
                next.addFirst(n);
                reminder /= 10;
            }
            tmp = next;
        }

        return -1;
    }

    int sum(List<Integer> list){
        int sum = 0;
        for(int t: list){
            sum += t;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_1945 solution_1945 = new Solution_1945();
        int iiag = solution_1945.getLucky("iiag", 4);
        System.out.println(iiag);
    }
}


