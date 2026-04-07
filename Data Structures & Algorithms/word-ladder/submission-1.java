class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int beginLen=beginWord.length();
        

        Set<String> dict=new HashSet<>(wordList);
       
        Queue<String> que=new LinkedList<>();

        que.offer(beginWord);
         int count=1;
        while(!que.isEmpty()){

            int qsize=que.size();
            for(int k=0;k<qsize;k++){

            String word=que.poll();
            int len=word.length();
            char[] charWord=word.toCharArray();

             for(int i=0;i<len;i++){
                char curr=charWord[i];
                for(int j=0;j<26;j++){
                    char nword=(char)('a'+j);
                    if(nword==curr) continue;
                    charWord[i]=nword;
                    String newWord=new String(charWord);
                    if(dict.contains(newWord) && newWord.equals(endWord)){
                        return count+1;                       
                    }else if(dict.contains(newWord)){
                        que.offer(newWord);
                        dict.remove(newWord);
                    }
                }
                charWord[i]=curr;
            }

            }
           

            count++;
        }
        

        return 0;
    }
}
