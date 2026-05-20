package manager;
import Classes_2.*;
import list.*;

import java.util.*;
public class GIAODIENBENHNHAN {
    private static Scanner sc = new Scanner(System.in);

    private static DSLICHKHAM dslk = new DSLICHKHAM();
    private static DSBENHNHAN dsbn = new DSBENHNHAN();
    private static DSPHONGKHAM dspk = new DSPHONGKHAM();
    private static DSBACSI dsbs = new DSBACSI();
    public GIAODIENBENHNHAN(){}
    
    public GIAODIENBENHNHAN(DSBENHNHAN dsbn, DSLICHKHAM dslk, DSBACSI dsbs, DSPHONGKHAM dspk) {
        this.dsbn = dsbn;
        this.dslk = dslk;
        this.dsbs = dsbs;
        this.dspk = dspk;
    }
    
    
    public void UIBENHNHAN(TAIKHOAN tk){
        BENHNHAN bn = dsbn.TimKiemTheoMa(tk.getId());
        
        int choice;
        do {
            System.out.println("\n" + "======================================================================");
            System.out.println("   XIN CHAO " + bn.getHoTen().toUpperCase());
            System.out.println("======================================================================");
            System.out.println("1. Doi mat khau");
            System.out.println("2. Dat lich kham");
            System.out.println("3. Huy lich kham");
            System.out.println("4. Xem lich kham da dat");
            System.out.println("5. Xem thong tin ca nhan");     
            System.out.println("0. Dang xuat");
            System.out.println("======================================================================");
            choice = sc.nextInt();
            //sc.nextLine();
            switch (choice) {
                case 1:
                    tk.Doipassword(tk,sc);
                    break;
                case 2:
                    dslk.Dangkylichkham(sc, bn, dsbs, dspk);
                    break;
                case 3:
                    sc.nextLine();
                    dslk.Huylichkham(bn,sc);
                    break;
                case 4:
                    dslk.xemlichkham(bn.getId());
                    break;
                case 5:
                    bn.displayInfo();
                case 0:
                    break;                    
                default:
                    System.out.println("Vui long nhap (0-4)");
                    break;
            }
        }while(choice !=0);
    }
}
