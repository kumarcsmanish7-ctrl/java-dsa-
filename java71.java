public class java71{
    public static int trappedRainWater(int height[]){
        int n = height.length;
        int rightMax[] = new int[n];
        //calculate left max boundary - array 
        int leftMax[]=new int[height.length];
        leftMax[0] = height[0];
        for(int i =1;i<height.length;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
           
        }

        //calculate right max boundary - array
        
        
        rightMax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        } 
        //loop 
        int trappedWater =0; 
        for (int i =0;i<n ; i++){
        //water level =min(left max boundary ,rightmax boundary)
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
        //trapped water = water level - height[i]
        trappedWater +=waterLevel - height[i];

        }
        return trappedWater;
    }
    public static void main(String args[]){
        int height[]= {4,2,0,6,3,2,5};
        System.out.println(trappedRainWater(height));
        }
    }