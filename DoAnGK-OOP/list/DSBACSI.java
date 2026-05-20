package list;

import java.io.*;
import java.util.*;

import Classes_2.*;
import Interface.*;

public class DSBACSI implements IQuanLy<BACSI> {
    private BACSI[] dsbs;

    private int n;
    Scanner sc = new Scanner(System.in);

    public DSBACSI() {
        n = 0;
        dsbs = new BACSI[0];
    }

    public DSBACSI(int n, BACSI[] ds) {
        this.n = n;
        dsbs = new BACSI[n];
        for (int i = 0; i < n; i++)
            dsbs[i] = ds[i];
    }

    public String taomoiMaBS() {
        int maxId = 0;
        for (BACSI bs : dsbs) {
            if (bs != null && bs.getId().startsWith("BS")) {
                try {
                    int idNum = Integer.parseInt(bs.getId().substring(2));
                    if (idNum > maxId)
                        maxId = idNum;
                } catch (NumberFormatException e) {
                }
            }
        }
        return "BS" + String.format("%03d", maxId + 1);
    }
    public void Them(BACSI bs){}
    public void Them(BACSI bs, DSTAIKHOAN dstk) {
        dsbs = Arrays.copyOf(dsbs, n + 1);
        dsbs[n] = new BACSI(bs);
        n++;
        System.out.println("Da them bac si thanh cong!");
        TAIKHOAN tk = new TAIKHOAN(bs.getId(),"1234567");
        dstk.Them(tk);
        System.out.println("Da tao tai khoan cho bac si voi ID: " + tk.getId() + " va mat khau mac dinh: 1234567");
    }

    public BACSI TimKiemTheoMa(String Ma) {
        for (int i = 0; i < n; i++)
            if (dsbs[i].getId().toLowerCase().contains(Ma.toLowerCase()))
                return dsbs[i];
        return null;
    }

    public BACSI TimKiemTheoHoTen(String hoten) {
        for (int i = 0; i < n; i++)
            if (dsbs[i].getHoTen().toLowerCase().contains(hoten.toLowerCase()))
                return dsbs[i];
        return null;
    }

