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
         mssv = _mssv.trim();
         name = _name.trim();
         sex = _sex.trim();
         cmnd = _cmnd.trim();
         lop = _lop.trim();
     }
     
     public Student(String _lop, String _row){
         String[] words=_row.split(",\\s");
         mssv = words[1].trim();
         name = words[2].trim();
         sex = words[3].trim();
         cmnd = words[4].trim();
         lop = _lop.trim();
     }
     
     public Student(String _row){
         String[] words=_row.split(",\\s");
         mssv = words[0].trim();
         name = words[1].trim();
         sex = words[2].trim();
         cmnd = words[3].trim();
         lop = words[4].trim();
     }
     
     public String GetInfoStudent(){
         return mssv + ", " + name + ", " + sex + ", " + cmnd + ", " + lop;
     }
     
    
}
