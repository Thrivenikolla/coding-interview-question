package io.dure.coding.graph;

import java.util.*;

public class LadderLength {
     // O(v+e) time
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Queue<String> queue1 = new LinkedList<>();
//        Queue<String> queue2 = new LinkedList<>();
//        Set<String> notVisited = new HashSet<>(wordList);
//        int length = 1;
//        queue1.offer(beginWord);
//        while (!queue1.isEmpty()) {
//            String word = queue1.poll();
//            if (word.equals(endWord)) {
//                return length;
//            }
//            List<String> neighbors = getNeighbors(word);
//            for (String neighbor : neighbors) {
//                if (notVisited.contains(neighbor)) {
//                    queue2.offer(neighbor);
//                    notVisited.remove(neighbor);
//                }
//            }
//            if (queue1.isEmpty()) {
//                length++;
//                queue1 = queue2;
//                queue2 = new LinkedList<>();
//            }
//        }
//        return 0;
//    }
    // O(v+e) time
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 2;
        set1.add(beginWord);
        set2.add(endWord);
        notVisited.remove(endWord);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set2.size() < set1.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }

            Set<String> set3 = new HashSet<>();
            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);
                for (String neighbor : neighbors) {
                    if (set2.contains(neighbor)) {
                        return length;
                    }
                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }
            length++;
            set1 = set3;
        }
        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != old) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }
}
