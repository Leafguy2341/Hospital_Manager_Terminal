package manager;

import java.util.*;

import Classes_2.*;
import list.*;

public class QLDSTHUOC {
    public void menu(DSTHUOC ds) {
        Scanner sc = new Scanner(System.in);
        int choise;
        do {
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║              QUAN LY THUOC               ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║  1. Them thuoc moi                       ║");
            System.out.println("║  2. Xoa thuoc                            ║");
            System.out.println("║  3. Cap nhat thong tin thuoc             ║");
            System.out.println("║  4. Tim kiem thuoc                       ║");
            System.out.println("║  5. Hien thi danh sach thuoc             ║");
            System.out.println("║  6. Ghi du lieu thuoc                    ║");
            System.out.println("║  7. Doc du lieu thuoc                    ║");
            System.out.println("║  0. Quay lai Menu chinh                  ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-6): ");
            choise = sc.nextInt();
            sc.nextLine(); //nuốt enter
            
            switch(choise) {
                case 1:
                    System.out.println("\n====== DANG THEM THUOC ======");
                    THUOC th=new THUOC();
                    th.Nhap();
                    String newId = ds.taomoiMaTH();
                    th.setMaThuoc(newId);
                    ds.Them(th);
                    break;
                case 2:
                    System.out.println("\n====== DANG XOA THUOC ======");
                    ds.Xoa();
                    break;
                case 3:
                    String id1;
                    System.out.println("\n====== DANG CAP NHAT THUOC ======");
                    System.out.print("Nhap id Thuoc can CAP NHAT: ");
                    id1=sc.nextLine();
                    ds.CapNhat(id1);
                    break;
                case 4:
                    System.out.println("\n====== DANG TIM KIEM THUOC ======");
                    ds.TimKiem();
                    break;
                case 5:
                    ds.XuatDS();
                    break;
                case 6:
                    System.out.println("\n====== DANG GHI DU LIEU THUOC ======");
                    ds.GhiFile("data/thuoc.txt");
                    break;
                case 7:
                    System.out.println("\n====== DANG DOC DU LIEU THUOC ======");
                    ds.DocFile("data/thuoc.txt");
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
