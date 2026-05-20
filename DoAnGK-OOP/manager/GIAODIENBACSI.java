package manager;
import Classes_2.*;
import list.*;

import java.util.*;
public class GIAODIENBACSI {
    private static Scanner sc = new Scanner(System.in);
    
    private static DSBENHNHAN dsbn;
    private static DSLICHKHAM dslk;
    private static DSBACSI dsbs;
    private static DSPHONGKHAM dspk;
    
    public GIAODIENBACSI(DSBENHNHAN dsbn, DSLICHKHAM dslk, DSBACSI dsbs, DSPHONGKHAM dspk) {
        this.dsbn = dsbn;
        this.dslk = dslk;
        this.dsbs = dsbs;
        this.dspk = dspk;
    }
    public GIAODIENBACSI(){}
    public void UIBACSI( TAIKHOAN tk){
        BACSI bs = dsbs.TimKiemTheoMa(tk.getId());
        int choice;
        do {
            System.out.println("\n" + "======================================================================");
            System.out.println("   XIN CHAO " + bs.getHoTen().toUpperCase());
            System.out.println("======================================================================");
            System.out.println("1. Doi mat khau");
            System.out.println("2. Xem lich kham");
            System.out.println("3. Xem thong tin ca nhan");            
            System.out.println("0. Dang xuat");
            System.out.println("======================================================================");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    tk.Doipassword(tk,sc);
                    break;
                case 2:
                    dslk.xemlichkham(tk.getId());
                    break;
                case 3:
                    bs.displayInfo();
                    break;
                case 0:
                    System.out.println("Hen gap lai bac si "+ bs.getHoTen().toUpperCase()+" !!!");
                    break;
                default:
                    System.out.println("Vui long nhap (0-3)");
                    break;
                
            }
        }while(choice !=0);
    }
}
