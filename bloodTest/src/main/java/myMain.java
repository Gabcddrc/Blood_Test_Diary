
class Solution {
  public int removeDuplicates(int[] nums) {
    int x = 0;
      for(int i = 0; i < nums.length; i++){
          if(i==0){
            x++;
          }
          else if(nums[i] != nums[i-1]){
            x++;
          }
          else{
            continue;
          }
      }
      return x;

  }
}
