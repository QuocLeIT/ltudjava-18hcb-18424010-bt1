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
    
    static String pathCLASS = "CLASS.txt";
    static String pathCSV = "CSV.txt";
    
    public static boolean ImportCSV() {
        //String pathCSV = "CSV.txt";
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
                {
                    Student stu = new Student(lop, row);
                    classStu.Push(stu);
                    break;
                }
                
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
        
            boolean isWrite = WriteGenericStudent(classStu);
            
            return isWrite;
        } catch (Exception e) {
              
		//ex.printStackTrace();
                return false;
	}
    }
    
    public static boolean WriteStudent(Student stu){
        boolean re = true;
        FileWriter fw = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        
        try
        {
            File fileClass = new File(pathCLASS);
            if (!fileClass.exists())
                fileClass.createNewFile();
            
            fw = new FileWriter(fileClass.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            
            bw.write(stu.GetInfoStudent() + "\r\n");
        }
        catch (Exception e) {
            re = false;
	}finally {
            try {
		if (bw != null)
                    bw.close();
                
		if (fw != null)
                    fw.close();
                
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
		//ex.printStackTrace();
            }
	}
        
        return re;
    }
    
    public static boolean WriteGenericStudent(GenericStack<Student> classStu){
        boolean re = true;
        FileWriter fw = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        
        try
        {
            File fileClass = new File(pathCLASS);
            if (!fileClass.exists())
                fileClass.createNewFile();
            
            fw = new FileWriter(fileClass.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            
            int i;
            for (i = 0; i <= classStu._data.size() - 1; i++)
            {
		bw.write(classStu._data.get(i).GetInfoStudent() + "\r\n");			
            } 
            
        }
        catch (Exception e) {
            re = false;
	}finally {
            try {
		if (bw != null)
                    bw.close();
                
		if (fw != null)
                    fw.close();
                
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
		//ex.printStackTrace();
            }
	}
        
        return re;
    }
    
    
    public static GenericStack<Student> ReadCLASSStudent() {
        //String pathCSV = "CSV.txt";
        File file = new File(pathCLASS);
        
        if (!file.exists())
            return null;
        
        GenericStack<Student> classStu = new GenericStack<>();
        FileReader fr = null;
        String row = "";
        
        try {    
            fr = new FileReader(file.getAbsoluteFile());
                    
            while (true){
		int i = fr.read();
		if (i==-1)
                {
                    //classStu.Push(new Student(row));
                    break;
                }
                
                //13: \r
                if (i == 10)
                {  
                    classStu.Push(new Student(row));
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
           
        } catch (Exception e) {
            return null;
	}   
        return classStu;
    }
}