    public void CapNhat(String id) {
        for (int i = 0; i < n; i++) {
            if (dsbs[i].getId().equals(id)) {
                System.out.println("Da tim thay Bac si voi ma " + id);
                int c;
                do {
                    boolean Isvalid;

                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║              CAP NHAT BAC SI              ║");
                    System.out.println("╠═══════════════════════════════════════════╣");
                    System.out.println("║  1. Cap nhat Ho ten                       ║");
                    System.out.println("║  2. Cap nhat Tuoi                         ║");
                    System.out.println("║  3. Cap nhat Gioi Tinh                    ║");
                    System.out.println("║  4. Cap nhat SDT                          ║");
                    System.out.println("║  5. Cap nhat Dia Chi                      ║");
                    System.out.println("║  6. Cap nhat Chuyen Khoa                  ║");
                    System.out.println("║  7. Cap nhat Lich lam viec                ║");
                    System.out.println("║  8. Cap nhat Luong                        ║");
                    System.out.println("║  0. Quay lai Menu Bac Si                  ║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    System.out.print("Chon chuc nang (0-8): ");
                    c = sc.nextInt();
                    switch (c) {
                        case 1:
                            do {
                                try {
                                    System.out.print("Nhap Ho Ten can cap nhat: ");
                                    String hoten = sc.nextLine();
                                    dsbs[i].setHoTen(hoten);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
                            break;
                        case 2:
                            do {
                                try {
                                    System.out.print("Nhap Tuoi can cap nhat: ");
                                    int tuoi = sc.nextInt();
                                    dsbs[i].setTuoi(tuoi);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
                            break;
                        case 3:
                            do {
                                try {
                                    System.out.print("Nhap Gioi Tinh can cap nhat: ");
                                    String gioitinh = sc.nextLine();
                                    dsbs[i].setGioiTinh(gioitinh);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
                            break;
                        case 4:
                            do {
                                try {
                                    System.out.print("Nhap SDT can cap nhat: ");
                                    String sdt = sc.nextLine();
                                    dsbs[i].setSDT(sdt);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
                            break;
                        case 5:
                            do {
                                try {
                                    System.out.print("Nhap Dia chi can cap nhat: ");
                                    String diachi = sc.nextLine();
                                    dsbs[i].setDiaChi(diachi);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
                            break;
                        case 6:
                            do {
                                try {
                                    System.out.print("Nhap Chuyen khoa can cap nhat: ");
                                    String chuyenkhoa = sc.nextLine();
                                    dsbs[i].setChuyenKhoa(chuyenkhoa);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
                            break;
                        case 7:
                            do {
                                try {
                                    System.out.print("Nhap Lich lam viec can cap nhat: ");
                                    String lichlamviec = sc.nextLine();
                                    dsbs[i].setLichLamViec(lichlamviec);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
                            break;
                        case 8:
                            do {
                                try {
                                    System.out.print("Nhap Luong can cap nhat: ");
                                    double luong = sc.nextDouble();
                                    dsbs[i].setLuong(luong);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin bac si!");
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
        System.out.println("Khong tim thay bac si voi ma: " + id);
    }

    public void Xoa(DSLICHKHAM dslk, DSHOADON dshd) {
        int c, found;
        do {
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║                 XOA BAC SI                ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Xoa theo Ma                           ║");
            System.out.println("║  2. Xoa theo Ho ten                       ║");
            System.out.println("║  3. Xoa theo Tuoi                         ║");
            System.out.println("║  4. Xoa theo Gioi Tinh                    ║");
            System.out.println("║  5. Xoa theo SDT                          ║");
            System.out.println("║  6. Xoa theo Dia Chi                      ║");
            System.out.println("║  7. Xoa theo Chuyen Khoa                  ║");
            System.out.println("║  8. Xoa theo Lich lam viec                ║");
            System.out.println("║  9. Xoa theo Luong                       ║");
            System.out.println("║  0. Quay lai Menu Bac Si                  ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-9): ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    System.out.print("Nhap Ma can xoa: ");
                    String ma = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getId().toLowerCase().contains(ma.toLowerCase())) {
                            System.out.print(
                                    "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dsbs[j] = dsbs[j + 1];
                            dsbs = Arrays.copyOf(dsbs, n - 1);
                            n--;
                            BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                            System.out.println("Da xoa bac si va cac lien ket.");
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi ma bac si %s de xoa", ma);
                    else
                        System.out.format("Da xoa bac si voi ma bac si %s", ma);
                    break;
                case 2:
                    System.out.print("Nhap Ho ten can xoa: ");
                    String hoten = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getHoTen().toLowerCase().contains(hoten.toLowerCase())) {
                            System.out.print(
                                    "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dsbs[j] = dsbs[j + 1];
                            dsbs = Arrays.copyOf(dsbs, n - 1);
                            n--;
                            BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                            System.out.println("Da xoa bac si va cac lien ket.");
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi ho ten %s de xoa", hoten);
                    else
                        System.out.format("Da xoa bac si voi ho ten %s", hoten);
                    break;
                case 3:
                    System.out.print("Nhap Tuoi can xoa: ");
                    int tuoi = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Chon tieu chi xoa(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    found = 0;
                    if (tieuchi.equals("lon")) {
                        for (int i = 0; i < n; i++) {
                            if (dsbs[i].getTuoi() > tuoi) {
                                System.out.print(
                                        "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                        for (int k = dshd.getN() - 1; k >= 0; k--)
                                            if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                                if (dshd.getDshd()[k] != null
                                                        && dshd.getDshd()[k].getMaLK()
                                                                .equals(dslk.getDslk()[j].getMaLK())
                                                        && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                    dshd.XoaHoaDon(k);
                                        dslk.XoaLichKham(j);
                                    }
                                for (int j = i; j < n - 1; j++)
                                    dsbs[j] = dsbs[j + 1];
                                dsbs = Arrays.copyOf(dsbs, n - 1);
                                n--;
                                BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                                System.out.println("Da xoa bac si va cac lien ket.");
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong xoa thay bac si lon hon do tuoi %d", tuoi);
                        else
                            System.out.format("Da xoa bac si voi do tuoi lon hon %d", tuoi);
                    } else if (tieuchi.equals("be")) {
                        for (int i = 0; i < n; i++) {
                            if (dsbs[i].getTuoi() < tuoi) {
                                System.out.print(
                                        "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                        for (int k = dshd.getN() - 1; k >= 0; k--)
                                            if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                                if (dshd.getDshd()[k] != null
                                                        && dshd.getDshd()[k].getMaLK()
                                                                .equals(dslk.getDslk()[j].getMaLK())
                                                        && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                    dshd.XoaHoaDon(k);
                                        dslk.XoaLichKham(j);
                                    }
                                for (int j = i; j < n - 1; j++)
                                    dsbs[j] = dsbs[j + 1];
                                dsbs = Arrays.copyOf(dsbs, n - 1);
                                n--;
                                BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                                System.out.println("Da xoa bac si va cac lien ket.");
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong xoa thay bac si be hon do tuoi %d", tuoi);
                        else
                            System.out.format("Da xoa bac si voi do tuoi be hon %d", tuoi);
                    } else if (tieuchi.equals("bang")) {
                        for (int i = 0; i < n; i++) {
                            if (dsbs[i].getTuoi() == tuoi) {
                                System.out.print(
                                        "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                        for (int k = dshd.getN() - 1; k >= 0; k--)
                                            if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                                if (dshd.getDshd()[k] != null
                                                        && dshd.getDshd()[k].getMaLK()
                                                                .equals(dslk.getDslk()[j].getMaLK())
                                                        && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                    dshd.XoaHoaDon(k);
                                        dslk.XoaLichKham(j);
                                    }
                                for (int j = i; j < n - 1; j++)
                                    dsbs[j] = dsbs[j + 1];
                                dsbs = Arrays.copyOf(dsbs, n - 1);
                                n--;
                                BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                                System.out.println("Da xoa bac si va cac lien ket.");
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong xoa thay bac si voi do tuoi bang %d", tuoi);
                        else
                            System.out.format("Da xoa bac si voi do tuoi bang %d", tuoi);
                    } else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 4:
                    System.out.print("Nhap Gioi tinh can xoa(Nam/Nu): ");
                    String gioitinh = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getGioiTinh().toLowerCase().contains(gioitinh.toLowerCase())) {
                            System.out.print(
                                    "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dsbs[j] = dsbs[j + 1];
                            dsbs = Arrays.copyOf(dsbs, n - 1);
                            n--;
                            BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                            System.out.println("Da xoa bac si va cac lien ket.");
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi gioi tinh %s de xoa", gioitinh);
                    else
                        System.out.format("Da xoa bac si voi gioi tinh %s", gioitinh);
                    break;
                case 5:
                    System.out.print("Nhap SDT can xoa: ");
                    String sdt = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getSDT().toLowerCase().contains(sdt.toLowerCase())) {
                            System.out.print(
                                    "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dsbs[j] = dsbs[j + 1];
                            dsbs = Arrays.copyOf(dsbs, n - 1);
                            n--;
                            BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                            System.out.println("Da xoa bac si va cac lien ket.");
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi sdt %s de xoa", sdt);
                    else
                        System.out.format("Da xoa bac si voi sdt %s", sdt);
                    break;
                case 6:
                    System.out.print("Nhap Dia chi can xoa: ");
                    String diachi = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getDiaChi().toLowerCase().contains(diachi.toLowerCase())) {
                            System.out.print(
                                    "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dsbs[j] = dsbs[j + 1];
                            dsbs = Arrays.copyOf(dsbs, n - 1);
                            n--;
                            BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                            System.out.println("Da xoa bac si va cac lien ket.");
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi dia chi %s de xoa", diachi);
                    else
                        System.out.format("Da xoa bac si voi dia chi %s", diachi);
                    break;
                case 7:
                    System.out.print("Nhap Chuyen khoa can xoa: ");
                    String chuyenkhoa = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getChuyenKhoa().toLowerCase().contains(chuyenkhoa.toLowerCase())) {
                            System.out.print(
                                    "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dsbs[j] = dsbs[j + 1];
                            dsbs = Arrays.copyOf(dsbs, n - 1);
                            n--;
                            BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                            System.out.println("Da xoa bac si va cac lien ket.");
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si chuyen khoa %s de xoa", chuyenkhoa);
                    else
                        System.out.format("Da xoa bac si chuyen khoa %s", chuyenkhoa);
                    break;
                case 8:
                    System.out.print("Nhap Lich lam viec can xoa(Thu x): ");
                    String lichlam = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getLichLamViec().toLowerCase().contains(lichlam.toLowerCase())) {
                            System.out.print(
                                    "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dsbs[j] = dsbs[j + 1];
                            dsbs = Arrays.copyOf(dsbs, n - 1);
                            n--;
                            BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                            System.out.println("Da xoa bac si va cac lien ket.");
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si co lich lam vao %s de xoa", lichlam);
                    else
                        System.out.format("Da xoa bac si co lich lam vao %s", lichlam);
                    break;
                case 9:
                    System.out.print("Nhap Muc luong can xoa: ");
                    double luong = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Chon tieu chi xoa(lon|be|bang): ");
                    String tieuchi3 = sc.nextLine();
                    found = 0;
                    if (tieuchi3.equals("lon")) {
                        for (int i = 0; i < n; i++) {
                            if (dsbs[i].getLuong() > luong) {
                                System.out.print(
                                        "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                        for (int k = dshd.getN() - 1; k >= 0; k--)
                                            if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                                if (dshd.getDshd()[k] != null
                                                        && dshd.getDshd()[k].getMaLK()
                                                                .equals(dslk.getDslk()[j].getMaLK())
                                                        && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                    dshd.XoaHoaDon(k);
                                        dslk.XoaLichKham(j);
                                    }
                                for (int j = i; j < n - 1; j++)
                                    dsbs[j] = dsbs[j + 1];
                                dsbs = Arrays.copyOf(dsbs, n - 1);
                                n--;
                                BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                                System.out.println("Da xoa bac si va cac lien ket.");
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si voi muc luong lon hon %d de xoa", luong);
                        else
                            System.out.format("Da xoa bac si voi muc luong lon hon %d", luong);
                    } else if (tieuchi3.equals("be")) {
                        for (int i = 0; i < n; i++) {
                            if (dsbs[i].getLuong() < luong) {
                                System.out.print(
                                        "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                        for (int k = dshd.getN() - 1; k >= 0; k--)
                                            if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                                if (dshd.getDshd()[k] != null
                                                        && dshd.getDshd()[k].getMaLK()
                                                                .equals(dslk.getDslk()[j].getMaLK())
                                                        && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                    dshd.XoaHoaDon(k);
                                        dslk.XoaLichKham(j);
                                    }
                                for (int j = i; j < n - 1; j++)
                                    dsbs[j] = dsbs[j + 1];
                                dsbs = Arrays.copyOf(dsbs, n - 1);
                                n--;
                                BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                                System.out.println("Da xoa bac si va cac lien ket.");
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si voi muc luong be hon %d de xoa", luong);
                        else
                            System.out.format("Da xoa bac si voi muc luong be hon %d", luong);
                    } else if (tieuchi3.equals("bang")) {
                        for (int i = 0; i < n; i++) {
                            if (dsbs[i].getLuong() == luong) {
                                System.out.print(
                                        "Xoa bac si se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaBS().equals(dsbs[i].getId())) {
                                        for (int k = dshd.getN() - 1; k >= 0; k--)
                                            if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                                if (dshd.getDshd()[k] != null
                                                        && dshd.getDshd()[k].getMaLK()
                                                                .equals(dslk.getDslk()[j].getMaLK())
                                                        && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                    dshd.XoaHoaDon(k);
                                        dslk.XoaLichKham(j);
                                    }
                                for (int j = i; j < n - 1; j++)
                                    dsbs[j] = dsbs[j + 1];
                                dsbs = Arrays.copyOf(dsbs, n - 1);
                                n--;
                                BACSI.setcountBacSi(BACSI.getcountBacSi() - 1);
                                System.out.println("Da xoa bac si va cac lien ket.");
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si voi muc luong bang %d de xoa", luong);
                        else
                            System.out.format("Da xoa bac si voi muc luong bang %d", luong);
                    } else
                        System.out.println("Nhap sai tieu chi!");
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
            System.out.println("║              TIM KIEM BAC SI              ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Tim Kiem theo Ma                      ║");
            System.out.println("║  2. Tim Kiem theo Ho ten                  ║");
            System.out.println("║  3. Tim Kiem theo Tuoi                    ║");
            System.out.println("║  4. Tim Kiem theo Gioi Tinh               ║");
            System.out.println("║  5. Tim Kiem theo SDT                     ║");
            System.out.println("║  6. Tim Kiem theo Dia Chi                 ║");
            System.out.println("║  7. Tim Kiem theo Chuyen Khoa             ║");
            System.out.println("║  8. Tim Kiem theo Lich lam viec           ║");
            System.out.println("║  9. Tim Kiem theo Luong                   ║");
            System.out.println("║  0. Quay lai Menu Bac Si                  ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-9): ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    System.out.print("Nhap Ma can tim: ");
                    String ma = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    if (TimKiemTheoMa(ma) != null) {
                        System.out.println(TimKiemTheoMa(ma));
                    } else
                        System.out.format("Khong tim thay bac si voi ma %s", ma);
                    break;
                case 2:
                    found = 0;
                    System.out.print("Nhap Ho ten can tim: ");
                    String hoten = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    if (TimKiemTheoHoTen(hoten) != null) {
                        System.out.println(TimKiemTheoHoTen(hoten));
                    } else
                        System.out.format("Khong tim thay bac si voi ma %s", hoten);
                    break;
                case 3:
                    found = 0;
                    System.out.print("Nhap Tuoi can tim: ");
                    int tuoi = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Chon tieu chi tim kiem(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    if (tieuchi.equals("lon")) {
                        for (int i = 0; i < n; i++)
                            if (dsbs[i].getTuoi() > tuoi) {
                                System.out.println(dsbs[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si lon hon do tuoi %d", tuoi);
                    } else if (tieuchi.equals("be")) {
                        for (int i = 0; i < n; i++)
                            if (dsbs[i].getTuoi() < tuoi) {
                                System.out.println(dsbs[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si be hon do tuoi %d", tuoi);
                    } else if (tieuchi.equals("bang")) {
                        for (int i = 0; i < n; i++)
                            if (dsbs[i].getTuoi() == tuoi) {
                                System.out.println(dsbs[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si bang do tuoi %d", tuoi);
                    } else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 4:
                    found = 0;
                    System.out.print("Nhap Gioi tinh can tim(Nam/Nu): ");
                    String gioitinh = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    for (int i = 0; i < n; i++)
                        if (dsbs[i].getGioiTinh().equalsIgnoreCase(gioitinh)) {
                            System.out.println(dsbs[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi gioi tinh %s", gioitinh);
                    break;
                case 5:
                    found = 0;
                    System.out.print("Nhap SDT can tim: ");
                    String sdt = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    for (int i = 0; i < n; i++)
                        if (dsbs[i].getSDT().equalsIgnoreCase(sdt)) {
                            System.out.println(dsbs[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi sdt %s", sdt);
                    break;
                case 6:
                    found = 0;
                    System.out.print("Nhap Dia chi can tim: ");
                    String diachi = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    for (int i = 0; i < n; i++)
                        if (dsbs[i].getDiaChi().toLowerCase().contains(diachi.toLowerCase())) {
                            System.out.println(dsbs[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi dia chi %s", diachi);
                    break;
                case 7:
                    found = 0;
                    System.out.print("Nhap Chuyen khoa can tim: ");
                    String chuyenkhoa = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    for (int i = 0; i < n; i++)
                        if (dsbs[i].getChuyenKhoa().toLowerCase().contains(chuyenkhoa.toLowerCase())) {
                            System.out.println(dsbs[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si chuyen khoa %s", chuyenkhoa);
                    break;
                case 8:
                    found = 0;
                    System.out.print("Nhap Lich lam viec can tim(Thu x): ");
                    String lichlam = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    for (int i = 0; i < n; i++)
                        if (dsbs[i].getLichLamViec().toLowerCase().contains(lichlam.toLowerCase())) {
                            System.out.println(dsbs[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si co lich lam vao %s", lichlam);
                    break;
                case 9:
                    found = 0;
                    System.out.print("Nhap Muc luong can tim: ");
                    double luong = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Chon tieu chi tim kiem(lon|be|bang): ");
                    String tieuchi3 = sc.nextLine();
                    System.out.println("==== Danh sach Bac Si ====");
                    if (tieuchi3.equals("lon")) {
                        for (int i = 0; i < n; i++)
                            if (dsbs[i].getLuong() > luong) {
                                System.out.println(dsbs[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si voi muc luong lon hon %d", luong);
                    } else if (tieuchi3.equals("be")) {
                        for (int i = 0; i < n; i++)
                            if (dsbs[i].getLuong() < luong) {
                                System.out.println(dsbs[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si voi muc luong be hon %d", luong);
                    } else if (tieuchi3.equals("bang")) {
                        for (int i = 0; i < n; i++)
                            if (dsbs[i].getLuong() == luong) {
                                System.out.println(dsbs[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay bac si voi muc luong bang %d", luong);
                    } else
                        System.out.println("Nhap sai tieu chi!");
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
            System.out.println("Danh sach bac si trong!");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH BAC SI                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        for (int i = 0; i < n; i++) {
            System.out.println(dsbs[i].toString());
            System.out.println("────────────────────────────────────────────────────────────────────────");
        }
        System.out.println("Tong so bac si: " + n);
        do {
            System.out.print("Ban muon hien thi thong tin bac si chi tiet khong ? (1.CO|0.KHONG): ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    int found = 0;
                    sc.nextLine();
                    System.out.print("Nhap MaBS ban muon hien thi: ");
                    String ma = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (dsbs[i].getId().equalsIgnoreCase(ma)) {
                            dsbs[i].displayInfo();
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay bac si voi ma %s", ma);
                    break;
                default:
                    break;
            }
        } while (c != 0);
    }

    public void DocFile(String f) {
        try {
            dsbs = new BACSI[0];
            n = 0;

            BufferedReader input = new BufferedReader(new FileReader(f));
            String line;
            while ((line = input.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] arr = line.split(",");
                    if (arr.length >= 9) {
                        try {
                            BACSI bs = new BACSI(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim()),
                                    arr[3].trim(), arr[4].trim(), arr[5].trim(), arr[6].trim(), arr[7].trim(),
                                    Double.parseDouble(arr[8].trim()));
                            dsbs = Arrays.copyOf(dsbs, n + 1);
                            dsbs[n] = bs;
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
                System.out.println("Doc du lieu thanh cong! Tong so bac si: " + n);
            else
                System.out.println("Khong co du lieu hop le nao duoc doc tu file.");
        } catch (FileNotFoundException e) {
            System.out.println("File " + f + " chua ton tai. Se tao moi khi luu.");
            dsbs = new BACSI[0];
            n = 0;
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void GhiFile(String f) {
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < n; i++) {
                fw.write(dsbs[i].toFileString());
                fw.write("\n");
            }
            fw.close();
            System.out.println("Da luu " + n + " bac si vao file.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public BACSI[] LocBacsi(String chuyenkhoa) {
        if (chuyenkhoa.equals("")) {
            System.out.println("Chuyen khoa khong ton tai");
            return null;
        }
        boolean ktra = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsbs[i] != null && dsbs[i].getChuyenKhoa().equalsIgnoreCase(chuyenkhoa)) {
                count++;
            }
        }
        int index = 0;
        BACSI[] dsBStheochuyenkhoa = new BACSI[count];
        for (int i = 0; i < n; i++) {
            if (dsbs[i].getChuyenKhoa().equals(chuyenkhoa)) {
                dsBStheochuyenkhoa[index++] = dsbs[i];
                ktra = true;
            }
        }
        if (ktra == false) {
            System.out.println("Khong co bac si nao thuoc chuyen khoa " + chuyenkhoa);
        }
        return dsBStheochuyenkhoa;
    }
    // Trong DSBACSI.java

    public String[] LocKhoa() {
        String[] Cacchuyenkhoa = new String[50];
        int countKhoa = 0;
        for (int i = 0; i < n; i++) {
            if (dsbs[i] == null)
                continue;
            String chuyenkhoahientai = dsbs[i].getChuyenKhoa();
            if (chuyenkhoahientai == null || chuyenkhoahientai.trim().isEmpty())
                continue;
            boolean ktra = false;
            for (int j = 0; j < countKhoa; j++) {
                if (Cacchuyenkhoa[j].equals(chuyenkhoahientai)) {
                    ktra = true;
                    break;
                }
            }
            if (!ktra && countKhoa < Cacchuyenkhoa.length) {
                Cacchuyenkhoa[countKhoa] = chuyenkhoahientai;
                countKhoa++;
            }
        }
        return Arrays.copyOf(Cacchuyenkhoa, countKhoa);
    }

    public String Chonchuyenkhoa(Scanner sc) {
        String[] Cacchuyenkhoa = LocKhoa();
        int choice = -1;
        do {
            System.out.println("==========VUI LONG CHON KHOA==========");
            for (int i = 0; i < Cacchuyenkhoa.length; i++) {
                System.out.println((i + 1) + ". " + Cacchuyenkhoa[i]);
            }

            System.out.print("\nChuyen khoa (hoac 0 de huy thao tac): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Lua chon khong hop le.Vui long so:");
                sc.next();
                continue;
            }
            if (choice >= 1 && choice <= Cacchuyenkhoa.length) {
                return Cacchuyenkhoa[choice - 1];

            } else if (choice == 0) {
                System.out.println("Da huy chon chuyen khoa.");
                return "";
            } else {
                System.out.println("Chuyen khoa khong hope le.Vui long chon lai.");
            }
        } while (true);
    }

    public String ChonBACSI(Scanner sc, String chuyenkhoa) {
        BACSI[] DSbs_theochuyenkhoa = LocBacsi(chuyenkhoa);
        String ID_BSduocchon = "";
        int choice = -1;
        if (DSbs_theochuyenkhoa.length == 0) {
            System.out.println("Khong co bac si nao thuoc chuyen khoa " + chuyenkhoa);
            return "";
        }
        do {
            System.out.println("\n| STT | Ho Ten              |");
            System.out.println("|-----|---------------------|");
            for (int i = 0; i < DSbs_theochuyenkhoa.length; i++) {
                if (DSbs_theochuyenkhoa[i] != null) {
                    System.out.printf("| %-3d | %-20s |\n", (i + 1), DSbs_theochuyenkhoa[i].getHoTen());
                }

            }
            System.out.print("Chon bac si (0 de thoat): ");

            choice = sc.nextInt();
            if (choice > 0 && choice <= DSbs_theochuyenkhoa.length) {
                ID_BSduocchon = DSbs_theochuyenkhoa[choice - 1].getId();
                break;
            } else if (choice == 0) {
                System.out.println("Da huy chon Bac si.");
                return "";
            } else
                System.out.println("Bac si khong hop le.");
        } while (true);
        return ID_BSduocchon;
    }
}
