import java.util.Scanner;

public class SachThamKhao extends Sach {
    private String linhVuc;
    private String trinhDo;

    public SachThamKhao() {
    }

    public SachThamKhao(String maSach, String tenSach, String theLoai, int namXuatBan, int donGiaBan, int soLuong,
            String linhVuc, String trinhDo) {
        super(maSach, tenSach, theLoai, namXuatBan, donGiaBan, soLuong);
        this.linhVuc = linhVuc;
        this.trinhDo = trinhDo;
    }

    public SachThamKhao(SachThamKhao sgk) {
        super((Sach) sgk);
        this.linhVuc = sgk.linhVuc;
        this.trinhDo = sgk.trinhDo;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public void nhapSach() {
        Scanner sc = new Scanner(System.in);
        super.nhapSach();
        System.out.print("Nhap linh vuc: ");
        linhVuc = sc.nextLine();
        System.out.print("Nhap trinh do: ");
        trinhDo = sc.nextLine();
    }

    @Override
    public void xuatSach() {
        super.xuatSach();
        System.out.printf(" %-5s %-10s %-10s %-10s\n", "-", "-", linhVuc, trinhDo);
    }
}