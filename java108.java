public class java108 {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.name = "manish";
        s1.roll = 456;
        s1.password = "abcd";
        s1.marks[0] =100;
        s1.marks[1] = 98;
        s1.marks[2] = 80;
       //if s1 student forgets his password so we are creating a s2 and copying all the 
       // properties of s1 to s2    
        Student s2 = new Student(s1);
        s2.password = "xyz ";
        s1.marks[2]=100;
        for(int i =0 ; i<3;i++){
            System.out.println(s2.marks[i]);//important output 100 98 100 
        }
       

    }
}
    
    class Student {
        String name ;
        int roll ;
        String password;
        int marks[];
        // copy constructor
        Student(Student s1) {
            marks = new int [3];
            this.name = s1.name ;
            this.roll = s1.roll;
            this.marks =s1.marks;
            
        }
        Student(){
            marks = new int[3];
            this.name =name;

            
        }
        Student(String name){
            marks = new int [3];
            this.name = name;
        }
        Student(int roll){
            marks = new int [3];
            this.roll =roll;
        }



}


