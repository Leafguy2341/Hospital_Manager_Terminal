package Classes_2;

import java.util.Scanner;

public class BENHNHAN extends NGUOI{
    private String TienSuBenh;
    private String NhomMau;
    private String DiUng;
    Scanner sc=new Scanner(System.in);
    private static int countBenhNhan;

    public BENHNHAN(){}
    public BENHNHAN (String id, String HoTen, int Tuoi, String GioiTinh, String SDT, String DiaChi, String TienSuBenh, String NhomMau, String DiUng){
        super(id,HoTen,Tuoi,GioiTinh,SDT,DiaChi);
        this.TienSuBenh=TienSuBenh;
        this.NhomMau=NhomMau;
        this.DiUng=DiUng;
        countBenhNhan++;
    }
    public BENHNHAN(BENHNHAN bn){
        super(bn);
        this.TienSuBenh=bn.TienSuBenh;
        this.NhomMau=bn.NhomMau;
        this.DiUng=bn.DiUng;
        countBenhNhan++;
    }
    public String getTienSuBenh() {
        return TienSuBenh;
    }
    public String getNhomMau() {
        return NhomMau;
    }
    public String getDiUng() {
        return DiUng;
    }
    public static int getCountBenhNhan(){
        return countBenhNhan;
    }

    //Hàm set
    public void setTienSuBenh(String TienSuBenh) {
        if (TienSuBenh.matches("^[a-zA-Z0-9\\s,./-]{1,256}$")) {
            this.TienSuBenh = TienSuBenh;
        }
        else
            throw new IllegalArgumentException("Tien su benh khong duoc co ky tu dac biet!");
    }
    
    public void setNhomMau(String NhomMau) {
        if (NhomMau.matches("^(A|B|O|AB)$")) {
            this.NhomMau = NhomMau;
        }
        else
            throw new IllegalArgumentException("Nhom mau khong hop le");
    }
    
    public void setDiUng(String DiUng) {
        if (DiUng.matches("^[a-zA-Z\\s,./-]{1,256}$")) {
            this.DiUng = DiUng;
        }
        else
            throw new IllegalArgumentException("Di ung khong duoc mo ta bang so hay ky tu dac biet");
    }
    
    public static void setCountBenhNhan(int n){
        countBenhNhan=n;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        boolean Isvalid;
        do{
            try{
                System.out.print("Nhap Tieu Su Benh: ");
                TienSuBenh=sc.nextLine();
                setTienSuBenh(TienSuBenh);
                Isvalid=true;
            }
            catch(Exception e){
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        }while(!Isvalid);
        do{
            try{
                System.out.print("Nhap Nhom Mau(A|B|O|AB): ");
                NhomMau=sc.nextLine();
                setNhomMau(NhomMau);
                Isvalid=true;
            }
            catch(Exception e){
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        }while(!Isvalid);
        do{
            try{
                System.out.print("Nhap Di Ung: ");
                DiUng=sc.nextLine();
                setDiUng(DiUng);
                Isvalid=true;
            }
            catch(Exception e){
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        }while(!Isvalid);
    }
    public void displayInfo(){
        System.out.println("═══════════════════════════════════════════");
        System.out.println("          THONG TIN BENH NHAN");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("Id: " + super.getId());
        System.out.println("Ho ten: " + super.getHoTen());
        System.out.println("Tuoi: " + super.getTuoi());
        System.out.println("Gioi tinh: " + super.getGioiTinh());
        System.out.println("SDT: " + super.getSDT());
        System.out.println("Dia chi: " + super.getDiaChi());
        System.out.println("Tien Su Benh: " + TienSuBenh);
        System.out.println("Nhom Mau: " + NhomMau);
        System.out.println("Di ung: " + DiUng);
        System.out.println("═══════════════════════════════════════════");
    }

    public String toFileString(){
        return getId()+","+getHoTen()+","+getTuoi()+","+getGioiTinh()+","+getSDT()+","+getDiaChi()+","+TienSuBenh+","+NhomMau+","+DiUng;
    }
    public String toString(){
        return super.toString()+String.format(" | Tien su benh: %s | Nhom mau: %s | Di ung: %s",TienSuBenh,NhomMau,DiUng);
    }
}
