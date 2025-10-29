/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlchs;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.util.Arrays;

public class DSNXB {
    private NhaXuatBan[] dsNXB;
    
    public DSNXB(){
        dsNXB = new NhaXuatBan[0];
    }
    
    public DSNXB(NhaXuatBan[] dsNXB){
        this.dsNXB = dsNXB;
    }
    
    public DSNXB(DSNXB dsdsNXB){
        dsNXB = dsdsNXB.dsNXB;
    }
    
    public NhaXuatBan[] getNXB(){
        return dsNXB;
    }
    
    public void setNXB(NhaXuatBan[] temp){
        dsNXB = temp;
    }
    
    //nhap, xuat, them/xoa, sort by name, tim kiem
    
    public void chonChucNang()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int choice;
        while(true){
            System.out.println("""
                               Chon chuc nang can thuc hien!
                               1. Khoi tao danh sach
                               2. Them nha xuat ban
                               3. Xoa nha xuat ban
                               4. Sua thong tin nha xuat ban
                               5. Xuat danh sach nha xuat ban
                               6. Tim kiem nha xuat ban
                               7. Sap xep theo ten
                               8. Lay du lieu tu file
                               0. Thoat chuong trinh (Tu dong ghi de du lieu vao file)""");
            choice = Integer.parseInt(in.readLine());
            switch(choice){
                case 1: khoiTaoDS(); break;
                case 2: themNXB(); break;
                case 3: xoaNXB(); break;
                case 4: suaThongTin(); break;
                case 5: xuatDS(); break;
                case 6: timKiemNXB(); break;
                case 7: sortByTen(); break;
                case 8: docFile(); break;
                case 0:{
                    ghiFile();
                    return;
                }
                default: System.out.println("Cu phap khong dung, hay nhap lai!"); break;
            }
        }
    }
    
    public void docFile()throws Exception{
        try{
            FileReader fr = new FileReader("DanhSachNhaXuatBan.txt");
            BufferedReader in = new BufferedReader(fr);
            
            String line;
            while((line = in.readLine()) != null){//kiểm tra còn dữ liệu
                line = line.trim();
                if(line.isEmpty()) continue; // bỏ qua dòng trống
                
                String[] temp = line.split(",");
                if(temp.length == 5){ //kiểm tra có đúng format
                    NhaXuatBan nxb = new NhaXuatBan();
                    nxb.setMaNXB(temp[0].trim());
                    nxb.setTenNXB(temp[1].trim());
                    String diaChi = temp[2].trim() + ", " + temp[3].trim() + ", " + temp[4].trim();
                    nxb.setDiaChi(diaChi);
                    
                    dsNXB = Arrays.copyOf(dsNXB, dsNXB.length+1);
                }
                else{
                    System.out.println("Sai format!");
                }
                
            } 
            in.close();
            fr.close();
        }
        catch(IOException e){
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
    
    public void ghiFile()throws Exception{
        try{
            FileWriter fw = new FileWriter("DanhSachNhaXuatBan.txt");
            BufferedWriter out = new BufferedWriter(fw);
            
            for(int i = 0; i < dsNXB.length; i++){
                NhaXuatBan nxb = dsNXB[i];
                
                out.write(nxb.getMaNXB() + ", " + nxb.getTenNXB() + ", " + nxb.getDiaChi());
                out.newLine();
            }
            out.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
    
    public void khoiTaoDS() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap so luong can khoi tao: ");
        int soLuong = Integer.parseInt(in.readLine());
        
        dsNXB = new NhaXuatBan[soLuong];
        
        for(int i = 0; i < soLuong; i++){
            System.out.print("Nha xuat ban "+(i+1)+" - ");
            dsNXB[i] = new NhaXuatBan(); //khoi tao doi tuong
            dsNXB[i].nhap();
            System.out.println("____________________________");
        }
    }
    
    public void xuatDS(){
        System.out.println("DANH SACH NHA XUAT BAN!");
        // In tieu de
        System.out.printf("%-10s %-30s %-30s\n",
                "Ma NXB", "Ten NXB", "Dia Chi");
        System.out.println("--------------------------------------------------------------------------");

        // In danh sach
        for (NhaXuatBan temp : dsNXB) {
            System.out.printf("%-10s %-30s %-30s\n",
                    temp.getMaNXB(), temp.getTenNXB(), temp.getDiaChi());
        }
    }
    
    public void themNXB()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Them bao nhieu nha xuat ban: ");
        int soLuong = Integer.parseInt(in.readLine());
        dsNXB = Arrays.copyOf(dsNXB, dsNXB.length+soLuong);
        for(int i = dsNXB.length-soLuong; i < dsNXB.length; i++){
            System.out.print("Nguoi thu "+(i+1)+" - ");
            dsNXB[i] = new NhaXuatBan(); //khoi tao doi tuong
            dsNXB[i].nhap();
            System.out.println("____________________________");
        }
    }
    
    public void xoaNXB() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach rong, khong co gi de xoa!");
            return;
        }

        
        System.out.print("Nhap ma so NXB can xoa: ");
        String temp = in.readLine();
        int check = -1;
        for(int i = 0; i < dsNXB.length; i++){
            if(temp.equals(dsNXB[i].getMaNXB())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            for(int i = check; i < dsNXB.length-1; i++){
                dsNXB[i] = dsNXB[i+1];
            }
            dsNXB = Arrays.copyOf(dsNXB, dsNXB.length-1);
        }
        else{
            System.out.println("Ma so khong tim thay!");
        }
    }
    
    public void suaThongTin()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap ma so nha xuat ban can sua: ");
        String temp = in.readLine();
        int check = -1;
        for(int i = 0; i < dsNXB.length; i++){
            if(temp.equals(dsNXB[i].getMaNXB())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            dsNXB[check].suaThongTin();
        }
        else{
            System.out.println("Ma so khong tim thay!");
        }
    }
    
    
    
    public void timKiemNXB()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap ma so nha xuat ban can tim: ");
        String temp = in.readLine();
        
        for(int i = 0; i < dsNXB.length; i++){
            if(temp.equals(dsNXB[i].getMaNXB())){
                dsNXB[i].xuat();
                return;
            }
        }
        
        System.out.println("Khong tim thay nhan vien can tim!"); 
    }
    
    public void sortByTen()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while(true){
            System.out.println("""
                           Ban muon sap xep theo kieu nao?
                           1. Sap xep A-z
                           2. Sap xep a-A
                           0. Khong sap xep""");
            choice = Integer.parseInt(in.readLine());
            if(choice == 1){
                for(int i = 0; i < dsNXB.length-1; i++){
                    for(int y = 0; y < dsNXB.length-i-1; y++){
                        if(dsNXB[y].getTenNXB().compareToIgnoreCase(dsNXB[y+1].getTenNXB()) > 0){ //>0 -> str1 > str2
                            NhaXuatBan temp = dsNXB[y];
                            dsNXB[y] = dsNXB[y+1];
                            dsNXB[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 2){
                for(int i = 0; i < dsNXB.length-1; i++){
                    for(int y = 0; y < dsNXB.length-i-1; y++){
                        if(dsNXB[y].getTenNXB().compareToIgnoreCase(dsNXB[y+1].getTenNXB()) < 0){ //<0 -> str1 < str2
                            NhaXuatBan temp = dsNXB[y];
                            dsNXB[y] = dsNXB[y+1];
                            dsNXB[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 0){
                return;
            }
            else{
                System.out.println("Cu phap khong dung, hay nhap lai!");
            }
        }
    }
    
}
