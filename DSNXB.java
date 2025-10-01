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
    private NHAXUATBAN[] nxb;
    
    public DSNXB(){
        nxb = new NHAXUATBAN[0];
    }
    
    public DSNXB(NHAXUATBAN[] nxb){
        this.nxb = nxb;
    }
    
    public DSNXB(DSNXB dsnxb){
        nxb = dsnxb.nxb;
    }
    
    public NHAXUATBAN[] getNXB(){
        return nxb;
    }
    
    public void setNXB(NHAXUATBAN[] temp){
        nxb = temp;
    }
    
    //nhap, xuat, them/xoa, sort by name, tim kiem
    
    public void chonChucNang()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int choice;
        while(true){
            System.out.println("""
                               Chon chuc nang can thuc hien!
                               1. Khoi tao danh sach
                               2. Them nhan vien
                               3. Xoa nhan vien
                               4. Sua thong tin nhan vien
                               5. Xuat danh sach nhan vien
                               6. Tim kiem nhan vien
                               7. Sap xep theo ten
                               0. Thoat chuong trinh""");
            choice = Integer.parseInt(in.readLine());
            switch(choice){
                case 1: khoiTaoDS(); break;
                case 2: themNXB(); break;
                case 3: xoaNXB(); break;
                case 4: suaThongTin(); break;
                case 5: xuatDS(); break;
                case 6: timKiemNXB(); break;
                case 7: sortByTen(); break;
                case 0: return;
                default: System.out.println("Cu phap khong dung, hay nhap lai!"); break;
            }
        }
    }
    
    public void khoiTaoDS() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap so luong can khoi tao: ");
        int soLuong = Integer.parseInt(in.readLine());
        
        nxb = new NHAXUATBAN[soLuong];
        
        for(int i = 0; i < soLuong; i++){
            System.out.print("Nha xuat ban "+(i+1)+" - ");
            nxb[i] = new NHAXUATBAN(); //khoi tao doi tuong
            nxb[i].nhap();
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
        for (NHAXUATBAN temp : nxb) {
            System.out.printf("%-10s %-30s %-30s\n",
                    temp.getMaNXB(), temp.getTenNXB(), temp.getDiaChi());
        }
    }
    
    public void themNXB()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Them bao nhieu nha xuat ban: ");
        int soLuong = Integer.parseInt(in.readLine());
        nxb = Arrays.copyOf(nxb, nxb.length+soLuong);
        for(int i = nxb.length-soLuong; i < nxb.length; i++){
            System.out.print("Nguoi thu "+(i+1)+" - ");
            nxb[i] = new NHAXUATBAN(); //khoi tao doi tuong
            nxb[i].nhap();
            System.out.println("____________________________");
        }
    }
    
    public void xoaNXB() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        if (nxb == null || nxb.length == 0) {
            System.out.println("Danh sach rong, khong co gi de xoa!");
            return;
        }

        
        System.out.print("Nhap ma so NV can xoa: ");
        String temp = in.readLine();
        int check = -1;
        for(int i = 0; i < nxb.length; i++){
            if(temp.equals(nxb[i].getMaNXB())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            for(int i = check; i < nxb.length-1; i++){
                nxb[i] = nxb[i+1];
            }
            nxb = Arrays.copyOf(nxb, nxb.length-1);
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
        for(int i = 0; i < nxb.length; i++){
            if(temp.equals(nxb[i].getMaNXB())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            nxb[check].suaThongTin();
        }
        else{
            System.out.println("Ma so khong tim thay!");
        }
    }
    
    
    
    public void timKiemNXB()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap ma so nha xuat ban can tim: ");
        String temp = in.readLine();
        
        for(int i = 0; i < nxb.length; i++){
            if(temp.equals(nxb[i].getMaNXB())){
                nxb[i].xuat();
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
                for(int i = 0; i < nxb.length-1; i++){
                    for(int y = 0; y < nxb.length-i-1; y++){
                        if(nxb[y].getTenNXB().compareToIgnoreCase(nxb[y+1].getTenNXB()) > 0){ //>0 -> str1 > str2
                            NHAXUATBAN temp = nxb[y];
                            nxb[y] = nxb[y+1];
                            nxb[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 2){
                for(int i = 0; i < nxb.length-1; i++){
                    for(int y = 0; y < nxb.length-i-1; y++){
                        if(nxb[y].getTenNXB().compareToIgnoreCase(nxb[y+1].getTenNXB()) < 0){ //<0 -> str1 < str2
                            NHAXUATBAN temp = nxb[y];
                            nxb[y] = nxb[y+1];
                            nxb[y+1] = temp;
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
