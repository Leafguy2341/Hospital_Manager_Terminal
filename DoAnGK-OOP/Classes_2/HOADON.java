package Classes_2;

import java.util.*;

import list.DSHOADON;
import list.DSLICHKHAM;
import list.DSTHUOC;

public class HOADON {
    private String MaHD;
    private String MaLK;
    private List<String> DSMaThuoc;
    private List<Integer> DSSoLuongThuoc;
    private double TienThuoc;
    private double TongTien;
    private boolean TrangThaiThanhToan;
    private String NgayThanhToan;

    Scanner sc = new Scanner(System.in);
    private static int countHoaDon;

    public HOADON() {
    }

    public HOADON(String MaHD, String MaLK, List<String> DSMaThuoc, List<Integer> DSSoLuongThuoc, double TienThuoc,
            double TongTien, boolean TrangThaiThanhToan, String NgayThanhToan) {
        this.MaHD = MaHD;
        this.MaLK = MaLK;
        this.DSMaThuoc = new ArrayList<>(DSMaThuoc != null ? DSMaThuoc : new ArrayList<>());
        this.DSSoLuongThuoc = new ArrayList<>(DSSoLuongThuoc != null ? DSSoLuongThuoc : new ArrayList<>());
        this.TienThuoc = TienThuoc;
        this.TongTien = TongTien;
        this.TrangThaiThanhToan = TrangThaiThanhToan;
        this.NgayThanhToan = NgayThanhToan;
        countHoaDon++;
    }

