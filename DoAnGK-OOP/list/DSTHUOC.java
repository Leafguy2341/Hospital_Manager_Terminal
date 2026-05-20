package list;

import java.io.*;
import java.util.*;

import Classes_2.*;
import Interface.*;

public class DSTHUOC implements IQuanLy<THUOC>{
    private THUOC[] dsth;
    private int n;
    Scanner sc=new Scanner(System.in);

    public DSTHUOC(){
        n=0;
        dsth=new THUOC[0];
    }
    public DSTHUOC(int n, THUOC[] ds){
        this.n=n;
        dsth=new THUOC[n];
        for(int i=0;i<n;i++)
            dsth[i]=ds[i];
    }

    public THUOC TimThuocTheoMa(String ma) {
        for (THUOC t:dsth) {
            if (t.getMaThuoc().equalsIgnoreCase(ma)) 
                return t;
        }
        return null;
    }

    public String taomoiMaTH() {
        int maxId = 0;
        for (THUOC th : dsth) {
            if (th != null && th.getMaThuoc().startsWith("TH")) {
                try {
                    int idNum = Integer.parseInt(th.getMaThuoc().substring(2));
                    if (idNum > maxId)
                        maxId = idNum;
                } catch (NumberFormatException e) {
                }
            }
        }
        return "TH" + String.format("%03d", maxId + 1);
    }

