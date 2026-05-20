package list;

import java.util.*;


import Classes_2.*;
import java.io.*;
public class DSTAIKHOAN {
    private TAIKHOAN[] dstk;
    private int n_tk;

    public DSTAIKHOAN(){}
    public DSTAIKHOAN(TAIKHOAN[] dstk,int n_tk){
        this.dstk = dstk;
        this.n_tk = n_tk;
    }

    public TAIKHOAN[] getDstk() {
        return dstk;
    }
    public int getcountk(){
        return n_tk;
    }
    public void Them(TAIKHOAN tk){
        dstk=Arrays.copyOf(dstk, n_tk+1);
        dstk[n_tk] = tk;
        n_tk++;   
    }
    public Boolean Timtk(String ID){
        for (int i = 0; i < n_tk; i++) {
            if (dstk[i].getId().equals(ID)) {
                return true;
            }
        }
        return false;
    }
public TAIKHOAN KiemtraDN(String ID, String pass){
        for (int i = 0; i < getcountk(); i++) {
            if (dstk[i]!=null&&dstk[i].getId().equalsIgnoreCase(ID)&&dstk[i].getpassword().equalsIgnoreCase(pass)) {
                return dstk[i];
            }
        }
        System.out.println("Dang nhap that bai.");
        return null;
    }
    public TAIKHOAN DANGNHAP(Scanner sc){
        int lanthu =0;
        String pass,id;
        TAIKHOAN tk_dn =null;
        do {
            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║              DANG NHAP                       ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.print("║ ID: "); id = sc.nextLine().trim();
            System.out.print("║ Password: "); pass = sc.nextLine().trim(); 
            System.out.println("╚══════════════════════════════════════════════╝");
            if (KiemtraDN(id, pass)!= null) {
                System.out.println("Dang nhap thanh cong");
                tk_dn = KiemtraDN(id, pass);
                return tk_dn;
            }else lanthu++;
            if (lanthu >3) {
                System.out.print("Het lan dang nhap!!!.Vui long tai lai trang.");
            }
        } while (lanthu <=3);
        return null;
    }
    public void DocFile(String f){

    try(
        BufferedReader input = new BufferedReader(new FileReader(f))){ 
        dstk = new TAIKHOAN[0];
        n_tk = 0;
        String line;
        while((line = input.readLine()) != null){

            if(!line.trim().isEmpty()){
                String[] arr=line.trim().split(",");

                if(arr.length >= 2 && !arr[0].trim().isEmpty() && !arr[1].trim().isEmpty() ){
                    String id = arr[0].trim();
                    if (id.matches("(QL|BN|BS)\\d+")) {
                        try {
                            TAIKHOAN tk = new TAIKHOAN(id, arr[1].trim());
                            themTaiKhoan(tk); 
                        } catch (Exception e) {
                            System.out.println("Loi tai dong: " + line + " (Loi: " + e.getMessage() + ")");
                        }
                    } else {

                        System.out.println("Bo qua dong do ID khong dung dinh dang: " + line); 
                    }
                } else {

                    System.out.println("Bo qua dong khong du thong tin: " + line);
                }
            } 
        } 
        if (n_tk > 0)
            System.out.println("Doc du lieu thanh cong! Tong so TAIKHOAN: " + n_tk);
        else
            System.out.println("Khong co du lieu hop le nao duoc doc tu file.");
            

    } catch (FileNotFoundException e) {
        System.out.println("File " + f + " chua ton tai. Se tao moi khi luu.");
        dstk = new TAIKHOAN[0];
        n_tk = 0;
    } catch (IOException e) {
        System.out.println("Loi doc file: " + e.getMessage());
    }
}
    public void themTaiKhoan(TAIKHOAN tk){
        dstk=Arrays.copyOf(dstk, n_tk+1);
        dstk[n_tk] = tk;
        n_tk++;   
    }
    public void GhiFile(String f){
        try{
            FileWriter fw=new FileWriter(f);
            for (int i = 0; i < n_tk; i++) {
                fw.write(dstk[i].toFileString());
                fw.write("\n");
            }
            fw.close();
            System.out.println("Da luu " + n_tk + " thuoc vao file.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
    }


