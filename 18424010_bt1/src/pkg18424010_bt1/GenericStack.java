/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18424010_bt1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Quoc Le
 * @param <T>
 */
public class GenericStack<T> {
    //T[] _data = (T[]) new Object[100];
    int _curIndex = -1;
    List<T> _data = new ArrayList<>();
    
    public void Push (T value){
        _data.add(value);
    }
    
    public T Pop(){
        return _data.get(_data.size()-1);
    }
    
}
