package list;

import java.io.*;
import java.util.*;

import Classes_2.*;
import Interface.*;

public class DSLICHKHAM implements IQuanLy<LICHKHAM> {
    private LICHKHAM[] dslk;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DSLICHKHAM() {
        n = 0;
        dslk = new LICHKHAM[0];
    }

    public DSLICHKHAM(int n, LICHKHAM[] ds) {
        this.n = n;
        dslk = new LICHKHAM[n];
        for (int i = 0; i < n; i++)
            dslk[i] = ds[i];
    }

    public int getN() {
        return LICHKHAM.getCountLichKham();
    }

    public LICHKHAM[] getDslk() {
        return dslk;
    }

    public void XoaLichKham(int index) {
        if (index < 0 || index >= n) {
            System.out.println("Index khong hop le.");
            return;
        }
        for (int i = index; i < n - 1; i++)
            dslk[i] = dslk[i + 1];
        dslk = Arrays.copyOf(dslk, n - 1);
        n--;
        LICHKHAM.setCountLichKham(LICHKHAM.getCountLichKham() - 1);
    }

    public LICHKHAM TimKiemTheoMa(String Ma) {
        for (int i = 0; i < n; i++)
            if (dslk[i].getMaLK().toLowerCase().contains(Ma.toLowerCase()))
                return dslk[i];
        return null;
    }

    public String taomoiMaLK() {
        int maxId = 0;
        for (LICHKHAM lk : dslk) {
            if (lk != null && lk.getMaLK().startsWith("LK")) {
                try {
                    int idNum = Integer.parseInt(lk.getMaLK().substring(2));
                    if (idNum > maxId)
                        maxId = idNum;
                } catch (NumberFormatException e) {
                }
            }
        }
        return "LK" + String.format("%03d", maxId + 1);
    }

    public void Them(LICHKHAM lk) {
        dslk = Arrays.copyOf(dslk, n + 1);
        dslk[n] = new LICHKHAM(lk);
        n++;
        System.out.println("Da them lich kham thanh cong!");
    }

