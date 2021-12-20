package io.dure.coding.hash;

public class IsAlienSorted {
    // O(nm) time | O(1) space
    public boolean isAlienSorted(String[] words, String order) {
        // 创建反索引
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        // 逐个比较
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i+1], orderArray)) {
                return false;
            }
        }
        return true;
    }
    private boolean isSorted(String word1, String word2, int[] order) {
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if (order[ch1 - 'a'] <  order[ch2 - 'a']) {
                return true;
            }
            if (order[ch1 - 'a'] > order[ch2 - 'a']) {
                return false;
            }
        }
        return i == word1.length();
    }
}
