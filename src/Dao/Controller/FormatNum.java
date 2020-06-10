/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Leandro Baroni
 */
public class FormatNum extends PlainDocument{
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
        super.insertString(offs, str.replaceAll("[^0,0-9,9]", ""), a);
    }
    
    public void insertOnlyNum(int offs, String str, AttributeSet a) throws BadLocationException{
        super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
    }    
}
