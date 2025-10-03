import java.util.Scanner;

public class Sach {
    protected String maSach;
    protected String tenSach;
    protected String theLoai;
    protected int namXuatBan;
    protected int donGiaBan;
    protected int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String theLoai, int namXuatBan, int donGiaBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.namXuatBan = namXuatBan;
        this.donGiaBan = donGiaBan;
        this.soLuong = soLuong;
    }

    public Sach(Sach s) {
        this.maSach = s.maSach;
        this.tenSach = s.tenSach;
        this.theLoai = s.theLoai;
        this.namXuatBan = s.namXuatBan;
        this.donGiaBan = s.donGiaBan;
        this.soLuong = s.soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(int donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void nhapSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap the loai: ");
        theLoai = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = sc.nextInt();
        System.out.print("Nhap don gia ban: ");
        donGiaBan = sc.nextInt();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();
    }

    public void xuatSach() {
        System.out.printf("%-10s %-10s %-10s %-20s %-20s %-10s", maSach, tenSach, theLoai, namXuatBan, donGiaBan,
                soLuong);
    }
}