    public HOADON(HOADON hd) {
        this.MaHD = hd.MaHD;
        this.MaLK = hd.MaLK;
        this.DSMaThuoc = new ArrayList<>(hd.DSMaThuoc != null ? hd.DSMaThuoc : new ArrayList<>());
        this.DSSoLuongThuoc = new ArrayList<>(hd.DSSoLuongThuoc != null ? hd.DSSoLuongThuoc : new ArrayList<>());
        this.TienThuoc = hd.TienThuoc;
        this.TongTien = hd.TongTien;
        this.TrangThaiThanhToan = hd.TrangThaiThanhToan;
        this.NgayThanhToan = hd.NgayThanhToan;
        countHoaDon++;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaLK() {
        return MaLK;
    }

    public List<String> getDSMaThuoc() {
        return DSMaThuoc;
    }

    public List<Integer> getDSSoLuongThuoc() {
        return DSSoLuongThuoc;
    }

    public double getTienThuoc() {
        return TienThuoc;
    }

    public double getTongTien() {
        return TongTien;
    }

    public boolean getTrangThaiThanhToan() {
        return TrangThaiThanhToan;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public static int getCountHoaDon() {
        return countHoaDon;
    }

    // Hàm set
    public void setMaHD(String MaHD) {
        if (MaHD.matches("^HD\\d{3}$")) {
            this.MaHD = MaHD;
        } else
            throw new IllegalArgumentException("Ma hoa don khong hop le");
    }

    public void setMaLK(String MaLK) {
        if (MaLK.matches("^LK\\d{3}$")) {
            this.MaLK = MaLK;
        } else
            throw new IllegalArgumentException("Ma lich kham khong hop le");
    }

    public void setTienThuoc(double TienThuoc) {
        if (TienThuoc >= 0)
            this.TienThuoc = TienThuoc;
        else
            throw new IllegalArgumentException("Tien thuoc khong hop le");
    }

    public void setTrangThaiThanhToan(boolean TrangThaiThanhToan) {
        if (TrangThaiThanhToan == true || TrangThaiThanhToan == false)
            this.TrangThaiThanhToan = TrangThaiThanhToan;
        else
            throw new IllegalArgumentException("Trang thai khong hop le");
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        if (NgayThanhToan.matches("^(19[2-9][5-9]|20[0-1][0-9]|202[0-5])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
            this.NgayThanhToan = NgayThanhToan;
        }
        else
            throw new IllegalArgumentException("Ngay thanh toan khong hop le");
    }

    public static void setCountHoaDon(int n) {
        countHoaDon = n;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public void ThanhToan() {
        TrangThaiThanhToan = true;
    }

    public void Nhap(DSHOADON dshd, DSTHUOC dsth, DSLICHKHAM dslk) {
        boolean Isvalid = false;
        do {
            System.out.print("Nhap Ma lich kham (hoac 'Q' de thoat): ");
            String MaLK = sc.nextLine();
            if (MaLK.equalsIgnoreCase("Q")) {
                System.out.println("Da thoat khoi viec nhap hoa don.");
                return;
            }
            try {
                setMaLK(MaLK);
                if (dslk.TimKiemTheoMa(MaLK) == null) {
                    System.out.println("MaLK khong ton tai trong DSLICHKHAM! Vui long nhap lai.");
                    continue;
                }
                if (!dslk.TimKiemTheoMa(MaLK).getTrangThai()) {
                    System.out.println("Lich kham chua hoan thanh, khong the them hoa don! Nhap lai MaLK khac.");
                    continue;
                }
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
            }
        } while (!Isvalid);

        DSMaThuoc = new ArrayList<>();
        DSSoLuongThuoc = new ArrayList<>();
        TienThuoc = 0.0;
        boolean tiepTuc = true;
        while (tiepTuc && DSMaThuoc.size() < 10) {
            boolean valid = false;
            do {
                System.out.print("Nhap ma thuoc: ");
                String maThuoc = sc.nextLine();

                THUOC thuoc = dsth.TimThuocTheoMa(maThuoc);
                if (thuoc == null) {
                    System.out.println("Ma thuoc khong ton tai! Vui long nhap lai.");
                    continue;
                }
                System.out.print("Nhap so luong: ");
                int soLuong = Integer.parseInt(sc.nextLine());
                if (soLuong > thuoc.getSoLuong()) {
                    System.out.println(
                            "So luong thuoc khong du! Con lai: " + thuoc.getSoLuong() + ". Vui long nhap lai.");
                    continue;
                }
                DSMaThuoc.add(maThuoc);
                DSSoLuongThuoc.add(soLuong);
                TienThuoc += thuoc.getDonGia() * soLuong;
                System.out.println("Debug Nhap(): Added maThuoc = " + maThuoc + ", soLuong = " + soLuong
                        + ", DSMaThuoc size = " + DSMaThuoc.size());
                valid = true;
            } while (!valid);
            System.out.print("Tiep tuc nhap thuoc khac? (y/n): ");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                tiepTuc = false;
            }
        }
        System.out.println("Debug Nhap() end: DSMaThuoc size = " + DSMaThuoc.size() + ", DSSoLuongThuoc size = "
                + DSSoLuongThuoc.size());

        LICHKHAM lk = dslk.TimKiemTheoMa(MaLK);
        if (lk != null) {
            TongTien = lk.getPhiKham() + TienThuoc;
        } else {
            TongTien = TienThuoc;
        }

        do {
            try {
                System.out.print("Trang thai thanh toan (1:Da thanh toan/0:Chua thanh toan): ");
                int tt = Integer.parseInt(sc.nextLine());
                TrangThaiThanhToan = (tt == 1);
                setTrangThaiThanhToan(TrangThaiThanhToan);
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
                System.out.print("Nhap ngay thanh toan(yyyy-mm-dd): ");
                NgayThanhToan = sc.nextLine();
                setNgayThanhToan(NgayThanhToan);
                Isvalid = true;
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
                System.out.println("Vui long nhap lai!");
                System.out.println("---------------------");
                Isvalid = false;
            }
        } while (!Isvalid);
    }

    public void LapHoaDon(DSTHUOC dsth) {
        if (TrangThaiThanhToan) {
            for (int i = 0; i < DSMaThuoc.size(); i++) {
                THUOC thuoc = dsth.TimThuocTheoMa(DSMaThuoc.get(i));
                if (thuoc != null)
                    thuoc.setSoLuong(thuoc.getSoLuong() - DSSoLuongThuoc.get(i));
            }
            System.out.println("Da lap hoa don va cap nhat so luong thuoc.");
        } else
            System.out.println("Hoa don chua duoc thanh toan!");
    }

    public void displayInfo(DSTHUOC dsth, DSLICHKHAM dslk) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("             HOA DON KHAM BENH");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("Ma hoa don: " + MaHD);
        System.out.println("Ma lich kham: " + MaLK);
        System.out.println("Ngay kham: " + (dslk.TimKiemTheoMa(MaLK) != null ? dslk.TimKiemTheoMa(MaLK).getNgayKham() : "Khong tim thay"));
        System.out.println("Chan doan: " + (dslk.TimKiemTheoMa(MaLK) != null ? dslk.TimKiemTheoMa(MaLK).getChanDoan() : "Khong tim thay"));
        System.out.println("───────────────────────────────────────────");
        System.out.println("Tien thuoc: " + String.format("%,.0f VND", TienThuoc));
        if (!DSMaThuoc.isEmpty()) {
            System.out.println("Danh sach thuoc:");
            for (int i = 0; i < DSMaThuoc.size(); i++)
                System.out.println(" - " + DSMaThuoc.get(i) +"("+ dsth.TimThuocTheoMa(DSMaThuoc.get(i)).getTenThuoc() + ") x" + DSSoLuongThuoc.get(i)+": "+ String.format("%,.0f VND",dsth.TimThuocTheoMa(DSMaThuoc.get(i)) != null ? dsth.TimThuocTheoMa(DSMaThuoc.get(i)).getDonGia() * DSSoLuongThuoc.get(i) : 0.0));
        }
        System.out.println("───────────────────────────────────────────");
        System.out.println("Phi kham: " + String.format("%,.0f VND",
                dslk.TimKiemTheoMa(MaLK) != null ? dslk.TimKiemTheoMa(MaLK).getPhiKham() : 0.0));
        System.out.println("TONG CONG: " + String.format("%,.0f VND", TongTien));
        System.out.println("Ngay thanh toan: " + NgayThanhToan);
        System.out.println("Trang thai: " + (TrangThaiThanhToan ? "Da Thanh toan" : "Chua thanh toan"));
        System.out.println("═══════════════════════════════════════════");
    }

    public String toFileString() {
        StringBuilder str = new StringBuilder();

        str.append(MaHD != null ? MaHD : "").append(",")
                .append(MaLK != null ? MaLK : "").append(",");

        str.append("[");
        if (DSMaThuoc != null && !DSMaThuoc.isEmpty()) {
            for (int i = 0; i < DSMaThuoc.size(); i++) {
                str.append(DSMaThuoc.get(i) != null ? DSMaThuoc.get(i) : "");
                if (i < DSMaThuoc.size() - 1)
                    str.append(",");
            }
        }
        str.append("],");

        str.append("[");
        if (DSSoLuongThuoc != null && !DSSoLuongThuoc.isEmpty()) {
            for (int i = 0; i < DSSoLuongThuoc.size(); i++) {
                str.append(DSSoLuongThuoc.get(i));
                if (i < DSSoLuongThuoc.size() - 1)
                    str.append(",");
            }
        }
        str.append("],");
        str.append(TienThuoc).append(",")
                .append(TongTien).append(",")
                .append(TrangThaiThanhToan).append(",")
                .append(NgayThanhToan != null ? NgayThanhToan : "");
        return str.toString();
    }

    @Override
    public String toString() {
        return String.format("Ma HD: %s | Ma LK: %s | Ngay: %s | Tong: %,.0f VND | TT: %s", MaHD, MaLK, NgayThanhToan,
                TongTien, TrangThaiThanhToan ? "Da thanh toan" : "Chua thanh toan");
    }
}
