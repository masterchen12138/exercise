package days4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yec
 * @date 2021-08-26
 * 串联所有单词的子串
 */
public class Day030 {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
		HashMap<String, Integer> map = new HashMap<>();
		int word_len = words[0].length();
		int word_num = words.length;
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (int i = 0; i < word_len; i++) {
			int left = i, right = i, count = 0;
			HashMap<String, Integer> tmp_map = new HashMap<>();
			while (right <= s.length() - word_len) {
				String w = s.substring(right, right + word_len);
				right += word_len;
				if (!map.containsKey(w)) {
					count = 0;
					left = right;
					tmp_map.clear();
				} else {
					tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
					count++;
					while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
						String t_w = s.substring(left, left + word_len);
						count--;
						tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
						left += word_len;
					}
					if (count == word_num) res.add(left);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
	}
}
