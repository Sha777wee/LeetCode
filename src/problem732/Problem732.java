package problem732;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem732 {
    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        Scanner scanner = new Scanner(System.in);
        int startTime = 0, endTime = 0;
        do {
            startTime = scanner.nextInt();
            endTime = scanner.nextInt();
            System.out.println(myCalendarThree.book(startTime, endTime));
        } while (startTime >= 0 && endTime >= 0);
    }
}

class MyCalendarThree {

    private Map<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        // 更新端点，start端点+1，end端点-1
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);
        int result = 0;
        int temp = 0;
        // 开始恢复，
        for (Integer key : map.keySet()) {
            temp = temp + map.get(key);
            result = Math.max(result, temp);
        }
        return result;
    }
}