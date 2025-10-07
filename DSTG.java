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
    
}
