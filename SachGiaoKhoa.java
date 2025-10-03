import java.util.Scanner;

public class SachGiaoKhoa extends Sach {
    private String lop;
    private String monHoc;

    public SachGiaoKhoa() {

    }

    public SachGiaoKhoa(String maSach, String tenSach, String theLoai, int namXuatBan, int donGiaBan, int soLuong,
            String lop, String monHoc) {
        super(maSach, tenSach, theLoai, namXuatBan, donGiaBan, soLuong);
        this.lop = lop;
        this.monHoc = monHoc;
    }

    public SachGiaoKhoa(SachGiaoKhoa stk) {
        super((Sach) stk);
        this.lop = stk.lop;
        this.monHoc = stk.monHoc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    @Override
    public void nhapSach() {
        Scanner sc = new Scanner(System.in);
        super.nhapSach();
        System.out.print("Nhap lop: ");
        lop = sc.nextLine();
        System.out.print("Nhap mon hoc: ");
        monHoc = sc.nextLine();
    }

    @Override
    public void xuatSach() {
        super.xuatSach();
        System.out.printf(" %-5s %-10s %-10s %-10s\n", lop, monHoc, "-", "-");
    }
}