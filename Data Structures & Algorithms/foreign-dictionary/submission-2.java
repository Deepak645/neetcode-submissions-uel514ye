class Solution {
    public String foreignDictionary(String[] words) {
        // create a graph
        Map<Character, Integer> inDeg = new HashMap<>();
        Map<Character, List<Character>> gp = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            char[] ch = word.toCharArray();

            for (char c : ch) {
                gp.putIfAbsent(c, new ArrayList<>());
                inDeg.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int len = Math.min(first.length(), second.length());

            if (first.startsWith(second) && first.length() > second.length())
                return "";

            for (int j = 0; j < len; j++) {
                if (first.charAt(j) == second.charAt(j))
                    continue;

                // gp.put(first.charAt(j),gp.get(first.charAt(j)).add(second.charAt(j)));
                gp.computeIfAbsent(first.charAt(j), k -> new ArrayList<>()).add(second.charAt(j));
                inDeg.put(second.charAt(j), inDeg.get(second.charAt(j)) + 1);
                break;
            }
        }

        Queue<Character> que = new LinkedList<>();

        inDeg.forEach((key, value) -> {
            if (value == 0)
                que.offer(key);
        });

        while (!que.isEmpty()) {
            char ch = que.poll();
            ans.append(ch);
            for (char nb : gp.get(ch)) {
                inDeg.put(nb, inDeg.get(nb) - 1);
                if (inDeg.get(nb) == 0)
                    que.offer(nb);
            }
        }

        if (ans.length() == gp.size())
            return ans.toString();
        else
            return "";
    }
}
