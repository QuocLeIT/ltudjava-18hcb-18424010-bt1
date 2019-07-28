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
public class TKB {
    String codeSub;
    String nameSub;
    String room;
    String cla;
     
    public TKB(){
        codeSub = "";
        nameSub = "";
        room = "";
        cla = "";
    }
    
    public TKB(String _codeSub, String _nameSub,String _room,String _cla){
         codeSub = _codeSub.trim();
         nameSub = _nameSub.trim();
         room = _room.trim();
         cla = _cla.trim();
     }
     
     public TKB(String _lop, String _row){
         String[] words=_row.split(",\\s");
         codeSub = words[1].trim();
         nameSub = words[2].trim();
         room = words[3].trim();
         cla = _lop.trim();
     }
     
     public TKB(String _row){
         String[] words=_row.split(",\\s");
         codeSub = words[0].trim();
         nameSub = words[1].trim();
         room = words[2].trim();
         cla = words[3].trim();
     }
     
     public String GetInfoTKB(){
         return codeSub + ", " + nameSub + ", " + room + ", " + cla;
     }
}
