package leetcode;

import tools.P;

public class JumpGame_II
{
    
    public static void main(String[] args)
    {
        int arr[] = {1,2,1,1,1};
        int a = new JumpGame_II().jump(arr);
        P.lnrint(a);
        
    }
    
    public int jump(int[] nums)
    {
        int len = nums.length;
        int t[] = new int[len];
        if (len <= 1)
            return 0;
        if (len == 2)
            return 1;
        t[len - 2] = 1;
        int dif;
        int min;
        int tmpSum;
        
        for (int i = len - 2; i >= 1; i--)
        {
            min = 99999;
            dif = len - i - nums[i - 1];
            if (dif <= 0)
            {
                t[i - 1] = 1;
                continue;
            }
            else
            {
                min = 999999;
                for (int j = 1; j <= nums[i - 1]; j++)
                {
                    tmpSum = 1 + t[i - 1 + j];
                    if (tmpSum < min)
                        min = tmpSum;
                }
                t[i - 1] = min;
            }
            
        }
        return t[0];
    }
    
}
