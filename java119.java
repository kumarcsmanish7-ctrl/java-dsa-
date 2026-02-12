public class java119 {
    public static void main (String args[]){
        Student s1 = new Student();
        s1.schoolName = "JMV";//if we declare schoolname for one then we will declare for all the others
        Student s2 = new Student();
        System.out.println(s2.schoolName);

        Student s3 = new Student();
        s3.schoolName = "ABC";//then s1 s2 school name changes to ABC
        //static variables memory me ek he bar bantahe 
    }
}
class Student {
    static int returnPercentage(int math, int phy , int chem){
        return (math+phy + chem)/3;
    }
    String name ; 
    int roll;
    static String schoolName;

    void setName (String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
}
