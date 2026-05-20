package list;

import java.io.*;
import java.util.*;

import Classes_2.*;
import Interface.*;

public class DSHOADON implements IQuanLy<HOADON>{
    private HOADON[] dshd;
    private int n;
    Scanner sc=new Scanner(System.in);

    public DSHOADON(){
        n=0;
        dshd=new HOADON[0];
    }
    public DSHOADON(int n, HOADON[] ds){
        this.n=n;
        dshd=new HOADON[n];
        for(int i=0;i<n;i++)
            dshd[i]=ds[i];
    }
    public int getN(){
        return HOADON.getCountHoaDon();
    }
    public HOADON[] getDshd(){
        return dshd;
    }

    public void XoaHoaDon(int index) {
        if (index < 0 || index >= n) {
            System.out.println("Index khong hop le.");
            return;
        }
        for (int i = index; i < n - 1; i++)
            dshd[i] = dshd[i + 1];
        dshd = Arrays.copyOf(dshd, n - 1);
        n--;
        HOADON.setCountHoaDon(HOADON.getCountHoaDon() - 1);
    }

    public String taomoiMaHD() {
        int maxId = 0;
        for (HOADON hd : dshd) {
            if (hd != null && hd.getMaHD().startsWith("HD")) {
                try {
                    int idNum = Integer.parseInt(hd.getMaHD().substring(2));
                    if (idNum > maxId)
                        maxId = idNum;
                } catch (NumberFormatException e) {
                }
            }
        }
        return "HD" + String.format("%03d", maxId + 1);
    }

