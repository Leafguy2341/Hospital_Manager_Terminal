package Classes_2;

import java.util.*;



public class TAIKHOAN extends NGUOI{
    private String password;

    public TAIKHOAN(){};
    public TAIKHOAN(String ID,String password){
        super.setId(ID);
        this.password=password;
    }
    public TAIKHOAN(TAIKHOAN account){
        this.password = account.password;
        super.setId(account.getId());
    }
    public String getpassword(){
        return password;
    }
    public void setpassword(String password){
        this.password=password;
    }
    

    
    public void Doipassword(TAIKHOAN tk,Scanner sc){
        String new_password,old_password;
        sc.nextLine();
        do {
            System.out.print("Mat khau hien tai: ");
            old_password = sc.nextLine();
            if (tk.getpassword().equals(old_password)) {
                System.out.println("\nMat khau chinh xac. ");
                break;
            }else System.out.println("Sai mat khau hien tai");
        } while (!tk.getpassword().equals(old_password));
        
        do {
            System.out.print("Mat khau moi: ");
            new_password = sc.nextLine().trim();
            if (!new_password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
                System.out.println("\nMat khau moi phai co it nhat mot chu HOA, chu THUONG va chu so");
                break;
            }else tk.setpassword(new_password);
            System.out.println("Doi mat khau thanh cong.");
        } while (!new_password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$"));



    }
    public String toFileString() {
        return super.getId()+","+password;
    }
}
