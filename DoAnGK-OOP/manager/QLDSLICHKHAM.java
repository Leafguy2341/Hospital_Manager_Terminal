package manager;

import java.util.*;

import Classes_2.*;
import list.*;

public class QLDSLICHKHAM {
    public void menu(DSLICHKHAM ds, DSBACSI dsbs, DSBENHNHAN dsbn, DSPHONGKHAM dspk, DSHOADON dshd) {
        Scanner sc = new Scanner(System.in);
        int choise;
        do {
            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║              QUAN LY LICH KHAM               ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  1. Them lich kham moi                       ║");
            System.out.println("║  2. Xoa lich kham                            ║");
            System.out.println("║  3. Cap nhat thong tin lich kham             ║");
            System.out.println("║  4. Tim kiem lich kham                       ║");
            System.out.println("║  5. Hien thi danh sach lich kham             ║");
            System.out.println("║  6. Ghi du lieu lich kham                    ║");
            System.out.println("║  7. Doc du lieu lich kham                    ║");
            System.out.println("║  0. Quay lai Menu chinh                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-7): ");
            choise = sc.nextInt();
            sc.nextLine(); //nuốt enter
            
            switch(choise) {
                case 1:
                    System.out.println("\n====== DANG THEM LICH KHAM ======");
                    LICHKHAM lk=new LICHKHAM();
                    lk.Nhap(dsbs,dsbn,dspk);
                    String newId = ds.taomoiMaLK();
                    lk.setMaLK(newId);
                    ds.Them(lk);
                    break;
                case 2:
                    System.out.println("\n====== DANG XOA LICH KHAM ======");
                    ds.Xoa();
                    break;
                case 3:
                    String id1;
                    System.out.println("\n====== DANG CAP NHAT LICH KHAM ======");
                    System.out.print("Nhap id Lich Kham can CAP NHAT: ");
                    id1=sc.nextLine();
                    ds.CapNhat(id1);
                    break;
                case 4:
                    System.out.println("\n====== DANG TIM KIEM LICH KHAM ======");
                    ds.TimKiem();
                    break;
                case 5:
                    ds.XuatDS();
                    break;
                case 6:
                    System.out.println("\n====== DANG GHI DU LIEU LICH KHAM ======");
                    ds.GhiFile("data/lichkham.txt");
                    break;
                case 7:
                    System.out.println("\n====== DANG DOC DU LIEU LICH KHAM ======");
                    ds.DocFile("data/lichkham.txt");
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
