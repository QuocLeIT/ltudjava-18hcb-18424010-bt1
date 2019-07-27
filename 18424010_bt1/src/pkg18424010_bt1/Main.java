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
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static boolean ImportCSV()
    {
        try {
            String pathCSV = "CSV.txt";
            File file = new File(pathCSV);
            
            if (!file.exists()) {
                return false;
            }
                 
            FileReader fr = null;
            fr = new FileReader(file.getAbsoluteFile());
            
            String row = "";
            String lop = "";
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
	};
                   
        return true;
        } catch (IOException ex) {
		ex.printStackTrace();
                return false;
         }
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String path = "CLASS.txt";
        String pathCSV = "CSV.txt";
        
        GenericStack<Student> class17HCB = new GenericStack<>();
        GenericStack<Student> class18HCB = new GenericStack<>();
       
        ImportCSV();
        
        /*
        FileWriter fw = null;
        FileReader fr = null;
        BufferedWriter bw = null;

        try{
            File fileClass = new File(path);
            if (!fileClass.exists()) {
                   fileClass.createNewFile();
            }
            
            File file = new File(path);
            if (!file.exists()) {
		file.createNewFile();
            }
           

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            
            //bw.write(stu.mssv);
            //bw.write("\r\n");
            
             fr = new FileReader(file.getAbsoluteFile());
                while (true)
		{
			int i = fr.read();
			if (i==-1)
				break;
			char ch =(char) i;
			System.out.print(ch);
		}
		
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error opening file" + e.getMessage());
	}finally {
            try {
		if (bw != null)
                    bw.close();
                
		if (fw != null)
                    fw.close();
                
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
		ex.printStackTrace();
            }
	}
        */
        
    }
    
}
