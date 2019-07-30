/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18424010_bt1;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pkg18424010_bt1.WriteReadScores.WriteGenericScores;

/**
 *
 * @author Quoc Le
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void Menu(){
        System.out.println("1. Import danh sách lớp");
        System.out.println("2. Thêm 1 sv vào lớp 17HCB");
        System.out.println("3. Import thời khóa biểu");
        //System.out.println("4. Đăng ký/Hủy môn học");
        System.out.println("5. Xem danh sách lớp");//Lớp 18HCB, Lớp 18HCB-CTT001
        System.out.println("6. Xem lại thời khóa biểu 18HCB");
        System.out.println("7. Import bảng điểm 18HCB–CTT001");
        System.out.println("8. Xem lại bảng điểm");//Lớp 18HCB-CTT001, Cho biết ai đậu, ai rớt, Thống kê số lượng / phần trăm đậu / rớt
        System.out.println("9. Sửa điểm 1 sinh viên");//Lớp 18HCB-CTT001, Sửa điểm sv Hồ Thị E thành 9 9 9 9
        //System.out.println("10. Chỉ được xem điểm của mình");//Bạn Hồ Thị E xem điểm môn Java của mình
        //System.out.println("11. Đăng nhập, đăng xuất");//Giáo vụ: giaovu/giaovu, Sinh viên: 1842001/1842001
        //System.out.println("12. Đổi mật khẩu");
    }
    
    public static void MenuMain() {
        Menu();
        
        Scanner input = new Scanner(System.in);
        System.out.print("\r\nCHỌN CHỨC NĂNG: ");
        int n = input.nextInt();
        
        int back;
        
        switch(n) {
            case 1:     
              ImportDataClass();
              
              System.out.print("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break;
            case 2:
              AddStduent();
              //AddStduent_1742006();
                
              System.out.println("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break;
            case 3:
              ImportTKB_CSV();
              //AddStduent_1742006();
                
              System.out.println("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break;
            case 5:
              ViewListStudent();
                
              System.out.println("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break;
            case 6:
              ViewTKB();
                
              System.out.println("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break;   
            case 7:
              ImportScores();
                
              System.out.println("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break;
            case 8:
              ViewScores();
                
              System.out.println("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break; 
            case 9:
              EditScores();
                
              System.out.println("\r\nCHỌN 1. Quay lại menu, 0. Để thoát");
              back = input.nextInt();
              if (back == 1)
              {
                  MenuMain();
              }
              break; 
            
            default:
              // code block
          }
    }
    
    public static void ImportDataClass(){
        System.out.println("\r\n1. Import danh sách lớp");
       
        boolean isImport = WriteReadClassStudent.ImportCSV();
        
        if (isImport)
        {
            System.out.println("THÀNH CÔNG");
        }
        else
        {
            System.out.println("KHÔNG THÀNH CÔNG");
        }
    }
    
    public static void AddStduent(){
        System.out.println("\r\n2. Thêm 1 sv vào lớp 17HCB/18HCB");
        
        
        Scanner inputInt = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        String mssv, name = null, sex, cmnd, lop;
        
        
        System.out.print("Chọn lớp 1. 17HCB, 2. 18HCB: ");
        int n = inputInt.nextInt();
        
        System.out.print("MSSV:");
        mssv = input.nextLine();
        
        System.out.print("Ten:");
        name = input.nextLine();  
        
        
        System.out.print("GioiTinh 1.Nam, 0.Nữ:");
        n = inputInt.nextInt();
        
        System.out.print("CMND: ");
        cmnd = input.nextLine();
        
         if (n == 1)
        {
            lop = "17HCB";
        }else{
            lop = "18HCB";
        }
         
         if (n == 1)
        {
            sex = "Nam";
        }else{
            sex = "Nữ";
        }
        
        Student stu = new Student(mssv, name, sex, cmnd, lop);
        
        boolean isWrite = WriteReadClassStudent.WriteStudent(stu);
        if (isWrite)
        {
            System.out.println("\r\nTHÀNH CÔNG");
        }
        else
        {
            System.out.println("\r\nKHÔNG THÀNH CÔNG");
        }
        
    }
    
    public static void AddStduent_1742006 (){
        System.out.println("\r\n2. Thêm 1 sv vào lớp 17HCB");
       
        Student stu = new Student("1742006 ", "Trần Kiều X", "Nữ", "987612345 ", "17HCB");
        
        boolean isWrite = WriteReadClassStudent.WriteStudent(stu);
        if (isWrite)
        {
            System.out.println("\r\nTHÀNH CÔNG");
        }
        else
        {
            System.out.println("\r\nKHÔNG THÀNH CÔNG");
        }
        
    }
    
    public static void ImportTKB_CSV(){
        System.out.println("\r\n3. Import thời khóa biểu");
        boolean isImport = WriteReadTKB.ImportTKB_CSV();
        
        if (isImport)
        {
            System.out.println("THÀNH CÔNG");
        }
        else
        {
            System.out.println("KHÔNG THÀNH CÔNG");
        }
    }
    
    public static void ViewListStudent(){
        System.out.println("5. Xem danh sách lớp");//Lớp 18HCB, Lớp 18HCB-CTT001
        GenericStack<Student> gsStu = new GenericStack<>();
        gsStu = WriteReadClassStudent.ReadCLASSStudent();
        
        //18HCB
        System.out.println("Lớp 18HCB");
        int i;
        for (i = 0; i<= gsStu._data.size() - 1; i++)
        {  
            if ("18HCB".equals(gsStu._data.get(i).lop.trim())){
                System.out.println(gsStu._data.get(i).GetInfoStudent().trim());           
            }
        }
        
    }
    
    public static void ViewTKB(){
        System.out.println("6. Xem lại thời khóa biểu 18HCB");
        GenericStack<TKB> gsStu = new GenericStack<>();
        gsStu = WriteReadTKB.ReadTKB();
        
        System.out.println("Thoi khoa bieu 18HCB");
        int i;
        for (i = 0; i<= gsStu._data.size() - 1; i++)
        {  
            if ("18HCB".equals(gsStu._data.get(i).cla.trim())){
                System.out.println(gsStu._data.get(i).GetInfoTKB().trim());           
            }
        }
        
    }
    
    public static void ImportScores(){
        System.out.println("7. Import bảng điểm 18HCB–CTT001");
        boolean isImport = WriteReadScores.ImportScores_CSV();
        
        if (isImport)
        {
            System.out.println("THÀNH CÔNG");
        }
        else
        {
            System.out.println("KHÔNG THÀNH CÔNG");
        }
    }
    
    public static void ViewScores(){
        System.out.println("8. Xem lại bảng điểm");//Lớp 18HCB-CTT001, Cho biết ai đậu, ai rớt, Thống kê số lượng / phần trăm đậu / rớt
    
        GenericStack<Scores> gs = new GenericStack<>();
        gs = WriteReadScores.ReadScores();
        
        System.out.println("Bảng điểm 18HCB-CTT001");
        int i, d, r;
        d = 0;
        r = 0;
        String dr = "";
        for (i = 0; i<= gs._data.size() - 1; i++)
        {  
            if ("﻿18HCB".equals(gs._data.get(i).cla.trim()) && "CTT001".equals(gs._data.get(i).nameSub.trim())){
                if (gs._data.get(i).sumSco >= 5){
                    d++;
                    dr = ", Đậu";
                }else{
                    r++;
                    dr = ", Rớt";
                }
                         
                System.out.println(gs._data.get(i).GetInfoScoresPrint().trim() + dr);      
            }
        }
        
        System.out.println("Đậu: " + d + " - " + (d*100)/(d+r) + " %");  
        System.out.println("Rớt: " + r + " - " + (r*100)/(d+r)+ " %");  
    }
    
    public static void EditScores(){
        System.out.println("9. Sửa điểm 1 sinh viên Lớp 18HCB-CTT001, Sửa điểm sv Hồ Thị E thành 9 9 9 9");//
        
        Scores sco = new Scores("1742005", "Hồ Thị E", "18HCB", "CTT001", 9, 9, 9, 9);
        
        GenericStack<Scores> gs = new GenericStack<>();
        gs = WriteReadScores.ReadScores();
        
        int i;
        boolean t = false;
        for (i = 0; i<= gs._data.size() - 1; i++)
        {  
            if ("﻿18HCB".equals(gs._data.get(i).cla.trim()) && "CTT001".equals(gs._data.get(i).nameSub.trim()) && "1742005".equals(gs._data.get(i).mssv.trim()) ){
                gs._data.get(i).gk = 9;
                gs._data.get(i).ck = 9;
                gs._data.get(i).other = 9;
                gs._data.get(i).sumSco = 9;
                i = gs._data.size() - 1;
                t = true;
            }
        }
        
        if (t){
            boolean isWrite = WriteGenericScores(gs);
            if (isWrite)
           {
               System.out.println("THÀNH CÔNG");
           }
           else
           {
               System.out.println("KHÔNG THÀNH CÔNG");
           }
        }else{
            System.out.println("KHÔNG CÓ TÌM ĐƯỢC THÔNG TIN");
        }
        
        
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        MenuMain();
    }
    
}
