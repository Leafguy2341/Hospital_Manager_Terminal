package Classes_2;

import java.util.Scanner;

import list.*;

public class LICHKHAM {
    private String MaLK;
    private String MaBN;
    private String MaBS;
    private String MaPK;
    private String NgayKham;
    private String GioKham;
    private double PhiKham;
    private boolean TrangThai;
    private String ChanDoan;
    Scanner sc = new Scanner(System.in);
    private static int countLichKham;

    public LICHKHAM() {
    }

    public LICHKHAM(String MaLK, String MaBN, String MaBS, String MaPK, String NgayKham, String GioKham, double PhiKham,
            boolean TrangThai, String ChanDoan) {
        this.MaLK = MaLK;
        this.MaBN = MaBN;
        this.MaBS = MaBS;
        this.MaPK = MaPK;
        this.NgayKham = NgayKham;
        this.GioKham = GioKham;
        this.PhiKham = PhiKham;
        this.TrangThai = TrangThai;
        this.ChanDoan = ChanDoan;
        countLichKham++;
    }

    public LICHKHAM(LICHKHAM lk) {
        this.MaLK = lk.MaLK;
        this.MaBN = lk.MaBN;
        this.MaBS = lk.MaBS;
        this.MaPK = lk.MaPK;
        this.NgayKham = lk.NgayKham;
        this.GioKham = lk.GioKham;
        this.PhiKham = lk.PhiKham;
        this.TrangThai = lk.TrangThai;
        this.ChanDoan = lk.ChanDoan;
        countLichKham++;
    }

    public String getMaLK() {
        return MaLK;
    }

    public void setMaLK(String MaLK) {
        if (MaLK.matches("^LK\\d{3}$")) {
            this.MaLK = MaLK;
        } else
            throw new IllegalArgumentException("Ma lich kham khong hop le");
    }

    public String getMaBN() {
        return MaBN;
    }

    public void setMaBN(String MaBN) {
        if (MaBN.matches("^BN\\d{3}$"))
            this.MaBN = MaBN;
        else
            throw new IllegalArgumentException("Ma benh nhan khong hop le");
    }

    public String getMaBS() {
        return MaBS;
    }

    public void setMaBS(String MaBS) {
        if (MaBS.matches("^BS\\d{3}$"))
            this.MaBS = MaBS;
        else
            throw new IllegalArgumentException("Ma bac si khong hop le");
    }

    public String getMaPK() {
        return MaPK;
    }

    public void setMaPK(String MaPK) {
        if (MaPK.matches("^PK\\d{3}$"))
            this.MaPK = MaPK;
        else
            throw new IllegalArgumentException("Ma phong kham khong hop le");
    }

    public String getNgayKham() {
        return NgayKham;
    }

    public void setNgayKham(String NgayKham) {
        if (NgayKham.matches("^(19[2-9][5-9]|20[0-1][0-9]|202[0-5])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$"))
            this.NgayKham = NgayKham;
        else
            throw new IllegalArgumentException("Ngay kham khong hop le");
    }

    public double getPhiKham() {
        return PhiKham;
    }

    public void setPhiKham(double PhiKham) {
        if (PhiKham >= 0)
            this.PhiKham = PhiKham;
        else
            throw new IllegalArgumentException("Phi kham khong hop le");
    }

    public String getGioKham() {
        return GioKham;
    }

    public void setGioKham(String GioKham) {
        if (GioKham != null && GioKham.matches("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$"))
            this.GioKham = GioKham;
        else
            throw new IllegalArgumentException("Gio kham khong hop le");
    }

