package list;

import java.io.*;
import java.util.*;

import Classes_2.*;
import Interface.*;

public class DSBENHNHAN implements IQuanLy<BENHNHAN>{
    private BENHNHAN[] dsbn;
    private int n;
    Scanner sc=new Scanner(System.in);

    public DSBENHNHAN(){
        n=0;
        dsbn=new BENHNHAN[0];
    }
    public DSBENHNHAN(int n, BENHNHAN[] ds){
        this.n=n;
        dsbn=new BENHNHAN[n];
        for(int i=0;i<n;i++)
            dsbn[i]=ds[i];
    }

    public String taomoiMaBN() {
        int maxId = 0;
        for (BENHNHAN bn : dsbn) {
            if (bn != null && bn.getId().startsWith("BN")) {
                try {
                    int idNum = Integer.parseInt(bn.getId().substring(2));
                    if (idNum > maxId)
                        maxId = idNum;
                } catch (NumberFormatException e) {
                }
            }
        }
        return "BN" + String.format("%03d", maxId + 1);
    }

    public void Them(BENHNHAN bn) {}
    public void Them(BENHNHAN bn, DSTAIKHOAN dstk){
        dsbn=Arrays.copyOf(dsbn, n+1);
        dsbn[n]=new BENHNHAN(bn);
        n++;
        System.out.println("Da them benh nhan thanh cong!");
        TAIKHOAN tk = new TAIKHOAN(bn.getId(),"123456");
        dstk.Them(tk);
        System.out.println("Da tao tai khoan cho benh nhan voi ID: " + tk.getId() + " va mat khau mac dinh: 123456");
    }
    public void CapNhat(String id){
        for(int i=0;i<n;i++){
            if(dsbn[i].getId().equals(id)){
                System.out.println("Da tim thay benh nhan voi ma " + id);
                int c;
                do{

                    boolean Isvalid;

                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║             CAP NHAT BENH NHAN            ║");
                    System.out.println("╠═══════════════════════════════════════════╣");
                    System.out.println("║  1. Cap nhat Ho ten                       ║");
                    System.out.println("║  2. Cap nhat Tuoi                         ║");
                    System.out.println("║  3. Cap nhat Gioi Tinh                    ║");
                    System.out.println("║  4. Cap nhat SDT                          ║");
                    System.out.println("║  5. Cap nhat Dia Chi                      ║");
                    System.out.println("║  6. Cap nhat Tien Su Benh                 ║");
                    System.out.println("║  7. Cap nhat Nhom Mau                     ║");
                    System.out.println("║  8. Cap nhat Di Ung                       ║");
                    System.out.println("║  0. Quay lai Menu Benh Nhan               ║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    System.out.print("Chon chuc nang (0-8): ");
                    c = sc.nextInt();
                    switch(c){
                        case 1:
                            do{
                                try{
                                    System.out.print("Nhap Ho Ten can cap nhat: ");
                                    String hoten = sc.nextLine();
                                    dsbn[i].setHoTen(hoten);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 2:
                            do{
                                try{
                                    System.out.print("Nhap Tuoi can cap nhat: ");
                                    int tuoi = sc.nextInt();
                                    dsbn[i].setTuoi(tuoi);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 3:
                            do{
                                try{
                                    System.out.print("Nhap Gioi Tinh can cap nhat: ");
                                    String gioitinh = sc.nextLine();
                                    dsbn[i].setGioiTinh(gioitinh);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 4:
                            do{
                                try{
                                    System.out.print("Nhap SDT can cap nhat: ");
                                    String sdt = sc.nextLine();
                                    dsbn[i].setSDT(sdt);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 5:
                            do{
                                try{
                                    System.out.print("Nhap Dia chi can cap nhat: ");
                                    String diachi = sc.nextLine();
                                    dsbn[i].setDiaChi(diachi);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 6:
                            do{
                                try{
                                    System.out.print("Nhap Tien su benh can cap nhat: ");
                                    String tiensubenh = sc.nextLine();
                                    dsbn[i].setTienSuBenh(tiensubenh);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 7:
                            do{
                                try{
                                    System.out.print("Nhap Nhom mau can cap nhat: ");
                                    String nhommau = sc.nextLine();
                                    dsbn[i].setNhomMau(nhommau);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 8:
                            do{
                                try{
                                    System.out.print("Nhap Di ung can cap nhat: ");
                                    String diung = sc.nextLine();
                                    dsbn[i].setDiUng(diung);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin benh nhan!");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Chuc Nang khong hop le! Vui long chon lai.");
                            break;
                    }
                }while(c!=0);
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan voi ma: " + id);
    }
    public void Xoa(){ 
        int c, found;
        do{
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║               XOA BENH NHAN               ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Xoa theo Ma                           ║");
            System.out.println("║  2. Xoa theo Ho ten                       ║");
            System.out.println("║  3. Xoa theo Tuoi                         ║");
            System.out.println("║  4. Xoa theo Gioi Tinh                    ║");
            System.out.println("║  5. Xoa theo SDT                          ║");
            System.out.println("║  6. Xoa theo Dia Chi                      ║");
            System.out.println("║  7. Xoa theo Tieu su benh                 ║");
            System.out.println("║  8. Xoa theo Nhom mau                     ║");
            System.out.println("║  9. Xoa theo Di ung                       ║");
            System.out.println("║  0. Quay lai Menu Benh nhan               ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-9): ");
            c = sc.nextInt(); sc.nextLine();

            switch(c){
                case 1:
                    found=0;
                    System.out.print("Nhap Ma can xoa: ");
                    String ma = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getId().toLowerCase().contains(ma.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi ma %s de xoa", ma);
                    else
                        System.out.format("Da xoa benh nhan voi ma %s", ma);
                    break;
                case 2:
                    found=0;
                    System.out.print("Nhap Ho ten can xoa: ");
                    String hoten = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getHoTen().toLowerCase().contains(hoten.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi ho ten %s de xoa", hoten);
                    else
                        System.out.format("Da xoa benh nhan voi ho ten %s", hoten);
                    break;
                case 3:
                    found=0;
                    System.out.print("Nhap Tuoi can xoa: ");
                    int tuoi = sc.nextInt(); sc.nextLine();
                    System.out.print("Chon tieu chi xoa(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    if(tieuchi.equals("lon")){
                        for(int i=0;i<n;i++)
                            if(dsbn[i].getTuoi()>tuoi){
                                for(int j=i;j<n-1;j++)
                                    dsbn[j]=dsbn[j+1];
                                dsbn=Arrays.copyOf(dsbn, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay benh nhan voi do tuoi lon hon %d de xoa", tuoi);
                        else
                            System.out.format("Da xoa benh nhan voi do tuoi lon hon %d", tuoi);
                    }
                    else if(tieuchi.equals("be")){
                        for(int i=0;i<n;i++)
                            if(dsbn[i].getTuoi()<tuoi){
                                for(int j=i;j<n-1;j++)
                                    dsbn[j]=dsbn[j+1];
                                dsbn=Arrays.copyOf(dsbn, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay benh nhan voi do tuoi be hon %d de xoa", tuoi);
                        else
                            System.out.format("Da xoa benh nhan voi do tuoi be hon %d", tuoi);
                    }
                    else if(tieuchi.equals("bang")){
                        for(int i=0;i<n;i++)
                            if(dsbn[i].getTuoi()==tuoi){
                                for(int j=i;j<n-1;j++)
                                    dsbn[j]=dsbn[j+1];
                                dsbn=Arrays.copyOf(dsbn, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay benh nhan voi do tuoi bang %d de xoa", tuoi);
                        else
                            System.out.format("Da xoa benh nhan voi do tuoi bang %d", tuoi);
                    }
                    else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 4:
                    found=0;
                    System.out.print("Nhap Gioi tinh can xoa(Nam/Nu): ");
                    String gioitinh = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getGioiTinh().equalsIgnoreCase(gioitinh)){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi gioi tinh %s de xoa", gioitinh);
                    else
                        System.out.format("Da xoa benh nhan voi gioi tinh %s", gioitinh);
                    break;
                case 5:
                    found=0;
                    System.out.print("Nhap SDT can xoa: ");
                    String sdt = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getSDT().equalsIgnoreCase(sdt)){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi sdt %s de xoa", sdt);
                    else
                        System.out.format("Da xoa benh nhan voi sdt %s", sdt);
                    break;
                case 6:
                    found=0;
                    System.out.print("Nhap Dia chi can xoa: ");
                    String diachi = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getDiaChi().toLowerCase().contains(diachi.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi dia chi %s de xoa", diachi);
                    else
                        System.out.format("Da xoa benh nhan voi dia chi %s", diachi);
                    break;
                case 7:
                    found=0;
                    System.out.print("Nhap Tien Su benh can xoa: ");
                    String tiensubenh = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getTienSuBenh().toLowerCase().contains(tiensubenh.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan co Tien su benh %s de xoa", tiensubenh);
                    else
                        System.out.format("Da xoa benh nhan co Tien su benh %s", tiensubenh);
                    break;
                case 8:
                    found=0;
                    System.out.print("Nhap Nhom mau can xoa(A|B|O|AB): ");
                    String nhommau = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getNhomMau().toLowerCase().equals(nhommau.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan co nhom mau %s de xoa", nhommau);
                    else
                        System.out.format("Da xoa benh nhan co nhom mau %s", nhommau);
                    break;
                case 9:
                    found=0;
                    System.out.print("Nhap Di ung can xoa: ");
                    String diung = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getDiUng().toLowerCase().contains(diung.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dsbn[j]=dsbn[j+1];
                            dsbn=Arrays.copyOf(dsbn, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan co di ung voi %s de xoa", diung);
                    else
                        System.out.format("Da xoa benh nhan co di ung voi %s", diung);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chuc nang khong hop le! Vui long chon lai.");
                    break;
            }
        }while(c!=0);
    }
    
    public void TimKiem(){
        int c, found;
        do{
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║             TIM KIEM BENH NHAN            ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Tim Kiem theo Ma                      ║");
            System.out.println("║  2. Tim Kiem theo Ho ten                  ║");
            System.out.println("║  3. Tim Kiem theo Tuoi                    ║");
            System.out.println("║  4. Tim Kiem theo Gioi Tinh               ║");
            System.out.println("║  5. Tim Kiem theo SDT                     ║");
            System.out.println("║  6. Tim Kiem theo Dia Chi                 ║");
            System.out.println("║  7. Tim Kiem theo Tieu su benh            ║");
            System.out.println("║  8. Tim Kiem theo Nhom mau                ║");
            System.out.println("║  9. Tim Kiem theo Di ung                  ║");
            System.out.println("║  0. Quay lai Menu Benh nhan               ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-9): ");
            c = sc.nextInt(); sc.nextLine();

            switch(c){
                case 1:
                    found=0;
                    System.out.print("Nhap Ma can tim: ");
                    String ma = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getId().toLowerCase().contains(ma.toLowerCase())){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi ma %s", ma);
                    break;
                case 2:
                    found=0;
                    System.out.print("Nhap Ho ten can tim: ");
                    String hoten = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getHoTen().toLowerCase().contains(hoten.toLowerCase())){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi ho ten %s", hoten);
                    break;
                case 3:
                    found=0;
                    System.out.print("Nhap Tuoi can tim: ");
                    int tuoi = sc.nextInt(); sc.nextLine();
                    System.out.print("Chon tieu chi tim kiem(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    if(tieuchi.equals("lon")){
                        for(int i=0;i<n;i++)
                            if(dsbn[i].getTuoi()>tuoi){
                                System.out.println(dsbn[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay benh nhan voi do tuoi lon hon %d", tuoi);
                    }
                    else if(tieuchi.equals("be")){
                        for(int i=0;i<n;i++)
                            if(dsbn[i].getTuoi()<tuoi){
                                System.out.println(dsbn[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay benh nhan voi do tuoi be hon %d", tuoi);
                    }
                    else if(tieuchi.equals("bang")){
                        for(int i=0;i<n;i++)
                            if(dsbn[i].getTuoi()==tuoi){
                                System.out.println(dsbn[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay benh nhan voi do tuoi bang %d", tuoi);
                    }
                    else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 4:
                    found=0;
                    System.out.print("Nhap Gioi tinh can tim(Nam/Nu): ");
                    String gioitinh = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getGioiTinh().equalsIgnoreCase(gioitinh)){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                        
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi gioi tinh %s", gioitinh);
                    break;
                case 5:
                    found=0;
                    System.out.print("Nhap SDT can tim: ");
                    String sdt = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getSDT().equalsIgnoreCase(sdt)){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi sdt %s", sdt);
                    break;
                case 6:
                    found=0;
                    System.out.print("Nhap Dia chi can tim: ");
                    String diachi = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getDiaChi().toLowerCase().contains(diachi.toLowerCase())){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi dia chi %s", diachi);
                    break;
                case 7:
                    found=0;
                    System.out.print("Nhap Tien Su benh can tim: ");
                    String tiensubenh = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getTienSuBenh().toLowerCase().contains(tiensubenh.toLowerCase())){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan co Tien su benh %s", tiensubenh);
                    break;
                case 8:
                    found=0;
                    System.out.print("Nhap Nhom mau can tim(A|B|O|AB): ");
                    String nhommau = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getNhomMau().toLowerCase().equals(nhommau.toLowerCase())){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan co nhom mau %s", nhommau);
                    break;
                case 9:
                    found=0;
                    System.out.print("Nhap Di ung can tim: ");
                    String diung = sc.nextLine();
                    System.out.println("==== Danh sach benh nhan ====");
                    for(int i=0;i<n;i++)
                        if(dsbn[i].getDiUng().toLowerCase().contains(diung.toLowerCase())){
                            System.out.println(dsbn[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan co di ung voi %s", diung);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chuc nang khong hop le! Vui long chon lai.");
                    break;
            }
        }while(c!=0);
    }
    public void XuatDS(){
        int c;
        if(n==0){
            System.out.println("Danh sach benh nhan trong!");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH BENH NHAN                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        for (int i = 0; i < n; i++) {
            System.out.println(dsbn[i].toString());
            System.out.println("────────────────────────────────────────────────────────────────────────");
        }
        System.out.println("Tong so benh nhan: " + n);
        do {
            System.out.print("Ban muon hien thi thong tin benh nhan chi tiet khong ? (1.CO|0.KHONG): ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    int found=0;
                    sc.nextLine();
                    System.out.print("Nhap MaBN ban muon hien thi: ");
                    String ma = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (dsbn[i].getId().equalsIgnoreCase(ma)) {
                            dsbn[i].displayInfo();
                            found=1;
                        }
                    } 
                    if(found==0)
                        System.out.format("Khong tim thay benh nhan voi ma %s", ma);
                    break;
                default:
                    break;
            }
        } while (c != 0);
    }
    public BENHNHAN TimKiemTheoMa(String Ma) {
        for (int i = 0; i < n; i++)
            if (dsbn[i].getId().toLowerCase().contains(Ma.toLowerCase()))
                return dsbn[i];
        return null;
    }
    
    public void DocFile(String f){
        try{
            dsbn=new BENHNHAN[0];
            n=0;
            BENHNHAN.setCountBenhNhan(0);

            BufferedReader input=new BufferedReader(new FileReader(f));
            String line;
            while((line = input.readLine()) != null){
                if(!line.trim().isEmpty()){
                    String[] arr=line.split(",");
                    if(arr.length>=9){
                        try{
                            BENHNHAN bs=new BENHNHAN(arr[0].trim(),arr[1].trim(),Integer.parseInt(arr[2].trim()),arr[3].trim(), arr[4].trim(),arr[5].trim(),arr[6].trim(),arr[7].trim(),arr[8].trim());
                            dsbn = Arrays.copyOf(dsbn, n+1);
                            dsbn[n]=bs;
                            n++;
                        }catch (NumberFormatException e){
                            System.out.println("Bo qua dong co dinh dang sai: " + line);
                        }
                    } else {
                        System.out.println("Bo qua dong khong du thong tin: " + line);
                    }
                }
            }
            input.close();
            if (n > 0)
                System.out.println("Doc du lieu thanh cong! Tong so benh nhan: " + n);
            else
                System.out.println("Khong co du lieu hop le nao duoc doc tu file.");
        }catch (FileNotFoundException e) {
            System.out.println("File " + f + " chua ton tai. Se tao moi khi luu.");
            dsbn = new BENHNHAN[0];
            n = 0;
        }catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
    public void GhiFile(String f){
        try{
            FileWriter fw=new FileWriter(f);
            for (int i = 0; i < n; i++) {
                fw.write(dsbn[i].toFileString());
                fw.write("\n");
            }
            fw.close();
            System.out.println("Da luu " + n + " benh nhan vao file.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
}
