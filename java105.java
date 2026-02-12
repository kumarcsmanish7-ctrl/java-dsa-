public class java105 {
    public static void main (String args[]){
        BankAccount myAcc = new BankAccount();
        myAcc.username = "manish kumar cs ";
        //myAcc.password = "abcdefghijkl";  //error bcz we cannot access it
        myAcc.setPassword("abcdefghijkl");//we can change password with this
    }

}
class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd){//we also could used default instead of public as per requirement
        password = pwd;
    }
}
