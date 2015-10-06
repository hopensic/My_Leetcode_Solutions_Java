package leetcode;

import tools.P;

public class MoveZeroes
{
    
    public static void main(String[] args)
    {
        int nums[] = {1, 2};
        new MoveZeroes().moveZeroes(nums);
        for (int t : nums)
            P.lnrint(t);
    }
    
    public void moveZeroes(int[] nums)
    {
        int len = nums.length;
        int numOfzero = 0;
        for (int i = 0; i < len; i++)
        {
            if (nums[i] == 0)
            {
                numOfzero++;
            }
            else
            {
                nums[i - numOfzero] = nums[i];
            }
        }
        for (int i = 0; i < numOfzero; i++)
        {
            nums[len - (i + 1)] = 0;
        }
        
    }
    
}