    public void Them(THUOC bs){
        for(int i =0; i < n; i++)
            if(dsth[i].getMaThuoc().equals(bs.getMaThuoc())){
                System.out.println("Ma thuoc da ton tai!");
                return;
            }
        dsth=Arrays.copyOf(dsth, n+1);
        dsth[n]=new THUOC(bs);
        n++;
        System.out.println("Da them thuoc thanh cong!");
    }
    public void CapNhat(String id){
        for(int i=0;i<n;i++){
            if(dsth[i].getMaThuoc().equals(id)){
                int c;
                do{

                    boolean Isvalid;

                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║               CAP NHAT THUOC              ║");
                    System.out.println("╠═══════════════════════════════════════════╣");
                    System.out.println("║  1. Cap nhat Ten Thuoc                    ║");
                    System.out.println("║  2. Cap nhat Loai Thuoc                   ║");
                    System.out.println("║  3. Cap nhat Gia Thuoc                    ║");
                    System.out.println("║  4. Cap nhat So Luong                     ║");
                    System.out.println("║  5. Cap nhat Cach dung                    ║");
                    System.out.println("║  0. Quay lai Menu Thuoc                   ║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    System.out.print("Chon chuc nang (0-5): ");
                    c = sc.nextInt(); sc.nextLine();
                    switch(c){
                        case 1:
                            do{
                                try{
                                    System.out.print("Nhap Ten thuoc can cap nhat: ");
                                    String tenthuoc = sc.nextLine();
                                    dsth[i].setTenThuoc(tenthuoc);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin thuoc!");
                            break;
                        case 2:
                            do{
                                try{
                                    System.out.print("Nhap Loai thuoc can cap nhat: ");
                                    String loaithuoc = sc.nextLine();
                                    dsth[i].setLoaiThuoc(loaithuoc);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin thuoc!");
                            break;
                        case 3:
                            do{
                                try{
                                    System.out.print("Nhap Gia thuoc can cap nhat: ");
                                    double gia = sc.nextDouble(); sc.nextLine();
                                    dsth[i].setDonGia(gia);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin thuoc!");
                            break;
                        case 4:
                            do{
                                try{
                                    System.out.print("Nhap So luong can cap nhat: ");
                                    int soluong = sc.nextInt(); sc.nextLine();
                                    dsth[i].setSoLuong(soluong);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin thuoc!");
                            break;
                        case 5:
                            do{
                                try{
                                    System.out.print("Nhap Cach dung can cap nhat: ");
                                    String cachdung = sc.nextLine();
                                    dsth[i].setCachSuDung(cachdung);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin thuoc!");
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
        System.out.println("Khong tim thay thuoc voi ma: " + id);
    }
    public void Xoa(){
        int c, found;
        do{
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║                 XOA THUOC                 ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Xoa theo Ma Thuoc                     ║");
            System.out.println("║  2. Xoa theo Ten Thuoc                    ║");
            System.out.println("║  3. Xoa theo Loai Thuoc                   ║");
            System.out.println("║  4. Xoa theo Gia Thuoc                    ║");
            System.out.println("║  5. Xoa theo So Luong                     ║");
            System.out.println("║  0. Quay lai Menu Thuoc                   ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-6): ");
            c = sc.nextInt(); sc.nextLine();

            switch(c){
                case 1:
                    found=0;
                    System.out.print("Nhap Ma Thuoc can xoa: ");
                    String math = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsth[i].getMaThuoc().toLowerCase().contains(math.toLowerCase())){
                            for(int j = i; j < n-1;j++)
                                dsth[j] = dsth[j+1];
                            dsth=Arrays.copyOf(dsth, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay thuoc voi ma thuoc %s de xoa", math);
                    else 
                        System.out.format("Da xoa thuoc voi ma thuoc %s", math);
                    break;
                case 2:
                    found=0;
                    System.out.print("Nhap Ten thuoc can xoa: ");
                    String tenth = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsth[i].getTenThuoc().toLowerCase().contains(tenth.toLowerCase())){
                            for(int j = i; j < n-1;j++)
                                dsth[j] = dsth[j+1];
                            dsth=Arrays.copyOf(dsth, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay thuoc voi ten thuoc %s de xoa", tenth);
                    else 
                        System.out.format("Da xoa thuoc voi ten thuoc %s", tenth);
                    break;
                case 3:
                    found=0;
                    System.out.print("Nhap Loai thuoc can xoa: ");
                    String loaith = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dsth[i].getLoaiThuoc().toLowerCase().contains(loaith.toLowerCase())){
                            for(int j = i; j < n-1;j++)
                                dsth[j] = dsth[j+1];
                            dsth=Arrays.copyOf(dsth, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay thuoc voi loai thuoc %s de xoa", loaith);
                    else 
                        System.out.format("Da xoa thuoc voi loai thuoc %s", loaith);
                    break;
                case 4:
                    found=0;
                    System.out.print("Nhap Gia thuoc can xoa: ");
                    double giath = sc.nextInt(); sc.nextLine();
                    System.out.print("Chon tieu chi xoa(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    if(tieuchi.equals("lon")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getDonGia()>giath){
                                for(int j = i; j < n-1;j++)
                                    dsth[j] = dsth[j+1];
                                dsth=Arrays.copyOf(dsth, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co gia thuoc lon hon %d de xoa", giath);
                        else 
                            System.out.format("Da xoa thuoc co gia thuoc lon hon %d", giath);
                    }
                    else if(tieuchi.equals("be")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getDonGia()<giath){
                                for(int j = i; j < n-1;j++)
                                    dsth[j] = dsth[j+1];
                                dsth=Arrays.copyOf(dsth, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co gia thuoc be hon %d de xoa", giath);
                        else
                            System.out.format("Da xoa thuoc co gia thuoc be hon %d", giath);
                    }
                    else if(tieuchi.equals("bang")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getDonGia()==giath){
                                for(int j = i; j < n-1;j++)
                                    dsth[j] = dsth[j+1];
                                dsth=Arrays.copyOf(dsth, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co gia thuoc bang %d de xoa", giath);
                        else 
                            System.out.format("Da xoa thuoc co gia thuoc bang %d", giath);
                    }
                    else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 5:
                    found=0;
                    System.out.print("Nhap So luong can xoa: ");
                    int soluong = sc.nextInt(); sc.nextLine();
                    System.out.print("Chon tieu chi xoa(lon|be|bang): ");
                    String tieuchi2 = sc.nextLine();
                    if(tieuchi2.equals("lon")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getSoLuong()>soluong){
                                for(int j = i; j < n-1;j++)
                                    dsth[j] = dsth[j+1];
                                dsth=Arrays.copyOf(dsth, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co so luong lon hon %d de xoa", soluong);
                        else
                            System.out.format("Da xoa thuoc co so luong lon hon %d", soluong);
                    }
                    else if(tieuchi2.equals("be")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getSoLuong()<soluong){
                                for(int j = i; j < n-1;j++)
                                    dsth[j] = dsth[j+1];
                                dsth=Arrays.copyOf(dsth, n-1);
                                n--;
                                i--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co so luong be hon %d de xoa", soluong);
                        else 
                            System.out.format("Da xoa thuoc co so luong be hon %d", soluong);
                    }
                    else if(tieuchi2.equals("bang")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getSoLuong()==soluong){
                                for(int j = i; j < n-1;j++)
                                    dsth[j] = dsth[j+1];
                                dsth=Arrays.copyOf(dsth, n-1);
                                n--;
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co so luong bang %d de xoa", soluong);
                        else 
                            System.out.format("Da xoa thuoc co so luong bang %d", soluong);
                    }
                    else
                        System.out.println("Nhap sai tieu chi!");
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
            System.out.println("║              TIM KIEM THUOC               ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Tim Kiem theo Ma Thuoc                ║");
            System.out.println("║  2. Tim Kiem theo Ten Thuoc               ║");
            System.out.println("║  3. Tim Kiem theo Loai Thuoc              ║");
            System.out.println("║  4. Tim Kiem theo Gia Thuoc               ║");
            System.out.println("║  5. Tim Kiem theo So Luong                ║");
            System.out.println("║  6. Tim Kiem theo Cach Dung               ║");
            System.out.println("║  0. Quay lai Menu Thuoc                   ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-6): ");
            c = sc.nextInt(); sc.nextLine();

            switch(c){
                case 1:
                    found=0;
                    System.out.print("Nhap Ma Thuoc can tim: ");
                    String math = sc.nextLine();
                    System.out.println("==== Danh sach thuoc ====");
                    for(int i=0;i<n;i++)
                        if(dsth[i].getMaThuoc().toLowerCase().contains(math.toLowerCase())){
                            System.out.println(dsth[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay thuoc voi ma thuoc %s", math);
                    break;
                case 2:
                    found=0;
                    System.out.print("Nhap Ten thuoc can tim: ");
                    String tenth = sc.nextLine();
                    System.out.println("==== Danh sach thuoc ====");
                    for(int i=0;i<n;i++)
                        if(dsth[i].getTenThuoc().toLowerCase().contains(tenth.toLowerCase())){
                            System.out.println(dsth[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay thuoc voi ten thuoc %s", tenth);
                    break;
                case 3:
                    found=0;
                    System.out.print("Nhap Loai thuoc can tim: ");
                    String loaith = sc.nextLine();
                    System.out.println("==== Danh sach thuoc ====");
                    for(int i=0;i<n;i++)
                        if(dsth[i].getLoaiThuoc().toLowerCase().contains(loaith.toLowerCase())){
                            System.out.println(dsth[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay thuoc voi loai thuoc %s", loaith);
                    break;
                case 4:
                    found=0;
                    System.out.print("Nhap Gia thuoc can tim: ");
                    double giath = sc.nextInt(); sc.nextLine();
                    System.out.print("Chon tieu chi tim kiem(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    System.out.println("==== Danh sach thuoc ====");
                    if(tieuchi.equals("lon")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getDonGia()>giath){
                                System.out.println(dsth[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co gia thuoc lon hon %d", giath);
                    }
                    else if(tieuchi.equals("be")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getDonGia()<giath){
                                System.out.println(dsth[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co gia thuoc be hon %d", giath);
                    }
                    else if(tieuchi.equals("bang")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getDonGia()==giath){
                                System.out.println(dsth[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co gia thuoc bang %d", giath);
                    }
                    else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 5:
                    found=0;
                    System.out.print("Nhap So luong can tim: ");
                    int soluong = sc.nextInt(); sc.nextLine();
                    System.out.print("Chon tieu chi tim kiem(lon|be|bang): ");
                    String tieuchi2 = sc.nextLine();
                    System.out.println("==== Danh sach thuoc ====");
                    if(tieuchi2.equals("lon")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getSoLuong()>soluong){
                                System.out.println(dsth[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co so luong lon hon %d", soluong);
                    }
                    else if(tieuchi2.equals("be")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getSoLuong()<soluong){
                                System.out.println(dsth[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co so luong be hon %d", soluong);
                    }
                    else if(tieuchi2.equals("bang")){
                        for(int i=0;i<n;i++)
                            if(dsth[i].getSoLuong()==soluong){
                                System.out.println(dsth[i]);
                                System.out.println("-----------------------------------------");
                                found=1;
                            }
                        if(found==0)
                            System.out.format("Khong tim thay thuoc co so luong bang %d", soluong);
                    }
                    else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 6:
                    found=0;
                    System.out.print("Nhap Cach dung can tim: ");
                    String cd = sc.nextLine();
                    System.out.println("==== Danh sach thuoc ====");
                    for(int i=0;i<n;i++)
                        if(dsth[i].getCachSuDung().contains(cd)){
                            System.out.println(dsth[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0){
                        System.out.println("Khong tim thay thuoc voi cach dung " + cd);
                    }
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
            System.out.println("Danh sach thuoc trong!");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH THUOC                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        for (int i = 0; i < n; i++) {
            System.out.println(dsth[i].toString());
            System.out.println("────────────────────────────────────────────────────────────────────────");
        }
        System.out.println("Tong so thuoc: " + n);
        do {
            System.out.print("Ban muon hien thi thong tin thuoc chi tiet khong ? (1.CO|0.KHONG): ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    int found=0;
                    sc.nextLine();
                    System.out.print("Nhap MaTH ban muon hien thi: ");
                    String ma = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (dsth[i].getMaThuoc().equalsIgnoreCase(ma)) {
                            dsth[i].displayInfo();
                            found=1;
                        }
                    } 
                    if(found==0)
                        System.out.format("Khong tim thay thuoc voi ma %s", ma);
                    break;
                default:
                    break;
            }
        } while (c != 0);
    }

    public void DocFile(String f){
        try{
            dsth=new THUOC[0];
            n=0;
            THUOC.setCountThuoc(0);

            BufferedReader input=new BufferedReader(new FileReader(f));
            String line;
            while((line = input.readLine()) != null){
                if(!line.trim().isEmpty()){
                    String[] arr=line.split(",");
                    if(arr.length>=6){
                        try{
                            THUOC bs=new THUOC(arr[0].trim(),arr[1].trim(),arr[2].trim(),Double.parseDouble(arr[3].trim()),Integer.parseInt(arr[4].trim()),arr[5].trim());
                            dsth = Arrays.copyOf(dsth, n+1);
                            dsth[n]=bs;
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
                System.out.println("Doc du lieu thanh cong! Tong so thuoc: " + n);
            else
                System.out.println("Khong co du lieu hop le nao duoc doc tu file.");
        }catch (FileNotFoundException e) {
            System.out.println("File " + f + " chua ton tai. Se tao moi khi luu.");
            dsth = new THUOC[0];
            n = 0;
        }catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
    public void GhiFile(String f){
        try{
            FileWriter fw=new FileWriter(f);
            for (int i = 0; i < n; i++) {
                fw.write(dsth[i].toFileString());
                fw.write("\n");
            }
            fw.close();
            System.out.println("Da luu " + n + " thuoc vao file.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
}
