package Classes_2;

import java.util.Scanner;

public class BACSI extends NGUOI{
    private String ChuyenKhoa;
    private String LichLamViec;
    private double Luong;
    Scanner sc=new Scanner(System.in);
    private static int countBacSi;

    public BACSI(){}
    public BACSI (String id, String HoTen, int Tuoi, String GioiTinh, String SDT, String DiaChi, String ChuyenKhoa, String LichLamViec,double Luong){
        super(id,HoTen,Tuoi,GioiTinh,SDT,DiaChi);
        this.ChuyenKhoa=ChuyenKhoa;
        this.LichLamViec=LichLamViec;
        this.Luong=Luong;
        countBacSi++;
    }
    public BACSI(BACSI bs){
        super(bs);
        this.ChuyenKhoa=bs.ChuyenKhoa;
        this.LichLamViec=bs.LichLamViec;
        this.Luong=bs.Luong;
        countBacSi++;
    }
    public String getChuyenKhoa() {
        return ChuyenKhoa;
    }
    public String getLichLamViec() {
        return LichLamViec;
    }
    public double getLuong() {
        return Luong;
    }
    public static int getcountBacSi(){
        return countBacSi;
    }
    //Hàm set
    public void setChuyenKhoa(String ChuyenKhoa) {
        if (ChuyenKhoa.matches("^[a-zA-Z\\s]+$")) {
            this.ChuyenKhoa=ChuyenKhoa;   
        }
        else
            throw new IllegalArgumentException("Chuyen khoa khong hop le");
    }
    
    public void setLichLamViec(String LichLamViec) {
        if (LichLamViec.matches("^Thu [2-7]-Thu [2-7]$")) {
            this.LichLamViec = LichLamViec;
        }
        else
            throw new IllegalArgumentException("Lich lam viec khong hop le");
    }
    
    
    public void setLuong(double Luong){
        if(Luong >=0)
            this.Luong = Luong;
        else    
            throw new IllegalArgumentException("Luong khong hop le");
    }

    public static void setcountBacSi(int count){
        countBacSi= count;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        boolean Isvalid;
        do{
            try{
                System.out.print("Nhap Chuyen Khoa: ");
                ChuyenKhoa=sc.nextLine();
                setChuyenKhoa(ChuyenKhoa);
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
                System.out.print("Nhap Lich Lam Viec(Thu 2-7): ");
                LichLamViec=sc.nextLine();
                setLichLamViec(LichLamViec);
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
                System.out.print("Nhap Luong: ");
                Luong=sc.nextDouble();
                setLuong(Luong);
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
        System.out.println("            THONG TIN BAC SI");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("Id: " + super.getId());
        System.out.println("Ho ten: " + super.getHoTen());
        System.out.println("Tuoi: " + super.getTuoi());
        System.out.println("Gioi tinh: " + super.getGioiTinh());
        System.out.println("SDT: " + super.getSDT());
        System.out.println("Dia chi: " + super.getDiaChi());
        System.out.println("Chuyen khoa: " + ChuyenKhoa);
        System.out.println("Lich lam viec: " + LichLamViec);
        System.out.println("═══════════════════════════════════════════");
    }

    public String toFileString(){
        return getId()+","+getHoTen()+","+getTuoi()+","+getGioiTinh()+","+getSDT()+","+getDiaChi()+","+ChuyenKhoa+","+LichLamViec+","+Luong;
    }
    public String toString(){
        return super.toString()+String.format(" | Chuyen Khoa: %s | Lich lam viec: %s",ChuyenKhoa,LichLamViec);
    }
}
