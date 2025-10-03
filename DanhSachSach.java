import java.util.Scanner;

public class DanhSachSach {
    private int n;
    private Sach[] s;

    public DanhSachSach() {
        n = 0;
        s = null;
    }

    public void nhapSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach: ");
        n = sc.nextInt();

        s = new Sach[n];

        for (int i = 0; i < n; i++) {
            System.out.println("----- Nhap thong tin sach thu " + (i + 1) + " -----");
            int lc;
            do {
                System.out.print("Lua chon nhap (1. Sach giao khoa / 2. Sach tham khao): ");
                lc = sc.nextInt();
                if (lc != 1 && lc != 2) {
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                }
            } while (lc != 1 && lc != 2);

            if (lc == 1) {
                s[i] = new SachGiaoKhoa();
            } else {
                s[i] = new SachThamKhao();
            }

            s[i].nhapSach();
        }
    }

    public void xuatSach() {
        System.out.println("----- Danh sach sach -----");
        System.out.printf("%-10s %-10s %-10s %-20s %-20s %-10s %-5s %-10s %-10s %-10s\n", "Ma sach", "Ten sach",
                "The loai", "Nam xuat ban", "Don gia ban", "So luong", "Lop",
                "Mon hoc", "Linh vuc", "Trinh do");
        for (int i = 0; i < n; i++) {
            s[i].xuatSach();
        }
    }
}