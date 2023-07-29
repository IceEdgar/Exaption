package HomeworkJava;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class sortSubscriber {

    public static void addPhons(String key, int value, Map<String, ArrayList<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }

    public static void sortPhons(Map<String, ArrayList<Integer>> map) {
        Set<String> keySet = map.keySet();
        int max = 0;
        int min = 0;
        for (var item : map.entrySet()) {
            if (max < item.getValue().size())
                max = item.getValue().size();
            if (min > item.getValue().size())
                min = item.getValue().size();
        }
        Stack<String> st = new Stack<>();
        int number = min;
        while (number <= max) {
            for (var item : map.entrySet()) {
                if (item.getValue().size() == number) {
                    st.push(item.getKey());
                }
            }
            number += 1;
        }
        String nameSubscribe;
        for (int i = 0; i < keySet.size(); i++) {
            nameSubscribe = st.pop();
            for (var item : map.entrySet()) {
                if (nameSubscribe == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> subscriber = new HashMap<>();
        addPhons("Петров", 12323, subscriber);
        addPhons("Петров", 1222234, subscriber);
        addPhons("Иванов", 54256585, subscriber);
        addPhons("Воронина", 89536477, subscriber);
        addPhons("Пупкин", 12356233, subscriber);
        addPhons("Иванов", 787897, subscriber);
        addPhons("Воронина", 893433477, subscriber);
        addPhons("Воронина", 895564567, subscriber);
        sortPhons(subscriber);
    }
}