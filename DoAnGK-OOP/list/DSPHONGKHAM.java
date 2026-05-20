package list;

import java.io.*;
import java.util.*;

import Classes_2.*;
import Interface.*;

public class DSPHONGKHAM implements IQuanLy<PHONGKHAM> {
    private PHONGKHAM[] dspk;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DSPHONGKHAM() {
        n = 0;
        dspk = new PHONGKHAM[0];
    }

    public DSPHONGKHAM(int n, PHONGKHAM[] ds) {
        this.n = n;
        dspk = new PHONGKHAM[n];
        for (int i = 0; i < n; i++)
            dspk[i] = ds[i];
    }

    public String taomoiMaPK() {
        int maxId = 0;
        for (PHONGKHAM pk : dspk) {
            if (pk != null && pk.getMaPK().startsWith("PK")) {
                try {
                    int idNum = Integer.parseInt(pk.getMaPK().substring(2));
                    if (idNum > maxId)
                        maxId = idNum;
                } catch (NumberFormatException e) {
                }
            }
        }
        return "PK" + String.format("%03d", maxId + 1);
    }

    public void Them(PHONGKHAM bs) {
        for (int i = 0; i < n; i++)
            if (dspk[i].getMaPK().equals(bs.getMaPK())) {
                System.out.println("Ma phong kham da ton tai!");
                return;
            }
        dspk = Arrays.copyOf(dspk, n + 1);
        dspk[n] = new PHONGKHAM(bs);
        n++;
        System.out.println("Da them phong kham thanh cong!");
    }

