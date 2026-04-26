class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 0;

        int wordLen = beginWord.length();
        Set<String> set = new HashSet<>();
        Set<String> words = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        int count = 0;

        for (String s : wordList) {
            words.add(s);
        }

        if(!words.contains(endWord)) return 0;

        que.offer(beginWord);

        while (!que.isEmpty()) {
            int size = que.size();
            count++;

            for (int k = 0; k < size; k++) {
              
                String currWord = que.poll();
                for (int i = 0; i < wordLen; i++) {
                    char ch = currWord.charAt(i);

                    for (int j = 0; j < 26; j++) {
                        char newChar = (char) ('a' + j);
                        if (newChar == ch)
                            continue;
                        String newWord = currWord.substring(0, i) + newChar
                            + currWord.substring(i + 1);
                        if (newWord.equals(endWord))
                            return count+1;
                        else {
                            if (set.contains(newWord) || !words.contains(newWord))
                                continue;

                            que.offer(newWord);
                            set.add(newWord);
                        }
                    }
                }
            }
        }


        return 0;
    }
}
