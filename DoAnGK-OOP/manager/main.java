package manager;

import java.util.Scanner;
import Classes_2.TAIKHOAN;
import list.*;

public class main {

    private static final DSTAIKHOAN dstk = new DSTAIKHOAN();
    private static final DSLICHKHAM dslk = new DSLICHKHAM();
    private static final DSBENHNHAN dsbn = new DSBENHNHAN();
    private static final DSPHONGKHAM dspk = new DSPHONGKHAM();
    private static final DSBACSI dsbs = new DSBACSI();
    private static final DSTHUOC dsthuoc = new DSTHUOC();
    private static final DSHOADON dshd = new DSHOADON();

    public static String getVaiTro(String id) {
        if (id == null || id.trim().length() < 2) {
            return "UNKNOWN";
        }
        String vaiTroCode = id.trim().substring(0, 2).toUpperCase();
        switch (vaiTroCode) {
            case "QL":
                return "QUANLY";
            case "BN":
                return "BENHNHAN";
            case "BS":
                return "BACSI";
            default:
                return "UNKNOWN";
        }
    }

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        final GIAODIENQUANLY uiQL = new GIAODIENQUANLY(dsbn, dslk, dsbs, dspk, dshd, dsthuoc, dstk);

        final GIAODIENBACSI uiBS = new GIAODIENBACSI(dsbn, dslk, dsbs, dspk);
        final GIAODIENBENHNHAN uiBN = new GIAODIENBENHNHAN(dsbn, dslk, dsbs, dspk);

        System.out.println("=====================================================");
        System.out.println("=== HE THONG QUAN LY BENH VIEN - KHOI DONG ===");
        System.out.println("=====================================================");

        System.out.println("-> Dang doc du lieu he thong...");

        dstk.DocFile("data/taikhoan.txt");
        dsbs.DocFile("data/bacsi.txt");
        dsbn.DocFile("data/benhnhan.txt");
        dslk.DocFile("data/lichkham.txt");
        dspk.DocFile("data/phongkham.txt");
        dsthuoc.DocFile("data/thuoc.txt");
        dshd.DocFile("data/hoadon.txt");

        System.out.println("-> Hoan tat du lieu.");

        TAIKHOAN tkDangNhap = null;
        boolean tiepTucChuongTrinh = true;

        while (tiepTucChuongTrinh) {
            System.out.println("\n------------------------------------------------------");
            System.out.println("MOI BAN DANG NHAP VAO HE THONG");
            System.out.println("------------------------------------------------------");

            tkDangNhap = dstk.DANGNHAP(sc);

            if (tkDangNhap != null) {
                String vaiTro = getVaiTro(tkDangNhap.getId());

                switch (vaiTro) {
                    case "QUANLY":
                        System.out.println("<<< Dang nhap thanh cong! Chuyen den giao dien QUAN LY >>>");
                        uiQL.UIQUANLY(tkDangNhap);
                        break;
                    case "BACSI":
                        System.out.println("<<< Dang nhap thanh cong! Chuyen den giao dien BAC SI >>>");
                        uiBS.UIBACSI(tkDangNhap);
                        break;
                    case "BENHNHAN":
                        System.out.println("<<< Dang nhap thanh cong! Chuyen den giao dien BENH NHAN >>>");
                        uiBN.UIBENHNHAN(tkDangNhap);
                        break;
                    default:
                        System.out.println("Loi: khong xac dinh duoc vai tro  (" + tkDangNhap.getId()
                                + "). Vui long kiem tra lai ID.");
                        break;
                }
                System.out.println("\n------------------------------------------------------");

                dstk.GhiFile("data/taikhoan.txt");
                dsbs.GhiFile("data/bacsi.txt");
                dsbn.GhiFile("data/benhnhan.txt");
                dslk.GhiFile("data/lichkham.txt");
                dspk.GhiFile("data/phongkham.txt");
                dsthuoc.GhiFile("data/thuoc.txt");
                dshd.GhiFile("data/hoadon.txt");
                
                System.out.print("Ban co muon tiep tuc dang nhap? (Y/N): ");
                String luaChon = sc.nextLine().trim().toUpperCase();
                if (!luaChon.equals("Y")) {
                    tiepTucChuongTrinh = false;
                }
            } else {
                System.out.println("\n!!! DANG NHAP THAT BAI !!!");
                System.out.print("Ban co muon thu lai? (Y/N): ");
                String luaChon = sc.nextLine().trim().toUpperCase();
                if (!luaChon.equals("Y")) {
                    tiepTucChuongTrinh = false;
                }
            }
        }
    }
}