    public void CapNhat(String id) {
        for (int i = 0; i < n; i++) {
            if (dslk[i].getMaLK().equals(id)) {
                int c;
                do {

                    boolean Isvalid;

                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║             CAP NHAT LICH KHAM            ║");
                    System.out.println("╠═══════════════════════════════════════════╣");
                    System.out.println("║  1. Cap nhat Ma Benh Nhan                 ║");
                    System.out.println("║  2. Cap nhat Ma Bac Si                    ║");
                    System.out.println("║  3. Cap nhat Ma Phong Kham                ║");
                    System.out.println("║  4. Cap nhat Ngay Kham                    ║");
                    System.out.println("║  5. Cap nhat Gio Kham                     ║");
                    System.out.println("║  6. Cap nhat Trang thai                   ║");
                    System.out.println("║  7. Cap nhat Chan Doan                    ║");
                    System.out.println("║  0. Quay lai Menu Lich Kham               ║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    System.out.print("Chon chuc nang (0-7): ");
                    c = sc.nextInt();
                    sc.nextLine();
                    switch (c) {
                        case 1:
                            do {
                                Isvalid = false;
                                try {
                                    System.out.print("Nhap Ma benh nhan can cap nhat: ");
                                    String mabn = sc.nextLine();
                                    for (int y = 0; y < n; y++)
                                        if (dslk[y].getMaBN().toLowerCase().equals(mabn.toLowerCase())){
                                            dslk[i].setMaBN(mabn);
                                            Isvalid = true;
                                        }
                                    if(!Isvalid){
                                            System.out.println("Ma Benh Nhan khong ton tai trong DSBENHNHAN. Vui long nhap lai!");
                                            Isvalid=false;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin lich kham!");
                            break;
                        case 2:
                            do {
                                Isvalid=false;
                                try {
                                    System.out.print("Nhap Ma bac si can cap nhat: ");
                                    String mabs = sc.nextLine();
                                    for (int y = 0; y < n; y++)
                                        if (dslk[y].getMaBS().toLowerCase().equals(mabs.toLowerCase())){
                                            dslk[i].setMaBS(mabs);
                                            Isvalid = true;
                                        }
                                    if(!Isvalid){
                                            System.out.println("Ma Benh Nhan khong ton tai trong DSBENHNHAN. Vui long nhap lai!");
                                            Isvalid=false;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin lich kham!");
                            break;
                        case 3:
                            do {
                                Isvalid =false;
                                try {
                                    System.out.print("Nhap Ma phong kham can cap nhat: ");
                                    String maphongkham = sc.nextLine();
                                    for (int y = 0; y < n; y++)
                                        if (dslk[y].getMaPK().toLowerCase().equals(maphongkham.toLowerCase())){
                                            dslk[i].setMaPK(maphongkham);
                                            Isvalid = true;
                                        }
                                    if(!Isvalid){
                                            System.out.println("Ma Benh Nhan khong ton tai trong DSBENHNHAN. Vui long nhap lai!");
                                            Isvalid=false;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin lich kham!");
                            break;
                        case 4:
                            do {
                                try {
                                    System.out.print("Nhap Ngay kham can cap nhat(yyyy-mm-dd): ");
                                    String ngaykham = sc.nextLine();
                                    dslk[i].setNgayKham(ngaykham);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin lich kham!");
                            break;
                        case 5:
                            do {
                                try {
                                    System.out.print("Nhap Gio kham can cap nhat(00:00-23:59): ");
                                    String giokham = sc.nextLine();
                                    dslk[i].setGioKham(giokham);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin lich kham!");
                            break;
                        case 6:
                            do {
                                try {
                                    System.out.print("Nhap Trang thai can cap nhat(1:Hoan thanh/0:Chua hoan thanh): ");
                                    int tt = sc.nextInt();
                                    sc.nextLine();
                                    boolean trangthai = (tt == 1);
                                    dslk[i].setTrangThai(trangthai);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin lich kham!");
                            break;
                        case 7:
                            do {
                                try {
                                    System.out.print("Nhap Chan doan can cap nhat: ");
                                    String chandoan = sc.nextLine();
                                    dslk[i].setChanDoan(chandoan);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin lich kham!");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Chuc Nang khong hop le! Vui long chon lai.");
                            break;
                    }
                } while (c != 0);
                return;
            }
        }
        System.out.println("Khong tim thay lich kham voi ma: " + id);
    }

    public void Xoa() {
        int c, found;
        do {
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║               XOA LICH KHAM               ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Xoa theo Ma Lich Kham                 ║");
            System.out.println("║  2. Xoa theo Ma Benh nhan                 ║");
            System.out.println("║  3. Xoa theo Ma Bac Si                    ║");
            System.out.println("║  4. Xoa theo Ma Phong Kham                ║");
            System.out.println("║  5. Xoa theo Ngay Kham                    ║");
            System.out.println("║  6. Xoa theo Gio kham                     ║");
            System.out.println("║  7. Xoa theo Chan Doan                    ║");
            System.out.println("║  0. Quay lai Menu Lich Kham               ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-8): ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    found = 0;
                    System.out.print("Nhap Ma Lich Kham can xoa: ");
                    String malk = sc.nextLine();
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaLK().toLowerCase().contains(malk.toLowerCase())) {
                            for (int j = i; j < n - 1; j++)
                                dslk[j] = dslk[j + 1];
                            dslk = Arrays.copyOf(dslk, n - 1);
                            n--;
                            i--;
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma lich kham %s de xoa", malk);
                    else
                        System.out.format("Da xoa lich kham voi ma lich kham %s", malk);
                    break;
                case 2:
                    found = 0;
                    System.out.print("Nhap Ma Benh nhan can xoa: ");
                    String mabn = sc.nextLine();
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaBN().toLowerCase().contains(mabn.toLowerCase())) {
                            for (int j = i; j < n - 1; j++)
                                dslk[j] = dslk[j + 1];
                            dslk = Arrays.copyOf(dslk, n - 1);
                            n--;
                            i--;
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma benh nhan %s de xoa", mabn);
                    else
                        System.out.format("Da xoa lich kham voi ma benh nhan %s", mabn);
                    break;
                case 3:
                    found = 0;
                    System.out.print("Nhap Ma Bac si can xoa: ");
                    String mabs = sc.nextLine();
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaBS().toLowerCase().contains(mabs.toLowerCase())) {
                            for (int j = i; j < n - 1; j++)
                                dslk[j] = dslk[j + 1];
                            dslk = Arrays.copyOf(dslk, n - 1);
                            n--;
                            i--;
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma bac si %s de xoa", mabs);
                    else
                        System.out.format("Da xoa lich kham voi ma bac si %s", mabs);
                    break;
                case 4:
                    found = 0;
                    System.out.print("Nhap Ma Phong Kham can xoa: ");
                    String mapk = sc.nextLine();
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaPK().toLowerCase().contains(mapk.toLowerCase())) {
                            for (int j = i; j < n - 1; j++)
                                dslk[j] = dslk[j + 1];
                            dslk = Arrays.copyOf(dslk, n - 1);
                            n--;
                            i--;
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma phong kham %s de xoa", mapk);
                    else
                        System.out.format("Da xoa lich kham voi ma phong kham %s", mapk);
                    break;
                case 5:
                    found = 0;
                    System.out.print("Nhap Ngay kham can xoa(yyyy-mm-dd): ");
                    String ngaykham = sc.nextLine();
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getNgayKham().contains(ngaykham)) {
                            for (int j = i; j < n - 1; j++)
                                dslk[j] = dslk[j + 1];
                            dslk = Arrays.copyOf(dslk, n - 1);
                            n--;
                            i--;
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ngay kham %s de xoa", ngaykham);
                    else
                        System.out.format("Da xoa lich kham voi ngay kham %s", ngaykham);
                    break;
                case 6:
                    found = 0;
                    System.out.print("Nhap Gio kham can xoa: ");
                    String giokham = sc.nextLine();
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getGioKham().contains(giokham)) {
                            for (int j = i; j < n - 1; j++)
                                dslk[j] = dslk[j + 1];
                            dslk = Arrays.copyOf(dslk, n - 1);
                            n--;
                            i--;
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi gio kham %s de xoa", giokham);
                    else
                        System.out.format("Da xoa lich kham voi gio kham %s", giokham);
                    break;
                case 7:
                    found = 0;
                    System.out.print("Nhap Chan doan can xoa: ");
                    String chandoan = sc.nextLine();
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getChanDoan().toLowerCase().contains(chandoan.toLowerCase())) {
                            for (int j = i; j < n - 1; j++)
                                dslk[j] = dslk[j + 1];
                            dslk = Arrays.copyOf(dslk, n - 1);
                            n--;
                            i--;
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham co chan doan %s de xoa", chandoan);
                    else
                        System.out.format("Da xoa lich kham co chan doan %s", chandoan);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chuc nang khong hop le! Vui long chon lai.");
                    break;
            }
        } while (c != 0);
    }

    public void TimKiem() {
        int c, found;
        do {
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║             TIM KIEM LICH KHAM            ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Tim Kiem theo Ma Lich Kham            ║");
            System.out.println("║  2. Tim Kiem theo Ma Benh nhan            ║");
            System.out.println("║  3. Tim Kiem theo Ma Bac Si               ║");
            System.out.println("║  4. Tim Kiem theo Ma Phong Kham           ║");
            System.out.println("║  5. Tim Kiem theo Ngay Kham               ║");
            System.out.println("║  6. Tim Kiem theo Gio kham                ║");
            System.out.println("║  7. Tim Kiem theo Trang thai              ║");
            System.out.println("║  8. Tim Kiem theo Chan Doan               ║");
            System.out.println("║  0. Quay lai Menu Lich Kham               ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-8): ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    found = 0;
                    System.out.print("Nhap Ma Lich Kham can tim: ");
                    String malk = sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaLK().toLowerCase().contains(malk.toLowerCase())) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma lich kham %s", malk);
                    break;
                case 2:
                    found = 0;
                    System.out.print("Nhap Ma Benh nhan can tim: ");
                    String mabn = sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaBN().toLowerCase().contains(mabn.toLowerCase())) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma benh nhan %s", mabn);
                    break;
                case 3:
                    found = 0;
                    System.out.print("Nhap Ma Bac si can tim: ");
                    String mabs = sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaBS().toLowerCase().contains(mabs.toLowerCase())) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma bac si %s", mabs);
                    break;
                case 4:
                    found = 0;
                    System.out.print("Nhap Ma Phong Kham can tim: ");
                    String mapk = sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getMaPK().toLowerCase().contains(mapk.toLowerCase())) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma phong kham %s", mapk);
                    break;
                case 5:
                    found = 0;
                    System.out.print("Nhap Ngay kham can tim(yyyy-mm-dd): ");
                    String ngaykham = sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getNgayKham().contains(ngaykham)) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ngay kham %s", ngaykham);
                    break;
                case 6:
                    found = 0;
                    System.out.print("Nhap Gio kham can tim: ");
                    String giokham = sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getGioKham().contains(giokham)) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi gio kham %s", giokham);
                    break;
                case 7:
                    found = 0;
                    System.out.print("Nhap Trang thai can tim(1:Hoan thanh/0:Chua hoan thanh): ");
                    int tt = sc.nextInt();
                    sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getTrangThai() == (tt == 1)) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0) {
                        if (tt == 1)
                            System.out.println("Khong tim thay lich kham Hoan thanh");
                        else
                            System.out.println("Khong tim thay lich kham con Chua hoan thanh");
                    }
                    break;
                case 8:
                    found = 0;
                    System.out.print("Nhap Chan doan can tim: ");
                    String chandoan = sc.nextLine();
                    System.out.println("==== Danh sach lich kham ====");
                    for (int i = 0; i < n; i++)
                        if (dslk[i].getChanDoan().toLowerCase().contains(chandoan.toLowerCase())) {
                            System.out.println(dslk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham co chan doan %s", chandoan);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chuc nang khong hop le! Vui long chon lai.");
                    break;
            }
        } while (c != 0);
    }

    public void XuatDS() {
        int c;
        if (n == 0) {
            System.out.println("Danh sach lich kham trong!");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH LICH KHAM                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        for (int i = 0; i < n; i++) {
            System.out.println(dslk[i].toString());
            System.out.println("────────────────────────────────────────────────────────────────────────");
        }
        System.out.println("Tong so lich kham: " + n);
        do {
            System.out.print("Ban muon hien thi thong tin lich kham chi tiet khong ? (1.CO|0.KHONG): ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    int found = 0;
                    sc.nextLine();
                    System.out.print("Nhap MaLK ban muon hien thi: ");
                    String ma = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (dslk[i].getMaLK().equalsIgnoreCase(ma)) {
                            dslk[i].displayInfo();
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay lich kham voi ma %s", ma);
                    break;
                default:
                    break;
            }
        } while (c != 0);
    }

    public void DocFile(String f) {
        try {
            dslk = new LICHKHAM[0];
            n = 0;
            LICHKHAM.setCountLichKham(0);

            BufferedReader input = new BufferedReader(new FileReader(f));
            String line;
            while ((line = input.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] arr = line.split(",");
                    if (arr.length >= 9) {
                        try {
                            LICHKHAM bs = new LICHKHAM(arr[0].trim(), arr[1].trim(), arr[2].trim(), arr[3].trim(),
                                    arr[4].trim(), arr[5].trim(), Double.parseDouble(arr[6].trim()),
                                    Boolean.parseBoolean(arr[7].trim()), arr[8].trim());
                            dslk = Arrays.copyOf(dslk, n + 1);
                            dslk[n] = bs;
                            n++;
                        } catch (NumberFormatException e) {
                            System.out.println("Bo qua dong co dinh dang sai: " + line);
                        }
                    } else {
                        System.out.println("Bo qua dong khong du thong tin: " + line);
                    }
                }
            }
            input.close();
            if (n > 0)
                System.out.println("Doc du lieu thanh cong! Tong so lich kham: " + n);
            else
                System.out.println("Khong co du lieu hop le nao duoc doc tu file.");
        } catch (FileNotFoundException e) {
            System.out.println("File " + f + " chua ton tai. Se tao moi khi luu.");
            dslk = new LICHKHAM[0];
            n = 0;
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void GhiFile(String f) {
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < n; i++) {
                fw.write(dslk[i].toFileString());
                fw.write("\n");
            }
            fw.close();
            System.out.println("Da luu " + n + " lich kham vao file.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void xemlichkham(String ID) {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH LICH KHAM                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        boolean ktralk = false;
        for (int i = 0; i < n; i++) {
            if (dslk[i].getMaBN().equals(ID)) {
                System.out.println(dslk[i].toString());
                ktralk = true;
            }
            if (dslk[i].getMaBS().equals(ID)) {
                System.out.println(dslk[i].toString());
                ktralk = true;
            }

        }
        System.out.println("────────────────────────────────────────────────────────────────────────");
        if (ktralk == false) {
            System.out.println("Ban khong co lich kham nao.");
        }
    }

    public void Dangkylichkham(Scanner sc, BENHNHAN bn, DSBACSI dsbacsi, DSPHONGKHAM dsphongkham) {

        System.out.println("\n=== BUOC 1: Chon Bac Si va Chuyen Khoa ===");

        String chuyenkhoa = dsbacsi.Chonchuyenkhoa(sc);
        String maBS = dsbacsi.ChonBACSI(sc, chuyenkhoa);

        if (maBS == null || maBS.isEmpty()) {
            System.out.println("Dang ky kham that bai.Vui long chon bac si hop le!!");
            return;
        }
        sc.nextLine();
        String maPK = dsphongkham.Phongkhamduocchon(chuyenkhoa);
        if (maPK == null || maPK.isEmpty()) {
            return;
        }
        System.out.println("\n=== BUOC 2: NHAP THOI GIAN KHAM ===");
        String ngayKham;
        LICHKHAM tempLK = new LICHKHAM();
        while (true) {
            System.out.print("Nhap ngay kham (yyyy-mm-dd): ");
            ngayKham = sc.nextLine();
            try {

                tempLK.setNgayKham(ngayKham);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Loi: " + e.getMessage() + ". Vui long nhap lai.");
            }
        }

        String gioKham;
        while (true) {
            System.out.print("Nhap gio kham (HH:mm, 00:00-23:59): ");
            gioKham = sc.nextLine();
            try {

                tempLK.setGioKham(gioKham);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Loi: " + e.getMessage() + ". Vui long nhap lai.");
            }
        }

        DSLICHKHAM dslk = this;
        String newId = dslk.taomoiMaLK();
        double PhiKham = 0;
        String ChanDoan = "null";
        LICHKHAM newLichKham = new LICHKHAM(newId, bn.getId(), maBS, maPK, ngayKham, gioKham, PhiKham, false, ChanDoan);
        Them(newLichKham);

        System.out.println("\n--- DANG KY LICH KHAM THANH CONG ---");
        System.out.println("Ma lich kham cua ban: " + newId);
        System.out.println("Bac si: " + maBS + " | Phong: " + maPK);
        System.out.println("Ngay: " + ngayKham + " | Gio: " + gioKham);
        System.out.println("Vui long den dung gio!");
        System.out.println("------------------------------------");
    }

    public void Huylichkham(BENHNHAN bn, Scanner sc) {

        xemlichkham(bn.getId());
        String maLKCanHuy;
        System.out.print("Nhap lich kham (VD: LK001) ban muon huy (hoac exit de thoat): ");
        do {
            maLKCanHuy = sc.nextLine().trim();
            if (maLKCanHuy.toLowerCase().equals("exit")) {
                System.out.println("Da huy thao tac");
                return;
            }
        } while (maLKCanHuy.toLowerCase().equals("exit"));

        int xacnhan = -1;
        do {
            System.out.print("Ban chac chan muon huy lich kham nay (1 - Co | 0 - Khong): ");
            xacnhan = sc.nextInt();
            sc.nextLine();
            if (xacnhan == 1) {
                int index = -1;
                for (int i = 0; i < n; i++)
                    if (dslk[i].getMaLK().toLowerCase().contains(maLKCanHuy.toLowerCase()))
                        index = i;
                XoaLichKham(index);
                System.out.println("\n*** Huy lich kham thanh cong ***");
                break;
            }
            if (xacnhan == 0) {
                System.out.println("\nTro ve menu");
                break;
            } else
                System.out.println("Chi duoc nhao 0 hoac 1.");
        } while (xacnhan > 0);
    }
}
