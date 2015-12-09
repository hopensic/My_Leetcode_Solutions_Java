package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ValidAnagram
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String a = "aniagram";
        String b = "nagaramiu";
        
        System.out.println(new ValidAnagram().isAnagram(a, b));
    }
    
    public boolean isAnagram(String s, String t)
    {
        int a1[] = new int[26];
        int a2[] = new int[26];
        char charArray1[] = s.toCharArray();
        char charArray2[] = t.toCharArray();
        int len1 = charArray1.length;
        int len2 = charArray2.length;
        if (len1 != len2)
            return false;
        for (int i = 0; i < len1; i++)
        {
            a1[charArray1[i] - 'a']++;
            a2[charArray2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++)
        {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }
    
}
