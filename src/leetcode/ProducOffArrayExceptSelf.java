package leetcode;

import tools.P;

public class ProducOffArrayExceptSelf
{
    
    public static void main(String[] args)
    {
        int nums[] = {1, 2, 3, 4};
        int sum[] = new ProducOffArrayExceptSelf().productExceptSelf(nums);
        for (int s : sum)
            P.lnrint(s);
    }
    
    public int[] productExceptSelf(int[] nums)
    {
        int len = nums.length;
        int L[] = new int[len];
        int R[] = new int[len];
        int sum[] = new int[len];
        L[0] = 1;
        R[len - 1] = 1;
        
        for (int i = 1; i < len; i++)
        {
            L[i] = L[i - 1] * nums[i - 1];
            R[len - i - 1] = R[len - i] * nums[len - i];
        }
        for (int i = 0; i < len; i++)
            sum[i] = L[i] * R[i];
        return sum;
    }
    
}
