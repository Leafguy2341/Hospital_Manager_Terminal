package Classes_2;

import java.util.Scanner;

public class PHONGKHAM {
    private String MaPK;
    private String TenPK;
    private String Khoa;
    private int SoLuong;
    private boolean TrangThai;
    Scanner sc=new Scanner(System.in);
    private static int countPhongKham=0;

    public PHONGKHAM(){}
    public PHONGKHAM(String MaPK, String TenPK, String Khoa, int SoLuong, boolean TrangThai){
        this.MaPK=MaPK;
        this.TenPK=TenPK;
        this.Khoa=Khoa;
        this.SoLuong=SoLuong;
        this.TrangThai=TrangThai;
        countPhongKham++;
    }
    public PHONGKHAM(PHONGKHAM pk){
        this.MaPK=pk.MaPK;
        this.TenPK=pk.TenPK;
        this.Khoa=pk.Khoa;
        this.SoLuong=pk.SoLuong;
        this.TrangThai=pk.TrangThai;
        countPhongKham++;
    }

    public String getMaPK(){
        return MaPK;
    }
    public void setMaPK(String MaPK){
        if (MaPK.matches("^PK\\d{3}$")) {
            this.MaPK=MaPK;
        }
        else  throw new IllegalArgumentException("Ma phong kham khong hop le");
    }
    public String getTenPK() {
        return TenPK;
    }
    public void setTenPK(String TenPK) {
        if (TenPK.matches("^Phong Kham [^,]+$")) {
            this.TenPK=TenPK;
        }
        else  throw new IllegalArgumentException("Ten phong kham khong hop le");
    }
    public String getKhoa() {
        return Khoa;
    }
    public void setKhoa(String Khoa) {
        if (Khoa.matches("^[a-zA-Z]$")) {
            this.Khoa=Khoa;
        }
        else  throw new IllegalArgumentException("Khoa khong hop le");
    }
    public int getSoLuong() {
        return SoLuong;
    }
    public void setSoLuong(int SoLuong) {
        if(SoLuong >=0 && SoLuong < 500)
            this.SoLuong = SoLuong;
        else
            throw new IllegalArgumentException("So luong khong hop le");
    }
    public boolean getTrangThai() {
        return TrangThai;
    }
    public void setTrangThai(boolean TrangThai) {
        if(TrangThai==true||TrangThai==false)
            this.TrangThai = TrangThai;
        else
            throw new IllegalArgumentException("Trang thai khong hop le");
    }
    public static int getCountPhongKham(){
        return countPhongKham;
    }
    public static void setCountPhongKham(int count){
        countPhongKham=count;
    }

    public void Nhap(){
        boolean Isvalid;
        do{
            try{
                System.out.print("Nhap Ten phong: ");
                TenPK=sc.nextLine();
                setTenPK(TenPK);
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
                System.out.print("Nhap Khoa: ");
                Khoa=sc.nextLine();
                setKhoa(Khoa);
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
                System.out.print("Nhap So luong: ");
                SoLuong=sc.nextInt();
                sc.nextLine(); // nuốt enter
                setSoLuong(SoLuong);
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
                System.out.print("Nhap Trang thai(1:Con trong/0:Da day): ");
                int tt = sc.nextInt(); sc.nextLine();
                TrangThai=(tt==1);
                setTrangThai(TrangThai);
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

    public void displayInfo() {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("          THONG TIN PHONG KHAM");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("Ma phong: " + MaPK);
        System.out.println("Ten phong: " + TenPK);
        System.out.println("Khoa: " + Khoa);
        System.out.println("Suc chua: " + SoLuong + " nguoi");
        System.out.println("Trang thai: " + (TrangThai ? "Con trong" : "Da day"));
        System.out.println("═══════════════════════════════════════════");
    }

    public String toFileString() {
        return MaPK+","+TenPK+","+Khoa+","+SoLuong+","+TrangThai;
    }

    @Override
    public String toString() {
        return String.format("Ma: %s | Ten: %s | Khoa: %s | Suc chua: %d | Trang thai: %s",MaPK, TenPK, Khoa, SoLuong, TrangThai ? "Con trong" : "Da day");
    }
}
