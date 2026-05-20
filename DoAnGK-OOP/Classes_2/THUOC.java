package Classes_2;

import java.util.Scanner;

public class THUOC {
    private String MaThuoc;
    private String TenThuoc;
    private String LoaiThuoc;
    private double DonGia;
    private int SoLuong;
    private String CachSuDung;
    Scanner sc=new Scanner(System.in);

    private static int countThuoc=0;

    public THUOC(){}
    public THUOC(String MaThuoc, String TenThuoc, String LoaiThuoc, double DonGia, int SoLuong, String CachSuDung){
        this.MaThuoc=MaThuoc;
        this.TenThuoc=TenThuoc;
        this.LoaiThuoc=LoaiThuoc;
        this.DonGia=DonGia;
        this.SoLuong=SoLuong;
        this.CachSuDung=CachSuDung;
        countThuoc++;
    }
    public THUOC(THUOC th){
        this.MaThuoc=th.MaThuoc;
        this.TenThuoc=th.TenThuoc;
        this.LoaiThuoc=th.LoaiThuoc;
        this.DonGia=th.DonGia;
        this.SoLuong=th.SoLuong;
        this.CachSuDung=th.CachSuDung;
        countThuoc++;
    }

    public String getMaThuoc(){
        return MaThuoc;
    }
    public void setMaThuoc(String MaThuoc){

        if (MaThuoc.matches("^TH\\d{3}$")) {
            this.MaThuoc = MaThuoc;    
        }
        else
            throw new IllegalArgumentException("Ma thuoc khong hop le");
    }
    public String getTenThuoc() {
        return TenThuoc;
    }
    public void setTenThuoc(String TenThuoc){
        if(TenThuoc.matches("^[a-zA-Z0-9\\s,./-]{1,256}$"))
            this.TenThuoc = TenThuoc;
        else
            throw new IllegalArgumentException("Ten thuoc khong duoc co ky tu dac biet");
    }
    public String getLoaiThuoc(){
        return LoaiThuoc;
    }
    public void setLoaiThuoc(String LoaiThuoc){
        if(LoaiThuoc.matches("^[a-zA-Z0-9\\s,./-]{1,256}$"))
            this.LoaiThuoc = LoaiThuoc;
        else
            throw new IllegalArgumentException("Loai thuoc khong duoc co ky tu dac biet");
    }
    public double getDonGia() {
        return DonGia;
    }
    public void setDonGia(double DonGia){
        if(DonGia >=0 && DonGia < 500000)
            this.DonGia = DonGia;
        else
            throw new IllegalArgumentException("Don Gia khong hop le");
    }
    public int getSoLuong() {
        return SoLuong;
    }
    public void setSoLuong(int SoLuong){
        if(SoLuong >=0 && SoLuong < 200000)
            this.SoLuong = SoLuong;
        else
            throw new IllegalArgumentException("So luong khong hop le");
    }
    public String getCachSuDung() {
        return CachSuDung;
    }
    public void setCachSuDung(String CachSuDung){
        if(CachSuDung.matches("^[a-zA-Z0-9\\s/,.-]{1,256}$"))
            this.CachSuDung = CachSuDung;
        else    
            throw new IllegalArgumentException("Cach Su dung khong duoc co ky tu dac biet");
    }
    public static int getCountThuoc(){
        return countThuoc;
    }
    public static void setCountThuoc(int count){
        countThuoc=count;
    }

    public boolean TrangThai(){
        return SoLuong>0;
    }
    public boolean TrangThaiSauKhiBan(int SoLuongMua){
        if(SoLuong>=SoLuongMua){
            SoLuong-=SoLuongMua;
            return true;
        }
        return false;
    }
    public void Nhap(){
        boolean Isvalid;
        do{
            try{
                System.out.print("Nhap Ten thuoc: ");
                TenThuoc=sc.nextLine();
                setTenThuoc(TenThuoc);
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
                System.out.print("Nhap Loai thuoc: ");
                LoaiThuoc=sc.nextLine();
                setLoaiThuoc(LoaiThuoc);
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
                System.out.print("Nhap Don gia: ");
                DonGia=sc.nextDouble();
                sc.nextLine();
                setDonGia(DonGia);
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
                SoLuong= Integer.parseInt(sc.nextLine());
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
                System.out.print("Nhap Cach su dung: ");
                CachSuDung=sc.nextLine();
                setCachSuDung(CachSuDung);
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
        System.out.println("            THONG TIN THUOC");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("Ma thuoc: " + MaThuoc);
        System.out.println("Ten thuoc: " + TenThuoc);
        System.out.println("Loai: " + LoaiThuoc);
        System.out.println("Gia: " + String.format("%,.0f VND", DonGia));
        System.out.println("So luong: " + SoLuong);
        System.out.println("Cach dung: " + CachSuDung);
        System.out.println("═══════════════════════════════════════════");
    }

    public String toFileString() {
        return MaThuoc+","+TenThuoc+","+LoaiThuoc+","+DonGia+","+SoLuong+","+CachSuDung;
    }

    @Override
    public String toString() {
        return String.format("Ma: %s | Ten: %s | Loai: %s | Gia: %,.0f VND | SL: %d",MaThuoc, TenThuoc, LoaiThuoc, DonGia, SoLuong);
    }
}
