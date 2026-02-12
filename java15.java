class java15 { 
    public static void main(String args[]) {
        int a = 10;
        int b =--a;
        System.out.println(a);
        System.out.println(b);//output will be a=9 and b=9
        int c = 10;
        int d =a--;
        System.out.println(c);// c is 10 and d is 9
        System.out.println(d);
    }
}