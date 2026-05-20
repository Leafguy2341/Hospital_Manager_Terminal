package manager;

import java.util.*;

import Classes_2.*;
import list.*;

public class QLDSBENHNHAN {
    public void menu(DSBENHNHAN ds, DSTAIKHOAN dstk) {
        Scanner sc = new Scanner(System.in);
        int choise;
        do {
            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║              QUAN LY BENH NHAN               ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  1. Them benh nhan moi                       ║");
            System.out.println("║  2. Xoa benh nhan                            ║");
            System.out.println("║  3. Cap nhat thong tin benh nhan             ║");
            System.out.println("║  4. Tim kiem benh nhan                       ║");
            System.out.println("║  5. Hien thi danh sach benh nhan             ║");
            System.out.println("║  6. Ghi du lieu benh nhan                    ║");
            System.out.println("║  7. Doc du lieu benh nhan                    ║");
            System.out.println("║  0. Quay lai Menu chinh                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-7): ");
            choise = sc.nextInt();
            sc.nextLine(); //nuốt enter
            
            switch(choise) {
                case 1:
                    System.out.println("\n====== DANG THEM BENH NHAN ======");
                    BENHNHAN bn=new BENHNHAN();
                    bn.Nhap();
                    String newId = ds.taomoiMaBN();
                    bn.setId(newId);
                    ds.Them(bn,dstk);
                    break;
                case 2:
                    System.out.println("\n====== DANG XOA BENH NHAN ======");
                    ds.Xoa();
                    break;
                case 3:
                    String id1;
                    System.out.println("\n====== DANG CAP NHAT BENH NHAN ======");
                    System.out.print("Nhap id Benh Nhan can CAP NHAT: ");
                    id1=sc.nextLine();
                    ds.CapNhat(id1);
                    break;
                case 4:
                    System.out.println("\n====== DANG TIM KIEM BENH NHAN ======");
                    ds.TimKiem();
                    break;
                case 5:
                    ds.XuatDS();
                    break;
                case 6:
                    System.out.println("\n====== DANG GHI DU LIEU BENH NHAN ======");
                    ds.GhiFile("data/benhnhan.txt");
                    break;
                case 7:
                    System.out.println("\n====== DANG DOC DU LIEU BENH NHAN ======");
                    ds.DocFile("data/benhnhan.txt");
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
