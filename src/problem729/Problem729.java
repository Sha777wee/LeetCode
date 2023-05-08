package problem729;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */
public class Problem729 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        System.out.println(myCalendar.book(20, 30)); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
    }
}

class MyCalendar {
    List<int[]> list = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        for (int[] time : list) {
            if (end > time[0] && start < time[1]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}