class Solution {
    public int trap(int[] height) {
        if(height.length <3){
            return 0;
        }
        else
        {
            int waterstore=0;
            int waterlevel;
            int min_boundary;
            int max_left=height[0];
            int max_right=height[height.length-1];
            int max_left_boundary[]= new int[height.length];
            int max_right_boundary[]= new int[height.length];
            
            for(int i=0;i<height.length;i++){
                if(max_left<height[i]){
                    max_left=height[i];
                }
                max_left_boundary[i]=max_left;
            }

            for(int i=height.length-1;i>0;i--){
                if(max_right<height[i]){
                    max_right=height[i];
                }
                max_right_boundary[i]=max_right;
            }

            for(int i=0;i<height.length;i++){
                if(max_left_boundary[i]<max_right_boundary[i]){
                    min_boundary=max_left_boundary[i];
                }
                else{
                    min_boundary=max_right_boundary[i];
                }

                if(min_boundary-height[i]<0){
                    waterlevel=0;
                }
                else{
                    waterlevel=min_boundary-height[i];
                }

                waterstore+=waterlevel;
            }
            return waterstore;
        }

    }
}