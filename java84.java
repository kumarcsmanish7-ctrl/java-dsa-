import java.util.*;
public class java84{
public static void printLetters(String str){ 
    for(int i =0;i<str.length();i++){
        System.out.print(str.charAt(i)+" ");
    }
    System.out.println();
}
public static void main(String args[]){
        char arr[]={'a', 'b', 'c','d'};
        String str="abcd";
        String str2 = new String("xyz");
        //strings are immutable 
        Scanner sc = new Scanner(System.in);
        String name;
        name =sc.next();//takes only one word input
        String names;
        names =sc.nextLine();//takes line
        System.out.println(name);
        System.out.println(names);


        String fullName = "Tony stark";
        System.out.println(fullName.length()); 
        //array ke andar .length ek property he
        //string ke andar .length() ek function he 

        //concatination 
        String firstname = " Manish";
        String lastname = "Kumar";
        String fullname = firstname + " " + lastname;
        System.out.println(fullname+ " is this");//this is also concatination 
        //to find character at index
        System.out.println(fullName.charAt(0));


        printLetters(fullname);
    }
    
}
