package manager;

import java.util.*;

import Classes_2.*;
import list.*;

public class QLDSPHONGKHAM {
    public void menu(DSPHONGKHAM ds, DSLICHKHAM dslk, DSHOADON dshd) {
        Scanner sc = new Scanner(System.in);
        int choise;
        do {
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║              QUAN LY PHONG KHAM               ║");
            System.out.println("╠═══════════════════════════════════════════════╣");
            System.out.println("║  1. Them phong kham moi                       ║");
            System.out.println("║  2. Xoa phong kham                            ║");
            System.out.println("║  3. Cap nhat thong tin phong kham             ║");
            System.out.println("║  4. Tim kiem phong kham                       ║");
            System.out.println("║  5. Hien thi danh sach phong kham             ║");
            System.out.println("║  6. Ghi du lieu phong kham                    ║");
            System.out.println("║  7. Doc du lieu phong kham                    ║");
            System.out.println("║  0. Quay lai Menu chinh                       ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-7): ");
            choise = sc.nextInt();
            sc.nextLine(); // nuốt enter

            switch (choise) {
                case 1:
                    System.out.println("\n====== DANG THEM PHONG KHAM ======");
                    PHONGKHAM pk = new PHONGKHAM();
                    pk.Nhap();
                    String newId = ds.taomoiMaPK();
                    pk.setMaPK(newId);
                    ds.Them(pk);
                    break;
                case 2:
                    System.out.println("\n====== DANG XOA PHONG KHAM ======");
                    ds.Xoa(dslk, dshd);
                    break;
                case 3:
                    String id1;
                    System.out.println("\n====== DANG CAP NHAT PHONG KHAM ======");
                    System.out.print("Nhap id Phong Kham can CAP NHAT: ");
                    id1 = sc.nextLine();
                    ds.CapNhat(id1);
                    break;
                case 4:
                    System.out.println("\n====== DANG TIM KIEM PHONG KHAM ======");
                    ds.TimKiem();
                    break;
                case 5:
                    ds.XuatDS();
                    break;
                case 6:
                    System.out.println("\n====== DANG GHI DU LIEU PHONG KHAM ======");
                    ds.GhiFile("data/phongkham.txt");
                    break;
                case 7:
                    System.out.println("\n====== DANG DOC DU LIEU PHONG KHAM ======");
                    ds.DocFile("data/phongkham.txt");
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
