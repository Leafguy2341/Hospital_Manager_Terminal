package manager;

import java.util.*;

import Classes_2.*;
import list.*;

public class QLDSBACSI {
    public void menu(DSBACSI ds, DSLICHKHAM dslk, DSHOADON dshd, DSTAIKHOAN dstk) {
        Scanner sc = new Scanner(System.in);
        int choise;
        do {
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║              QUAN LY BAC SI               ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Them bac si moi                       ║");
            System.out.println("║  2. Xoa bac si                            ║");
            System.out.println("║  3. Cap nhat thong tin bac si             ║");
            System.out.println("║  4. Tim kiem bac si                       ║");
            System.out.println("║  5. Hien thi danh sach bac si             ║");
            System.out.println("║  6. Ghi du lieu bac si                    ║");
            System.out.println("║  7. Doc du lieu bac si                    ║");
            System.out.println("║  0. Quay lai Menu chinh                   ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-7): ");
            choise = sc.nextInt();
            sc.nextLine(); // nuốt dấu enter

            switch (choise) {
                case 1:
                    System.out.println("\n====== DANG THEM BAC SI ======");
                    BACSI bs = new BACSI();
                    bs.Nhap();
                    String newId = ds.taomoiMaBS();
                    bs.setId(newId);
                    ds.Them(bs,dstk);
                    break;
                case 2:
                    System.out.println("\n====== DANG XOA BAC SI ======");
                    ds.Xoa(dslk, dshd);
                    break;
                case 3:
                    String id1;
                    System.out.println("\n====== DANG CAP NHAT BAC SI ======");
                    System.out.print("Nhap id Bac Si can CAP NHAT: ");
                    id1 = sc.nextLine();
                    ds.CapNhat(id1);
                    break;
                case 4:
                    System.out.println("\n====== DANG TIM KIEM BAC SI ======");
                    ds.TimKiem();
                    break;
                case 5:
                    ds.XuatDS();
                    break;
                case 6:
                    System.out.println("\n====== DANG GHI DU LIEU BAC SI ======");
                    ds.GhiFile("data/bacsi.txt");
                    break;
                case 7:
                    System.out.println("\n====== DANG DOC DU LIEU BAC SI ======");
                    ds.DocFile("data/bacsi.txt");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (choise != 0);
    }
}
