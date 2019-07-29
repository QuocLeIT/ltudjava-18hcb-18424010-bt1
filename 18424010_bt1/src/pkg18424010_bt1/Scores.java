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
public class Scores {
    String mssv, name;
    String cla;// lop
    String nameSub;//mon
    float gk, ck, other, sumSco;
    
    public Scores(){
        mssv = "";
        name = "";
        cla = "";
        nameSub = "";
        gk = 0;
        ck= 0 ;
        other = 0;
        sumSco = 0;
    }
    
    public Scores(String _mssv, String _name, String _cla, String _nameSub, float _gk, float _ck, float _other, float _sumSco){
         mssv = _mssv.trim();
         name = _name.trim();
         cla = _cla.trim();
         nameSub = _nameSub.trim();
         gk = _gk;
         ck = _ck;
         sumSco = _sumSco;
         other = _other;
     }
    
    public Scores(String _lop, String _row){
         String[] words=_row.split(",\\s");
         mssv = words[1].trim();
         name = words[2].trim();
         
        gk = Float.parseFloat(words[3].trim());
        ck= Float.parseFloat(words[4].trim());
        other= Float.parseFloat(words[5].trim());
        sumSco= Float.parseFloat(words[6].trim());
        
        String[] words2=_lop.split("–");
        cla = words2[0].trim();
        nameSub = words2[1].trim();
     }
    
    public Scores(String _row){
         String[] words=_row.split(",\\s");
         mssv = words[0].trim();
         name = words[1].trim();
         
        gk = Float.parseFloat(words[2].trim());
        ck= Float.parseFloat(words[3].trim());
        other= Float.parseFloat(words[4].trim());
        sumSco= Float.parseFloat(words[5].trim());
        
        cla = words[6].trim();
        nameSub = words[7].trim();
     }
    
    public String GetInfoScores(){
         return mssv + ", " + name + ", " + gk + ", " + ck + ", " + other + ", " + sumSco + ", " + cla + ", " + nameSub;
     }
    
    public String GetInfoScoresPrint(){
         return mssv + ", " + name + ", GK: " + gk + ", CK: " + ck + ", Khac: " + other + ", Tong: " + sumSco + ", Lop: " + cla + "-" + nameSub;
     }
}
