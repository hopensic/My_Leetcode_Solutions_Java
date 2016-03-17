package leetcode;

import tools.P;

public class HouseRobber1
{
    
    public static void main(String[] args)
    {
        int[] a = {1, 3, 4, 5, 2, 9, 7, 1, 2};
        P.lnrint(new HouseRobber1().rob(a));
        
    }
    
    public int rob(int[] nums)
    {
        int len = nums.length;
        if (len == 0)
            return 0;
        else if (len == 1)
            return nums[0];
        else if (len == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        else
        {
            return 0;
        }
    }
    
    private int getMax(int[] nums ,int left ,int right){
        if(right-left>1){
//            int middle = 
            return 0;
        }else if(right==left+1){
            return nums[left] > nums[right] ? nums[left] : nums[right];
        }else{
            return nums[left];
        }
    }
    
    
}
