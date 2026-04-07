class Solution {
    public boolean isValidSudoku(char[][] board) {

        //I have to declare 27 sets
        // 9 for rows 9 for column 9 for boxes

        Set<Character>[] row=new HashSet[9];
        Set<Character>[] col=new HashSet[9];
        Set<Character>[] box=new HashSet[9];

        for(int i=0;i<9;i++){
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            box[i]=new HashSet<>();
            

        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch=='.') continue;
                int boxCo=(i/3)*3+(j/3);
                if(row[i].contains(ch)) return false;
                if(col[j].contains(ch)) return false;
                if(box[boxCo].contains(ch)) return false;

                row[i].add(ch);
                col[j].add(ch);
                box[boxCo].add(ch);


            }
        }

        return true;
        
    }
}
