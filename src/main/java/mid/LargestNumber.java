package mid;

import java.util.Arrays;

/**
 * @author ：Curtain
 * @date ：Created in 2021/4/12 16:13
 * @description：最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
    
    public static String largestNumber(int[] nums){
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++)
            ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s : ss)
            sb.append(s);
            int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0')
            k++;
        return sb.substring(k);
    }
}
