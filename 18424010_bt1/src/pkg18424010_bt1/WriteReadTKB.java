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
public class WriteReadTKB {
    static String pathTKB = "TKB.txt";
    static String pathTKBCSV = "TKBCSV.txt";
    
    public static boolean ImportTKB_CSV() {
        //String pathCSV = "CSV.txt";
        File file = new File(pathTKBCSV);
        
        if (!file.exists())
            return false;
        
         GenericStack<TKB> gsTKB = new GenericStack<>();
        FileReader fr = null;
        String row = "";
        String lop = "";
        
        try {    
            fr = new FileReader(file.getAbsoluteFile());
                    
            while (true){
		int i = fr.read();
		if (i==-1)
                {
                    TKB stu = new TKB(lop, row);
                   gsTKB.Push(stu);
                    break;
                }
                
                //13: \r
                if (i == 10)
                {  
                    String[] words=row.split(",\\s");                    
                    //String loai = "";
                    if (words.length > 2)
                    {
                        //loai = "TKB";
                        TKB stu = new TKB(lop, row);
                        gsTKB.Push(stu);
                    }
                    else{
                         //loai = "Class";
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
        
            boolean isWrite = WriteGenericTKB(gsTKB);
            
            return isWrite;
        } catch (Exception e) {
		//ex.printStackTrace();
                return false;
	}
    }
    
    public static boolean WriteGenericTKB(GenericStack<TKB> gsTKB){
        boolean re = true;
        FileWriter fw = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        
        try
        {
            File fileClass = new File(pathTKB);
            if (!fileClass.exists())
                fileClass.createNewFile();
            
            fw = new FileWriter(fileClass.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            
            int i;
            for (i = 0; i <= gsTKB._data.size() - 1; i++)
            {
		bw.write(gsTKB._data.get(i).GetInfoTKB() + "\r\n");			
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
    
    public static GenericStack<TKB> ReadTKB() {
        //String pathCSV = "CSV.txt";
        File file = new File(pathTKB);
        
        if (!file.exists())
            return null;
        
        GenericStack<TKB> classStu = new GenericStack<>();
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
                    classStu.Push(new TKB(row));
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