    public boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        if (TrangThai == true || TrangThai == false)
            this.TrangThai = TrangThai;
        else
            throw new IllegalArgumentException("Trang thai khong hop le");
    }

    public String getChanDoan() {
        return ChanDoan;
    }

    public void setChanDoan(String ChanDoan) {
        if (ChanDoan.matches("^[a-zA-Z\\s,./-]{1,256}$")) {
            this.ChanDoan = ChanDoan;
        } else
            throw new IllegalArgumentException("Chan Doan khong duoc co ky tu dac biet hoac so");
    }

    public static int getCountLichKham() {
        return countLichKham;
    }

    public static void setCountLichKham(int count) {
        countLichKham = count;
    }

    public void Nhap(DSBACSI dsbs, DSBENHNHAN dsbn, DSPHONGKHAM dspk) {
        boolean Isvalid = false;
        do {
            System.out.print("Nhap Ma benh nhan (hoac 'Q' de thoat): ");
            String MaBN = sc.nextLine();
            if (MaBN.equalsIgnoreCase("Q")) {
                System.out.println("Da thoat khoi viec nhap lich kham.");
                return;
            }
            try {
                setMaBN(MaBN);
                if (dsbn.TimKiemTheoMa(MaBN) == null) {
                    System.out.println("MaBN khong ton tai trong DSBENHNHAN! Vui long nhap lai.");
                    continue;
                }
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
            }
        } while (!Isvalid);

        Isvalid = false;
        do {
            System.out.print("Nhap Ma bac si (hoac 'Q' de thoat): ");
            String MaBS = sc.nextLine();
            if (MaBS.equalsIgnoreCase("Q")) {
                System.out.println("Da thoat khoi viec nhap lich kham.");
                return;
            }
            try {
                setMaBS(MaBS);
                if (dsbs.TimKiemTheoMa(MaBS) == null) {
                    System.out.println("MaBS khong ton tai trong DSBACSI! Vui long nhap lai.");
                    continue;
                }
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
            }
        } while (!Isvalid);

        Isvalid = false;
        do {
            System.out.print("Nhap Ma phong kham (hoac 'Q' de thoat): ");
            String MaPK = sc.nextLine();
            if (MaPK.equalsIgnoreCase("Q")) {
                System.out.println("Da thoat khoi viec nhap lich kham.");
                return;
            }
            try {
                setMaPK(MaPK);
                if (dspk.TimKiemTheoMa(MaPK) == null) {
                    System.out.println("MaPK khong ton tai trong DSPHONGKHAM! Vui long nhap lai.");
                    continue;
                }
                if (!dspk.TimKiemTheoMa(MaPK).getTrangThai()) {
                    System.out.println("Phong kham da day, khong the them lich kham! Vui long nhap lai MaPK khac.");
                    continue;
                }
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
            }
        } while (!Isvalid);
        do {
            try {
                System.out.print("Nhap Ngay kham(yyyy-mm-dd): ");
                NgayKham = sc.nextLine();
                setNgayKham(NgayKham);
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        } while (!Isvalid);
        do {
            try {
                System.out.print("Nhap Gio kham(00:00-23:59): ");
                GioKham = sc.nextLine();
                setGioKham(GioKham);
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        } while (!Isvalid);
        do {
            try {
                System.out.print("Nhap Phi kham: ");
                PhiKham = sc.nextDouble();
                setPhiKham(PhiKham);
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        } while (!Isvalid);
        do {
            try {
                System.out.print("Nhap Trang thai(1:Hoan thanh/0:Chua hoan thanh): ");
                int tt = sc.nextInt();
                sc.nextLine();
                TrangThai = (tt == 1);
                setTrangThai(TrangThai);
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        } while (!Isvalid);
        do {
            try {
                System.out.print("Nhap Chan doan: ");
                ChanDoan = sc.nextLine();
                setChanDoan(ChanDoan);
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        } while (!Isvalid);
    }

    public void displayInfo() {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("           THONG TIN LICH KHAM");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("Ma benh nhan: " + MaBN);
        System.out.println("Ma bac si: " + MaBS);
        System.out.println("Ma phong: " + MaPK);
        System.out.println("Ngay kham: " + NgayKham);
        System.out.println("Gio kham: " + GioKham);
        System.out.println("Phi kham: " + PhiKham);
        System.out.println("Trang thai: " + (TrangThai ? "Hoan thanh" : "Chua hoan thanh"));
        System.out.println("Chan doan: " + ChanDoan);
        System.out.println("═══════════════════════════════════════════");
    }

    public String toFileString() {
        return MaLK + "," + MaBN + "," + MaBS + "," + MaPK + "," + NgayKham + "," + GioKham + "," + PhiKham + ","
                + TrangThai + "," + ChanDoan;
    }

    @Override
    public String toString() {
        return String.format(
                "MaLK: %s | Ma BN: %s | Ma BS: %s | Phong: %s | Ngay: %s %s | Phi kham: %s| TT: %s | Chan doan: %s",
                MaLK, MaBN, MaBS, MaPK, NgayKham, GioKham, PhiKham, TrangThai ? "Hoan thanh" : "Dang cho", ChanDoan);
    }
}
