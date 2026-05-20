package Classes_2;

import java.util.Scanner;

public abstract class NGUOI {
    private String id;
    private String HoTen;
    private int Tuoi;
    private String GioiTinh;
    private String SDT;
    private String DiaChi;
    Scanner sc=new Scanner(System.in);

    public NGUOI(){}
    public NGUOI(String id, String HoTen, int Tuoi, String GioiTinh, String SDT, String DiaChi) {
        this.id=id;
        this.HoTen=HoTen;
        this.Tuoi=Tuoi;
        this.GioiTinh=GioiTinh;
        this.SDT=SDT;
        this.DiaChi=DiaChi;
    }
    public NGUOI(NGUOI ng){
        this.id=ng.id;
        this.HoTen=ng.HoTen;
        this.Tuoi=ng.Tuoi;
        this.GioiTinh=ng.GioiTinh;
        this.SDT=ng.SDT;
        this.DiaChi=ng.DiaChi;
    }
    public String getId() {
        return id;
    }
    public String getHoTen() {
        return HoTen;
    }
    public int getTuoi() {
        return Tuoi;
    }
    public String getGioiTinh() {
        return GioiTinh;
    }
    public String getSDT() {
        return SDT;
    }
    public void setId(String id){
        String regex = "^(BN|BS|QL)\\d{3}$";
        if (id.matches(regex)) {
            this.id = id;  
        }
        else
            throw new IllegalArgumentException("Ma khong hop le");
    }
    
    public static String capitalizeWords(String input) {
        String[] words = input.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }

        return result.toString().trim();
    }

    public static boolean isValidName(String name) {
        String regex = "^[a-zA-Z\\s]{1,128}$";
        return name.matches(regex);
    }
    public void setHoTen(String HoTen) {
        if (isValidName(HoTen)) {
            capitalizeWords(HoTen);
            this.HoTen=HoTen;
        }
        else throw new IllegalArgumentException("Ho ten khong duoc chua cac ky tu dac biet");
    }
    
    public void setTuoi(int Tuoi) {
        if (Tuoi<0 ||Tuoi >130) {
            throw new IllegalArgumentException("Tuoi khong hop le");
        }
        this.Tuoi=Tuoi;
    }
    
    public void setGioiTinh(String GioiTinh) {
        if (GioiTinh.matches("^(Nam|Nu|nam|nu)$")){
            this.GioiTinh=GioiTinh;
        }
        else  throw new IllegalArgumentException("Gioi tinh khong hop le");
    }
    
    public void setSDT(String SDT) {
        if (SDT.matches("^(0\\d{9}|[1-9]\\d{8})$")) {
            this.SDT = SDT;
        }
        else  throw new IllegalArgumentException("So dien thoai khong hop le. Nhap 10 chu so bat dau bang 0 hoac 9 chu so (khong bat dau bang 0).");
    }
    public String getDiaChi() {
        return DiaChi;
    }
    public void setDiaChi(String DiaChi) {
        if (DiaChi.matches("^[a-zA-Z0-9\\s,./()-]{1,256}$")) {
            this.DiaChi = DiaChi;
        }
        else  throw new IllegalArgumentException("Dia chi khong hop le");
    }

    public void Nhap(){
        boolean Isvalid;
        do{
            try{
                System.out.print("Nhap HoTen: ");
                HoTen=sc.nextLine();
                setHoTen(HoTen);
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
                System.out.print("Nhap Tuoi: ");
                Tuoi=sc.nextInt();
                sc.nextLine(); //nút enter
                setTuoi(Tuoi);
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
                System.out.print("Nhap GioiTinh: ");
                GioiTinh=sc.nextLine();
                setGioiTinh(GioiTinh);
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
                System.out.print("Nhap SDT: ");
                SDT=sc.nextLine();
                setSDT(SDT);
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
                System.out.print("Nhap DiaChi: ");
                DiaChi=sc.nextLine();
                setDiaChi(DiaChi);
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
    @Override
    public String toString(){
        return String.format("ID: %s | Ten: %s | Tuoi: %d | Gioi Tinh: %s | SDT: %s | Dia Chi: %s", id,HoTen,Tuoi,GioiTinh,SDT,DiaChi);
    }
}
