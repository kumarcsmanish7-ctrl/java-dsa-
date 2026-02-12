public class java106 {
    public static void main(String args[]){
        Pen p1 = new Pen();//created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip()); 
        p1.setColor("Yellow");
        System.out.println(p1.getColor()); 
    }
}
class Pen{
    private String color;
    private int tip;//tip is pen's property
    String getColor (){
        return this.color;//this means current object
        //this replaces current object   
    }
    int getTip(){
        return this.tip;
    }

    void setColor(String newColor){
        this.color = newColor;
    }
    void setTip(int tip){//tip is a external variable
        this.tip = tip;//this , is useful when variables have the same name 


    }
}
class Student{
    String name ; 
    int age ;
    float percentage;//cgpa

    void clacPercentage (int phy , int chem, int math){
        percentage = (phy + chem +math)/3;  
    }
}
