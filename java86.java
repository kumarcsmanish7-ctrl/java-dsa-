public class java86 {
    public static float getShortestPath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir = path.charAt(i);
            //south
            if(dir=='S'){
                y--;
            }
            // north 
            else if(dir =='N') {
                y++;
            }
            else if(dir =='E'){
                x++;
            }
            else {
                x--;
            }
            }
            int x2= x*x;
            int y2 = y*y;
        return (float)Math.sqrt(x2+y2) ;
    }
    public static void main(String args){
        String path = "WNEEESENNN";
        System.out.println(getShortestPath(path));
    }
}
