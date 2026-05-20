package manager;

import java.util.*;

import Classes_2.*;
import list.*;

public class QLDSHOADON {
    public void menu(DSHOADON ds, DSTHUOC dsth, DSLICHKHAM dslk) {
        Scanner sc = new Scanner(System.in);
        int choise;
        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║              QUAN LY HOA DON               ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Them hoa don moi                       ║");
            System.out.println("║  2. Xoa hoa don                            ║");
            System.out.println("║  3. Cap nhat thong tin hoa don             ║");
            System.out.println("║  4. Tim kiem hoa don                       ║");
            System.out.println("║  5. Hien thi danh sach hoa don             ║");
            System.out.println("║  6. Ghi du lieu hoa don                    ║");
            System.out.println("║  7. Doc du lieu hoa don                    ║");
            System.out.println("║  0. Quay lai Menu chinh                    ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-7): ");
            choise = sc.nextInt();
            sc.nextLine(); //nuốt enter
            
            switch(choise) {
                case 1:
                    System.out.println("\n====== DANG THEM HOA DON ======");
                    HOADON hd=new HOADON();
                    hd.Nhap(ds,dsth,dslk);
                    String newId = ds.taomoiMaHD();
                    hd.setMaHD(newId);
                    ds.Them(hd,dsth);
                    break;
                case 2:
                    System.out.println("\n====== DANG XOA HOA DON ======");
                    ds.Xoa();
                    break;
                case 3:
                    String id1;
                    System.out.println("\n====== DANG CAP NHAT HOA DON ======");
                    System.out.print("Nhap id Hoa Don can CAP NHAT: ");
                    id1=sc.nextLine();
                    ds.CapNhat(id1, dsth);
                    break;
                case 4:
                    System.out.println("\n====== DANG TIM KIEM HOA DON ======");
                    ds.TimKiem();
                    break;
                case 5:
                    ds.XuatDS(dsth,dslk);
                    break;
                case 6:
                    System.out.println("\n====== DANG GHI DU LIEU HOA DON ======");
                    ds.GhiFile("data/hoadon.txt");
                    break;
                case 7:
                    System.out.println("\n====== DANG DOC DU LIEU HOA DON ======");
                    ds.DocFile("data/hoadon.txt");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while(choise != 0);
    }
}