    public void Them(HOADON hd){}
    public void Them(HOADON hd, DSTHUOC dsth){
        for(int i = 0; i < n; i++)
            if(dshd[i].getMaHD().equals(hd.getMaHD())){
                System.out.println("Ma Hoa Don da ton tai!");
                return;
            }
        dshd = Arrays.copyOf(dshd, n + 1);
        dshd[n] = new HOADON(hd);
        n++;
        if (hd.getTrangThaiThanhToan()) {
            hd.LapHoaDon(dsth);
        }
        System.out.println("Da them Hoa Don thanh cong!");
    }
    public void CapNhat(String id){}
    public void CapNhat(String id, DSTHUOC dsth){
        for(int i=0;i<n;i++){
            if(dshd[i].getMaHD().equals(id)){
                int c;
                do{

                    boolean Isvalid;

                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║             CAP NHAT HOA DON              ║");
                    System.out.println("╠═══════════════════════════════════════════╣");
                    System.out.println("║  1. Cap nhat Ma Lich kham                 ║");
                    System.out.println("║  2. Cap nhat Trang Thai Thanh Toan        ║");
                    System.out.println("║  3. Cap nhat Ngay Thanh Toan              ║");
                    System.out.println("║  0. Quay lai Menu Hoa Don                 ║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    System.out.print("Chon chuc nang (0-5): ");
                    c = sc.nextInt(); sc.nextLine();
                    switch(c){
                        case 1:
                            do{
                                Isvalid=false;
                                try{
                                    System.out.print("Nhap Ma Lich Kham can cap nhat: ");
                                    String malk = sc.nextLine();
                                    for (int y = 0; y < n; y++)
                                        if (dshd[y].getMaLK().toLowerCase().equals(malk.toLowerCase())){
                                            dshd[i].setMaLK(malk);
                                            Isvalid=true;
                                        }
                                    if(!Isvalid){
                                            System.out.println("Ma Benh Nhan khong ton tai trong DSBENHNHAN. Vui long nhap lai!");
                                            Isvalid=false;
                                    }
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin hoa don!");
                            break;
                        case 2:
                            do{
                                try{
                                    System.out.print("Nhap Trang thai thanh toan can cap nhat(1:Da thanh toan/0:Chua thanh toan): ");
                                    int tt = sc.nextInt(); sc.nextLine();
                                    boolean trangthai = (tt==1);
                                    dshd[i].setTrangThaiThanhToan(trangthai);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin hoa don!");
                            break;
                        case 3:
                            do{
                                try{
                                    System.out.print("Nhap Ngay thanh toan can cap nhat(yyyy-mm-dd): ");
                                    String ngaythanhtoan = sc.nextLine();
                                    dshd[i].setNgayThanhToan(ngaythanhtoan);
                                    Isvalid=true;
                                }
                                catch(Exception e){
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            }while(!Isvalid);
                            System.out.println("Da cap nhat thong tin hoa don!");
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
            if (dshd[i].getTrangThaiThanhToan()) {
                dshd[i].LapHoaDon(dsth);
            }
        }
        System.out.println("Khong tim thay hoa don voi ma: " + id);
    }
    public void Xoa(){
        int c, found;
        do{
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║                XOA HOA DON                ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Xoa theo Ma Hoa Don                   ║");
            System.out.println("║  2. Xoa theo Ma Lich Kham                 ║");
            System.out.println("║  3. Xoa theo Ngay Thanh Toan              ║");
            System.out.println("║  0. Quay lai Menu Hoa Don                 ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-5): ");
            c = sc.nextInt(); sc.nextLine();

            switch(c){
                case 1:
                    found=0;
                    System.out.print("Nhap Ma Hoa don can xoa: ");
                    String mahd = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dshd[i].getMaHD().toLowerCase().contains(mahd.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dshd[j]=dshd[j+1];
                            dshd=Arrays.copyOf(dshd, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay hoa don voi Ma hoa don %s de xoa", mahd);
                    else 
                        System.out.format("Da xoa hoa don voi Ma hoa don %s", mahd);
                    break;
                case 2:
                    found=0;
                    System.out.print("Nhap Ma Lich kham can xoa: ");
                    String malk = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dshd[i].getMaLK().toLowerCase().contains(malk.toLowerCase())){
                            for(int j=i;j<n-1;j++)
                                dshd[j]=dshd[j+1];
                            dshd=Arrays.copyOf(dshd, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay hoa don voi Ma lich kham %s de xoa", malk);
                    else 
                        System.out.format("Da xoa hoa don voi Ma lich kham %s", malk);
                    break;
                case 3:
                    found=0;

                    System.out.print("Nhap Ngay thanh toan can xoa(yyyy-mm-dd): ");
                    String ngaytt = sc.nextLine();
                    for(int i=0;i<n;i++)
                        if(dshd[i].getNgayThanhToan().contains(ngaytt)){
                            for(int j=i;j<n-1;j++)
                                dshd[j]=dshd[j+1];
                            dshd=Arrays.copyOf(dshd, n-1);
                            n--;
                            i--;
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay hoa don co Ngay thanh toan %s de xoa", ngaytt);
                    else 
                        System.out.format("Da xoa hoa don co Ngay thanh toan %s", ngaytt);
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
            System.out.println("║             TIM KIEM HOA DON              ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Tim Kiem theo Ma Hoa Don              ║");
            System.out.println("║  2. Tim Kiem theo Ma Lich Kham            ║");
            System.out.println("║  3. Tim Kiem theo Trang thai thanh toan   ║");
            System.out.println("║  4. Tim Kiem theo Ngay Thanh Toan         ║");
            System.out.println("║  0. Quay lai Menu Hoa Don                 ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-6): ");
            c = sc.nextInt(); sc.nextLine();

            switch(c){
                case 1:
                    found=0;
                    System.out.print("Nhap Ma Hoa don can tim: ");
                    String mahd = sc.nextLine();
                    System.out.println("==== Danh sach hoa don ====");
                    for(int i=0;i<n;i++)
                        if(dshd[i].getMaHD().toLowerCase().contains(mahd.toLowerCase())){
                            System.out.println(dshd[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay hoa don voi Ma hoa don %s", mahd);
                    break;
                case 2:
                    found=0;
                    System.out.print("Nhap Ma Lich kham can tim: ");
                    String malk = sc.nextLine();
                    System.out.println("==== Danh sach hoa don ====");
                    for(int i=0;i<n;i++)
                        if(dshd[i].getMaLK().toLowerCase().contains(malk.toLowerCase())){
                            System.out.println(dshd[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay hoa don voi Ma lich kham %s", malk);
                    break;
                case 3:
                    found=0;
                    System.out.print("Nhap Trang thai thanh toan can tim(1:Da thanh toan/0:Chua thanh toan): ");
                    int tt = sc.nextInt(); sc.nextLine();
                    System.out.println("==== Danh sach hoa don ====");
                    for(int i=0;i<n;i++)
                        if(dshd[i].getTrangThaiThanhToan() == (tt==1)){
                            System.out.println(dshd[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0){
                        if(tt==1)
                            System.out.println("Khong tim thay hoa don da thanh toan");
                        else
                            System.out.println("Khong tim thay hoa don chua thanh toan");
                    }
                    break;
                case 4:
                    found=0;

                    System.out.print("Nhap Ngay thanh toan can tim(yyyy-mm-dd): ");
                    String ngaytt = sc.nextLine();
                    System.out.println("==== Danh sach hoa don ====");
                    for(int i=0;i<n;i++)
                        if(dshd[i].getNgayThanhToan().contains(ngaytt)){
                            System.out.println(dshd[i]);
                            System.out.println("-----------------------------------------");
                            found=1;
                        }
                    if(found==0)
                        System.out.format("Khong tim thay hoa don co Ngay thanh toan %s", ngaytt);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chuc nang khong hop le! Vui long chon lai.");
                    break;
            }
        }while(c!=0);
    }
    public void XuatDS(){}
    public void XuatDS(DSTHUOC dsth, DSLICHKHAM dslk){
        int c;
        if(n==0){
            System.out.println("Danh sach Hoa Don trong!");
            return;
        }
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH HOA DON                                ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
        for (int i = 0; i < n; i++) {
            System.out.println(dshd[i].toString());
            System.out.println("────────────────────────────────────────────────────────────────────────");
        }
        System.out.println("Tong so Hoa Don: " + n);
        do {
            System.out.print("Ban muon hien thi thong tin hoa don chi tiet khong ? (1.CO|0.KHONG): ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    int found=0;
                    sc.nextLine();
                    System.out.print("Nhap MaHD ban muon hien thi: ");
                    String ma = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (dshd[i].getMaHD ().equalsIgnoreCase(ma)) {
                            dshd[i].displayInfo(dsth,dslk);
                            found=1;
                        }
                    } 
                    if(found==0)
                        System.out.format("Khong tim thay hoa don voi ma %s", ma);
                    break;
                default:
                    break;
            }
        } while (c != 0);
    }

    public void DocFile(String f){ 
        dshd=new HOADON[0];
        n=0;
        HOADON.setCountHoaDon(0);
        try (BufferedReader input = new BufferedReader(new FileReader(f))) {
        String line;
        int soLuongDongThanhCong = 0;
        
        while ((line = input.readLine()) != null) {
            String trimmedLine = line.trim();
            if (!trimmedLine.isEmpty()) {
                
                String[] arr = trimmedLine.split(",(?![^\\[]*\\])"); 
                
                if (arr.length == 8) { 
                    try {
                        
                        String maHD = arr[0].trim();
                        String maLK = arr[1].trim();

                        String maThuocStr = arr[2].replace("[", "").replace("]", "").trim();
                        List<String> DSMaThuoc = new ArrayList<>();
                        if (!maThuocStr.isEmpty()) {
                            for (String mt : maThuocStr.split(",")) {
                                DSMaThuoc.add(mt.trim());
                            }
                        }
                        
                        String soLuongStr = arr[3].replace("[", "").replace("]", "").trim();
                        List<Integer> DSSoLuongThuoc = new ArrayList<>();
                        if (!soLuongStr.isEmpty()) {
                            for (String sl : soLuongStr.split(",")) {
                                DSSoLuongThuoc.add(Integer.parseInt(sl.trim()));
                            }
                        }

                        double tienThuoc = Double.parseDouble(arr[4].trim());
                        double tongTien = Double.parseDouble(arr[5].trim());
                        boolean trangThaiThanhToan = Boolean.parseBoolean(arr[6].trim());
                        String ngayThanhToan = arr[7].trim();
                        
                        HOADON hd = new HOADON(maHD, maLK, DSMaThuoc, DSSoLuongThuoc, tienThuoc, tongTien, trangThaiThanhToan, ngayThanhToan);
                        dshd = Arrays.copyOf(dshd, n+1);
                        dshd[n]=hd;
                        n++;
                        soLuongDongThanhCong++;
                        
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.err.println("Loi: dinh dang so/boolean/chi muc. Bo qua dong nay!: " + trimmedLine);
                    }
                } else
                    System.err.println("Loi: khong co du 10 truong thong tin. Bo qua dong nay " + trimmedLine);
            }
        }
        this.n = soLuongDongThanhCong;          
        if (this.n > 0)
            System.out.println("Doc du lieu thanh cong! Tong so Hoa Don: " + this.n);
        else
            System.out.println("Khong co du lieu hop le nao duoc doc tu file.");         
        } catch (FileNotFoundException e) {
            System.err.println("Loi: File " + f + " khong ton tai.");
            this.dshd = new HOADON[0];
            this.n = 0;
        } catch (IOException e) {
            System.err.println("Loi doc file: " + e.getMessage());
        }
    }
    public void GhiFile(String f){
        try{
            FileWriter fw=new FileWriter(f);
            for (int i = 0; i < n; i++) {
                fw.write(dshd[i].toFileString());
                fw.write("\n");
            }
            fw.close();
            System.out.println("Da luu " + n + " Hoa Don vao file.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
}