    public void CapNhat(String id) {
        for (int i = 0; i < n; i++) {
            if (dspk[i].getMaPK().equals(id)) {
                int c;
                do {

                    boolean Isvalid;

                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║            CAP NHAT PHONG KHAM            ║");
                    System.out.println("╠═══════════════════════════════════════════╣");
                    System.out.println("║  1. Cap nhat Ten Phong Kham               ║");
                    System.out.println("║  2. Cap nhat Khoa                         ║");
                    System.out.println("║  3. Cap nhat So luong                     ║");
                    System.out.println("║  4. Cap nhat Trang Thai                   ║");
                    System.out.println("║  0. Quay lai Menu Phong Kham              ║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    System.out.print("Chon chuc nang (0-4): ");
                    c = sc.nextInt();
                    sc.nextLine();
                    switch (c) {
                        case 1:
                            do {
                                try {
                                    System.out.print("Nhap Ten phong kham can cap nhat: ");
                                    String tenphong = sc.nextLine();
                                    dspk[i].setTenPK(tenphong);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin phong kham!");
                            break;
                        case 2:
                            do {
                                try {
                                    System.out.print("Nhap Ten Khoa can cap nhat: ");
                                    String khoa = sc.nextLine();
                                    dspk[i].setKhoa(khoa);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin phong kham!");
                            break;
                        case 3:
                            do {
                                try {
                                    System.out.print("Nhap So luong can cap nhat: ");
                                    int soluong = sc.nextInt();
                                    sc.nextLine();
                                    dspk[i].setSoLuong(soluong);
                                    Isvalid = true;
                                } catch (Exception e) {
                                    System.out.println("Loi " + e.getMessage());
                                    System.out.println("Vui long nhap lai!");
                                    System.out.println("---------------------");
                                    Isvalid = false;
                                }
                            } while (!Isvalid);
                            System.out.println("Da cap nhat thong tin phong kham!");
                            break;
                        case 4:
                            do {
                                try {
                                    System.out.print("Nhap Trang thai can cap nhat(1:Con trong/0:Da day): ");
                                    int tt = sc.nextInt();
                                    sc.nextLine();
                                    boolean trangthai = (tt == 1);
                                    dspk[i].setTrangThai(trangthai);
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
        System.out.println("Khong tim thay phong kham voi ma: " + id);
    }

    public void Xoa(DSLICHKHAM dslk, DSHOADON dshd) {
        int c, found;
        do {
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║               XOA PHONG KHAM              ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Xoa theo Ma Phong Kham                ║");
            System.out.println("║  2. Xoa theo Ten Phong Kham               ║");
            System.out.println("║  3. Xoa theo Khoa                         ║");
            System.out.println("║  4. Xoa theo So Luong                     ║");
            System.out.println("║  5. Xoa theo Trang thai                   ║");
            System.out.println("║  0. Quay lai Menu Phong Kham              ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-5): ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    System.out.print("Nhap Ma Phong Kham can xoa: ");
                    String mapk = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dspk[i].getMaPK().toLowerCase().contains(mapk.toLowerCase())) {
                            System.out.print(
                                    "Xoa phong kham se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null
                                        && dslk.getDslk()[j].getMaPK().equals(dspk[i].getMaPK())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dspk[j] = dspk[j + 1];
                            dspk = Arrays.copyOf(dspk, n - 1);
                            n--;
                            PHONGKHAM.setCountPhongKham(PHONGKHAM.getCountPhongKham() - 1);
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay phong kham voi ma phong kham %s de xoa", mapk);
                    else
                        System.out.format("Da xoa phong kham voi ma phong kham %s", mapk);
                    break;
                case 2:
                    System.out.print("Nhap Ten phong kham can xoa: ");
                    String tenpk = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dspk[i].getTenPK().toLowerCase().contains(tenpk.toLowerCase())) {
                            System.out.print(
                                    "Xoa phong kham se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null
                                        && dslk.getDslk()[j].getMaPK().equals(dspk[i].getMaPK())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dspk[j] = dspk[j + 1];
                            dspk = Arrays.copyOf(dspk, n - 1);
                            n--;
                            PHONGKHAM.setCountPhongKham(PHONGKHAM.getCountPhongKham() - 1);
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay phong kham voi ten phong kham %s de xoa", tenpk);
                    else
                        System.out.format("Da xoa phong kham voi ten phong kham %s", tenpk);
                    break;
                case 3:
                    System.out.print("Nhap Khoa can xoa: ");
                    String khoa = sc.nextLine();
                    found = 0;
                    for (int i = 0; i < n; i++) {
                        if (dspk[i].getKhoa().toLowerCase().contains(khoa.toLowerCase())) {
                            System.out.print(
                                    "Xoa phong kham se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null
                                        && dslk.getDslk()[j].getMaPK().equals(dspk[i].getMaPK())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null
                                                    && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK())
                                                    && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dspk[j] = dspk[j + 1];
                            dspk = Arrays.copyOf(dspk, n - 1);
                            n--;
                            PHONGKHAM.setCountPhongKham(PHONGKHAM.getCountPhongKham() - 1);
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay phong kham voi khoa %s de xoa", khoa);
                    else
                        System.out.format("Da xoa phong kham voi khoa %s", khoa);
                    break;
                case 4:
                    found = 0;
                    System.out.print("Nhap So luong can xoa: ");
                    int soluong = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Chon tieu chi xoa(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    if (tieuchi.equals("lon")) {
                        for (int i = 0; i < n; i++) {
                            if (dspk[i].getSoLuong() > soluong) {
                                System.out.print(
                                        "Xoa phong kham se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaPK().equals(dspk[i].getMaPK())) {
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
                                    dspk[j] = dspk[j + 1];
                                dspk = Arrays.copyOf(dspk, n - 1);
                                n--;
                                PHONGKHAM.setCountPhongKham(PHONGKHAM.getCountPhongKham() - 1);
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong tim thay phong kham co so luong lon hon %d de xoa", soluong);
                        else
                            System.out.format("Da xoa phong kham co so luong lon hon %d", soluong);
                    } else if (tieuchi.equals("be")) {
                        for (int i = 0; i < n; i++) {
                            if (dspk[i].getSoLuong() < soluong) {
                                System.out.print(
                                        "Xoa phong kham se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaPK().equals(dspk[i].getMaPK())) {
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
                                    dspk[j] = dspk[j + 1];
                                dspk = Arrays.copyOf(dspk, n - 1);
                                n--;
                                PHONGKHAM.setCountPhongKham(PHONGKHAM.getCountPhongKham() - 1);
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong tim thay phong kham co so luong be hon %d de xoa", soluong);
                        else
                            System.out.format("Da xoa phong kham co so luong be hon %d", soluong);
                    } else if (tieuchi.equals("bang")) {
                        for (int i = 0; i < n; i++) {
                            if (dspk[i].getSoLuong() == soluong) {
                                System.out.print(
                                        "Xoa phong kham se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                                String confirm = sc.nextLine();
                                if (!confirm.equalsIgnoreCase("y")) {
                                    System.out.println("Huy xoa.");
                                    return;
                                }
                                for (int j = dslk.getN() - 1; j >= 0; j--)
                                    if (dslk.getDslk()[j] != null
                                            && dslk.getDslk()[j].getMaPK().equals(dspk[i].getMaPK())) {
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
                                    dspk[j] = dspk[j + 1];
                                dspk = Arrays.copyOf(dspk, n - 1);
                                n--;
                                PHONGKHAM.setCountPhongKham(PHONGKHAM.getCountPhongKham() - 1);
                                found = 1;
                            }
                        }
                        if (found == 0)
                            System.out.format("Khong tim thay phong kham co so luong bang %d de xoa", soluong);
                        else
                            System.out.format("Da xoa phong kham co so luong bang %d", soluong);
                    } else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 5:
                    found = 0;
                    System.out.print("Nhap Trang thai can xoa(1:Da day/0:Trong): ");
                    int tt = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (dspk[i].getTrangThai() == (tt == 1)) {
                            System.out.print(
                                    "Xoa phong kham se xoa tat ca lich kham va hoa don lien quan. Tiep tuc? (y/n): ");
                            String confirm = sc.nextLine();
                            if (!confirm.equalsIgnoreCase("y")) {
                                System.out.println("Huy xoa.");
                                return;
                            }
                            for (int j = dslk.getN() - 1; j >= 0; j--)
                                if (dslk.getDslk()[j] != null && dslk.getDslk()[j].getMaPK().equals(dspk[i].getMaPK())) {
                                    for (int k = dshd.getN() - 1; k >= 0; k--)
                                        if (dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()))
                                            if (dshd.getDshd()[k] != null && dshd.getDshd()[k].getMaLK().equals(dslk.getDslk()[j].getMaLK()) && !dshd.getDshd()[k].getTrangThaiThanhToan())
                                                dshd.XoaHoaDon(k);
                                    dslk.XoaLichKham(j);
                                }
                            for (int j = i; j < n - 1; j++)
                                dspk[j] = dspk[j + 1];
                            dspk = Arrays.copyOf(dspk, n - 1);
                            n--;
                            PHONGKHAM.setCountPhongKham(PHONGKHAM.getCountPhongKham() - 1);
                            found = 1;
                        }
                    }
                    if (found == 0) {
                        if (tt == 1)
                            System.out.println("Khong tim thay phong kham da day de xoa");
                        else
                            System.out.println("Khong tim thay phong kham con trong de xoa");
                    } else {
                        if (tt == 1)
                            System.out.println("Da xoa phong kham da day ");
                        else
                            System.out.println("Da xoa phong kham con trong ");
                    }
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
            System.out.println("║             TIM KIEM PHONG KHAM           ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Tim Kiem theo Ma Phong Kham           ║");
            System.out.println("║  2. Tim Kiem theo Ten Phong Kham          ║");
            System.out.println("║  3. Tim Kiem theo Khoa                    ║");
            System.out.println("║  4. Tim Kiem theo So Luong                ║");
            System.out.println("║  5. Tim Kiem theo Trang thai              ║");
            System.out.println("║  0. Quay lai Menu Phong Kham              ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-5): ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    found = 0;
                    System.out.print("Nhap Ma Phong Kham can tim: ");
                    String mapk = sc.nextLine();
                    System.out.println("==== Danh sach phong kham ====");
                    for (int i = 0; i < n; i++)
                        if (dspk[i].getMaPK().toLowerCase().contains(mapk.toLowerCase())) {
                            System.out.println(dspk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay phong kham voi ma phong kham %s", mapk);
                    break;
                case 2:
                    found = 0;
                    System.out.print("Nhap Ten phong kham can tim: ");
                    String tenpk = sc.nextLine();
                    System.out.println("==== Danh sach phong kham ====");
                    for (int i = 0; i < n; i++)
                        if (dspk[i].getTenPK().toLowerCase().contains(tenpk.toLowerCase())) {
                            System.out.println(dspk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay phong kham voi ten phong kham %s", tenpk);
                    break;
                case 3:
                    found = 0;
                    System.out.print("Nhap Khoa can tim: ");
                    String khoa = sc.nextLine();
                    System.out.println("==== Danh sach phong kham ====");
                    for (int i = 0; i < n; i++)
                        if (dspk[i].getKhoa().toLowerCase().contains(khoa.toLowerCase())) {
                            System.out.println(dspk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0)
                        System.out.format("Khong tim thay phong kham voi khoa %s", khoa);
                    break;
                case 4:
                    found = 0;
                    System.out.print("Nhap So luong can tim: ");
                    int soluong = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Chon tieu chi tim kiem(lon|be|bang): ");
                    String tieuchi = sc.nextLine();
                    System.out.println("==== Danh sach phong kham ====");
                    if (tieuchi.equals("lon")) {
                        for (int i = 0; i < n; i++)
                            if (dspk[i].getSoLuong() > soluong) {
                                System.out.println(dspk[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay phong kham co so luong lon hon %d", soluong);
                    } else if (tieuchi.equals("be")) {
                        for (int i = 0; i < n; i++)
                            if (dspk[i].getSoLuong() < soluong) {
                                System.out.println(dspk[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay phong kham co so luong be hon %d", soluong);
                    } else if (tieuchi.equals("bang")) {
                        for (int i = 0; i < n; i++)
                            if (dspk[i].getSoLuong() == soluong) {
                                System.out.println(dspk[i]);
                                System.out.println("-----------------------------------------");
                                found = 1;
                            }
                        if (found == 0)
                            System.out.format("Khong tim thay phong kham co so luong bang %d", soluong);
                    } else
                        System.out.println("Nhap sai tieu chi!");
                    break;
                case 5:
                    found = 0;
                    System.out.print("Nhap Trang thai can tim(1:Da day/0:Trong): ");
                    int tt = sc.nextInt();
                    sc.nextLine();
                    System.out.println("==== Danh sach phong kham ====");
                    for (int i = 0; i < n; i++)
                        if (dspk[i].getTrangThai() == (tt == 1)) {
                            System.out.println(dspk[i]);
                            System.out.println("-----------------------------------------");
                            found = 1;
                        }
                    if (found == 0) {
                        if (tt == 1)
                            System.out.println("Khong tim thay phong kham da day");
                        else
                            System.out.println("Khong tim thay phong kham con trong");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chuc nang khong hop le! Vui long chon lai.");
                    break;
            }
        } while (c != 0);
    }

    public PHONGKHAM TimKiemTheoMa(String Ma) {
        for (int i = 0; i < n; i++)
            if (dspk[i].getMaPK().toLowerCase().contains(Ma.toLowerCase()))
                return dspk[i];
        return null;
    }

    public void XuatDS() {
        int c;
        if (n == 0) {
            System.out.println("Danh sach phong kham trong!");
            return;
        }
        System.out.println("\n╔═════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH PHONG KHAM                            ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════╝");
        for (int i = 0; i < n; i++) {
            System.out.println(dspk[i].toString());
            System.out.println("────────────────────────────────────────────────────────────────────────");
        }
        System.out.println("Tong so phong kham: " + n);
        do {
            System.out.print("Ban muon hien thi thong tin phong kham chi tiet khong ? (1.CO|0.KHONG): ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    int found = 0;
                    sc.nextLine();
                    System.out.print("Nhap MaPK ban muon hien thi: ");
                    String ma = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (dspk[i].getMaPK().equalsIgnoreCase(ma)) {
                            dspk[i].displayInfo();
                            found = 1;
                        }
                    }
                    if (found == 0)
                        System.out.format("Khong tim thay phong kham voi ma %s", ma);
                    break;
                default:
                    break;
            }
        } while (c != 0);
    }

    public void DocFile(String f) {
        try {
            dspk = new PHONGKHAM[0];
            n = 0;
            PHONGKHAM.setCountPhongKham(0);

            BufferedReader input = new BufferedReader(new FileReader(f));
            String line;
            while ((line = input.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] arr = line.split(",");
                    if (arr.length >= 5) {
                        try {
                            PHONGKHAM bs = new PHONGKHAM(arr[0].trim(), arr[1].trim(), arr[2].trim(),
                                    Integer.parseInt(arr[3].trim()), Boolean.parseBoolean(arr[4].trim()));
                            dspk = Arrays.copyOf(dspk, n + 1);
                            dspk[n] = bs;
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
                System.out.println("Doc du lieu thanh cong! Tong so phong kham: " + n);
            else
                System.out.println("Khong co du lieu hop le nao duoc doc tu file.");
        } catch (FileNotFoundException e) {
            System.out.println("File " + f + " chua ton tai. Se tao moi khi luu.");
            dspk = new PHONGKHAM[0];
            n = 0;
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void GhiFile(String f) {
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < n; i++) {
                fw.write(dspk[i].toFileString());
                fw.write("\n");
            }
            fw.close();
            System.out.println("Da luu " + n + " phong kham vao file.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
    public String Phongkhamduocchon(String chuyenkhoa){
        if (chuyenkhoa == null || chuyenkhoa.trim().isEmpty()) {
        System.out.println("Loi chuyen khoa khong hop le.");
        return "";
    }
    String khoaCanTim = chuyenkhoa.trim(); 
    for (int i = 0; i < n; i++) {
        if (dspk[i] == null) continue;
        if (dspk[i].getTrangThai() == true && dspk[i].getKhoa().trim().equalsIgnoreCase(khoaCanTim)) {
            return dspk[i].getMaPK();
        }
    }
    System.out.println("!!!Khong co phong kham kha dung cho khoa " + khoaCanTim + ".");
    return "";
    }
}
