import java.util.Scanner;
public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String sDT;
    public NhaCungCap () {
    }
    public NhaCungCap(String maNCC,String tenNCC,String diaChi,String sDT) {
        this.maNCC=maNCC;
        this.tenNCC=tenNCC;
        this.diaChi=diaChi;
        this.sDT=sDT;
    }
    public NhaCungCap(NhaCungCap ncc) {
        this.maNCC=ncc.maNCC;
        this.tenNCC=ncc.tenNCC;
        this.diaChi=ncc.diaChi;
        this.sDT=ncc.sDT;
    }
    public void setmaNCC (String maNCC) {
        this.maNCC=maNCC;
    }
    public String getmaNCC () {
        return maNCC;
    }
    public void settenNCC(String tenNCC) {
        this.tenNCC=tenNCC;
    } 
    public String gettenNCC() {
        return tenNCC;
    }
    public void setdiaChi(String diaChi) {
        this.diaChi=diaChi;
    }
    public String getdiaChi() {
        return diaChi;
    }
    public void setsDT(String sDT) {
        this.sDT=sDT;
    }
    public String getsDT() {
        return sDT;
    }
    public void nhap () {
        Scanner sc=new Scanner (System.in);
        this.maNCC=sc.next();
        this.tenNCC=sc.nextLine();
        this.diaChi=nextLine();
        this.sDT=next();
    }
    public void xuat() {
        System.out.println("Ma NCC: " + maNCC);
        System.out.println("Ten NCC: " + tenNCC);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + sDT);
    }

}
