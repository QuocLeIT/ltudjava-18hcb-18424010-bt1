/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18424010_bt1;

/**
 *
 * @author Quoc Le
 */
public class Student {
     String mssv;
     String name;
     String sex;
     String cmnd;
     String lop;
    
     public Student(){}
     
     public Student(String _mssv, String _name,String _sex,String _cmnd,String _lop){
         mssv = _mssv;
         name = _name;
         sex = _sex;
         cmnd = _cmnd;
         lop = _lop;
     }
     
     public Student(String _lop, String _row){
         String[] words=_row.split(",\\s");
         mssv = words[1];
         name = words[2];
         sex = words[3];
         cmnd = words[4];
         lop = _lop;
     }
     
}
