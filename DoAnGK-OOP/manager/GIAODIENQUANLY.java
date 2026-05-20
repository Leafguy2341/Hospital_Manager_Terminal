package manager;

import java.util.Scanner;

import Classes_2.TAIKHOAN;
import list.*;

public class GIAODIENQUANLY {
    private static DSBENHNHAN dsbn;
    private static DSLICHKHAM dslk;
    private static DSBACSI dsbs;
    private static DSPHONGKHAM dspk;
    private static DSHOADON dshd;
    private static DSTHUOC dsth;
    private static DSTAIKHOAN dstk;
    
    public GIAODIENQUANLY(DSBENHNHAN dsbn, DSLICHKHAM dslk, DSBACSI dsbs, DSPHONGKHAM dspk,DSHOADON dshd,DSTHUOC dst, DSTAIKHOAN dstk){
        this.dsbn = dsbn;
        this.dslk = dslk;
        this.dsbs = dsbs;
        this.dspk = dspk;
        this.dshd = dshd;
        this.dsth = dst;
        this.dstk = dstk;
    }
    public  void UIQUANLY(TAIKHOAN tk){
        Scanner sc = new Scanner(System.in);
        int choise;
        
        do {
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║             QUAN LY BENH VIEN             ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  1. Quan Ly Bac Si                        ║");
            System.out.println("║  2. Quan Ly Benh Nhan                     ║");
            System.out.println("║  3. Quan Ly Phong Kham                    ║");
            System.out.println("║  4. Quan Ly Thuoc                         ║");
            System.out.println("║  5. Quan Ly Lich Kham                     ║");
            System.out.println("║  6. Quan Ly Hoa Don                       ║");
            System.out.println("║  0. Thoat Chuong Trinh                    ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Chon chuc nang (0-6): ");
            choise = sc.nextInt();
            switch(choise) {
                case 1:
                    QLDSBACSI qlbs=new QLDSBACSI();
                    qlbs.menu(dsbs,dslk,dshd,dstk);
                    break;
                case 2:
                    QLDSBENHNHAN qlbn=new QLDSBENHNHAN();
                    qlbn.menu(dsbn,dstk);
                    break;
                case 3:
                    QLDSPHONGKHAM qlpk=new QLDSPHONGKHAM();
                    qlpk.menu(dspk,dslk,dshd);
                    break;
                case 4:
                    QLDSTHUOC qlth=new QLDSTHUOC();
                    qlth.menu(dsth);
                    break;
                case 5:
                    QLDSLICHKHAM qllk=new QLDSLICHKHAM();
                    qllk.menu(dslk,dsbs,dsbn,dspk,dshd);
                    break;
                case 6:
                    QLDSHOADON qlhd=new QLDSHOADON();
                    qlhd.menu(dshd,dsth,dslk);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Chuc nang khong hop le. Vui long chon lai");
                    break;
            }
        }while(choise!=0);
        sc.close();
    }
}
