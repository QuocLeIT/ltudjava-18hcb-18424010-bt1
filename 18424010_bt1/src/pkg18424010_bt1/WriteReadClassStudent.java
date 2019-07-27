/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18424010_bt1;

import java.io.*;
/**
 *
 * @author Quoc Le
 */
public class WriteReadClassStudent {
    
    public static boolean ImportCSV() {
        String pathCSV = "CSV.txt";
        File file = new File(pathCSV);
        
        if (!file.exists())
            return false;
        
         GenericStack<Student> classStu = new GenericStack<>();
        FileReader fr = null;
        String row = "";
        String lop = "";
        
        try {    
            fr = new FileReader(file.getAbsoluteFile());
                    
            while (true){
		int i = fr.read();
		if (i==-1)
                    break;
                
                //13: \r
                if (i == 10)
                {  
                    String[] words=row.split(",\\s");                    
                    String loai = "";
                    if (words.length > 2)
                    {
                        loai = "Student";
                        Student stu = new Student(lop, row);
                        classStu.Push(stu);
                    }
                    else{
                         loai = "Class";
                         lop = row;
                    }
                    
                    //System.out.println(loai + " - " + row);      
                    row= "";
                }
                else
                {
                    char ch =(char) i;
                    String str = Character.toString(ch);
                    row = row + str;
                }      
            }
            
            fr.close();
        
            WriteGenericStudent(classStu);
        
            return true;
        } catch (Exception e) {
              
		//ex.printStackTrace();
                return false;
	}
    }
    
    public static boolean WriteGenericStudent(GenericStack<Student> classStu){
        try
        {
            
        }
        catch (Exception e) {
            return false;
	}
        
        return true;
    }
    
}
