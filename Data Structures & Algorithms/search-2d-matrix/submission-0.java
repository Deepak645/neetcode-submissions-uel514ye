class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

       
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int row=0,col=n-1;
        for(int i=0;i<matrix.length;i++){

           if(matrix[i][n]==target) return true;
           else if(matrix[i][n]>target){row=i;break; }
           else {row=i+1;}
        }

        if(row==m+1) return false;
        else{
            int left=0,right=n-1;
            while(left<=right){
                int mid=(left+right)/2;
                if(matrix[row][mid]==target) return true;
                else if(matrix[row][mid]<target) left=mid+1;
                else right=mid-1;
            }
        }

        return false;
        
    }
}
