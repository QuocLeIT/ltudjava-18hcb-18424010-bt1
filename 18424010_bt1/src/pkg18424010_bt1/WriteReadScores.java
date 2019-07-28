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
public class WriteReadScores {
    static String pathScores = "SCORES.txt";
    static String pathScoresCSV = "SCORESCSV.txt";
    
    public static boolean WriteGenericScores(GenericStack<Scores> gs){
        boolean re = true;
        FileWriter fw = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        
        try
        {
            File fileClass = new File(pathScores);
            if (!fileClass.exists())
                fileClass.createNewFile();
            
            fw = new FileWriter(fileClass.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            
            int i;
            for (i = 0; i <= gs._data.size() - 1; i++)
            {
		bw.write(gs._data.get(i).GetInfoScores() + "\r\n");		
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
    
    public static boolean ImportScores_CSV() {
        //String pathCSV = "CSV.txt";
        File file = new File(pathScoresCSV);
        
        if (!file.exists())
            return false;
        
         GenericStack<Scores> gsTKB = new GenericStack<>();
        FileReader fr = null;
        String row = "";
        String lop = "";
        
        try {    
            fr = new FileReader(file.getAbsoluteFile());
                    
            while (true){
		int i = fr.read();
		if (i==-1)
                {
                   gsTKB.Push(new Scores(lop, row));
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
                        gsTKB.Push(new Scores(lop, row));
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
        
            boolean isWrite = WriteGenericScores(gsTKB);
            
            return isWrite;
        } catch (Exception e) {
		//ex.printStackTrace();
                return false;
	}
    }
    
    public static GenericStack<Scores> ReadScores() {
        //String pathCSV = "CSV.txt";
        File file = new File(pathScores);
        
        if (!file.exists())
            return null;
        
        GenericStack<Scores> gs = new GenericStack<>();
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
                    gs.Push(new Scores(row));
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
        return gs;
    }
}
