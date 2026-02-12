public class java107 {
    public static void main(String args[]){
        Student s1 = new Student();
        Student s2 = new Student("manish");
        Student s3 = new Student(123);

        //System.out.println(s1.name);

    }
}
    
    class Student {
        String name ;
        int roll ;

        Student() {
            //non parameterized constructor
            //this.name = name;
            System.out.println("constructor is called ...");
        }
        
        Student(String name){
            this.name = name;
        }
        Student(int roll){
            this.roll =roll;
        }



    }


