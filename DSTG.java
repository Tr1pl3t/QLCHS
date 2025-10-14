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
import java.time.*;
import java.time.format.*;
import java.util.Arrays;

public class DSTG {
    private TACGIA[] tg;
    
    public DSTG(){
        tg = new TACGIA[0];
    }
    
    public DSTG(TACGIA[] tg){
        this.tg = tg;
    }
    
    public DSTG(DSTG dstg){
        this.tg = dstg.tg;
    }
    
    public TACGIA[] getTG(){
        return tg;
    }
    
    public void setTG(TACGIA[] tg){
        this.tg = tg;
    }
    
    public void chonChucNang()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int choice;
        while(true){
            System.out.println("""
                               Chon chuc nang can thuc hien!
                               1. Khoi tao danh sach
                               2. Them tac gia
                               3. Xoa tac gia
                               4. Sua thong tin tac gia
                               5. Xuat danh sach tac gia
                               6. Tim kiem tac gia
                               7. Sap xep theo ten
                               0. Thoat chuong trinh""");
            choice = Integer.parseInt(in.readLine());
            switch(choice){
                case 1: khoiTaoDS(); break;
                case 2: themTG(); break;
                case 3: xoaTG(); break;
                case 4: suaThongTin(); break;
                case 5: xuatDS(); break;
                case 6: timKiemTG(); break;
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
        
        tg = new TACGIA[soLuong];
        
        for(int i = 0; i < soLuong; i++){
            System.out.print("Nha xuat ban "+(i+1)+" - ");
            tg[i] = new TACGIA(); //khoi tao doi tuong
            tg[i].nhap();
            System.out.println("____________________________");
        }
    }
    
    public void xuatDS(){
        System.out.println("DANH SACH TAC GIA!");
        // In tiêu đề
        System.out.printf("%-10s %-25s %-15s %-20s %-40s\n",
                "Ma TG", "Ten TG", "Ngay Sinh", "Quoc Tich", "Tieu Su");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        // In danh sách
        for (TACGIA temp : tg) { // dsTG là danh sách các tác giả
            // Chuyển ngày sinh từ int[] sang dạng dd/mm/yyyy
            LocalDate d = temp.getNgaySinh();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf("%-10s %-25s %-15s %-20s %-40s\n",
                    temp.getMaTG(), temp.getTen(), d.format(fmt), temp.getQuocTich(), temp.getTieuSu());
        }
    }
    
    public void themTG()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Them bao nhieu tac gia: ");
        int soLuong = Integer.parseInt(in.readLine());
        tg = Arrays.copyOf(tg, tg.length+soLuong);
        for(int i = tg.length-soLuong; i < tg.length; i++){
            System.out.print("Nguoi thu "+(i+1)+" - ");
            tg[i] = new TACGIA(); //khoi tao doi tuong
            tg[i].nhap();
            System.out.println("____________________________");
        }
    }
    
    public void xoaTG()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        if (tg == null || tg.length == 0) {
            System.out.println("Danh sach rong, khong co gi de xoa!");
            return;
        }

        
        System.out.print("Nhap ma so TG can xoa: ");
        String temp = in.readLine();
        int check = -1;
        for(int i = 0; i < tg.length; i++){
            if(temp.equals(tg[i].getMaTG())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            for(int i = check; i < tg.length-1; i++){
                tg[i] = tg[i+1];
            }
            tg = Arrays.copyOf(tg, tg.length-1);
        }
        else{
            System.out.println("Ma so khong tim thay!");
        }
    }
    
    public void suaThongTin()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap ma so tac gia can sua: ");
        String temp = in.readLine();
        int check = -1;
        for(int i = 0; i < tg.length; i++){
            if(temp.equals(tg[i].getMaTG())){
                check = i;
                break;
            }
        }
        
        if(check != -1){
            tg[check].suaThongTin();
        }
        else{
            System.out.println("Ma so khong tim thay!");
        }
    }
    
    public void timKiemTG()throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap ma so tac gia can tim: ");
        String temp = in.readLine();
        
        for(int i = 0; i < tg.length; i++){
            if(temp.equals(tg[i].getMaTG())){
                tg[i].xuat();
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
                for(int i = 0; i < tg.length-1; i++){
                    for(int y = 0; y < tg.length-i-1; y++){
                        if(tg[y].getTen().compareToIgnoreCase(tg[y+1].getTen()) > 0){ //>0 -> str1 > str2
                            TACGIA temp = tg[y];
                            tg[y] = tg[y+1];
                            tg[y+1] = temp;
                        }
                        
                    }
                }
                return;
            }
            else if(choice == 2){
                for(int i = 0; i < tg.length-1; i++){
                    for(int y = 0; y < tg.length-i-1; y++){
                        if(tg[y].getTen().compareToIgnoreCase(tg[y+1].getTen()) < 0){ //<0 -> str1 < str2
                            TACGIA temp = tg[y];
                            tg[y] = tg[y+1];
                            tg[y+1] = temp;
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
