import java.util.Stack;

public class java174 {
    public static boolean isValid(String Str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<Str.length();i++){///O(n)
            char ch = Str.charAt(i);
            
            if(ch=='(' || ch =='{' || ch == '['){
                s.push(ch);
            }
            else{
                //closing 
                if(s.isEmpty()){
                    return false;

                }
                if((s.peek()== '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek()=='['&& ch ==']') ){
                    s.pop();
                }else{
                    return false; 
                }
            }
        }
        if(s.isEmpty()){
            return true; 
        }
        else{
            return false;
        }

    }

    public static boolean isDuplicate(String str){
        Stack<Character>s = new Stack<>();
        for(int i = 0 ; i<str.length(); i++){
            char ch =str.charAt(i);

            //closing 
            if(ch == ')'){
                int count =0;
                while(s.peek()!='('){ // (not) !s.isEmpty()
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true; //duplicate exists
                } else {
                    s.pop(); //opening pair 
                }
            } else{
                //opening
                s.push(ch);
            }
        }
        return false ;
    }
    public static void main(String args[]){
        String str = "((a+b))";//true
        String str2 = "(a-b)"; //false 
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));
    }
}
