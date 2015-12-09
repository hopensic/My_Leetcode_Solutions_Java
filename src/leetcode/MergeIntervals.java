package leetcode;

import java.util.ArrayList;
import java.util.List;

import tools.P;

public class MergeIntervals
{
    
    public static void main(String[] args)
    {
        MergeIntervals m = new MergeIntervals();
        
        Interval t1 = m.new Interval(1, 3);
        Interval t2 = m.new Interval(2, 6);
        Interval t3 = m.new Interval(5, 7);
        Interval t4 = m.new Interval(8, 10);
        List<Interval> list = new ArrayList<Interval>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        List<Interval> resultList = m.merge(list);
        P.lnrint(resultList);
        
    }
    
    class Interval
    {
        int start;
        
        int end;
        
        Interval()
        {
            start = 0;
            end = 0;
        }
        
        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals)
    {
        
        
        
        return null;
    }
    
}
