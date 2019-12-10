/*
    Name - Tanmay Deshpande
    Red Id - 824646024
    Subject - CS 635 Advanced Object-Oriented Design & Programming
 */
package WordProcessor;
import java.util.HashMap;
public class FontFactory{
    private static final HashMap<String,FontClass> charToFontMap = new HashMap<String,FontClass>();


    public static FontClass getFont(String font, String fontStyle, int fontSize){        
        FontClass fontClass = (FontClass) charToFontMap.get(font+fontStyle+fontSize);
        if(fontClass == null){
            fontClass = new FontClass(font,fontStyle,fontSize);
            charToFontMap.put(font+fontStyle+fontSize,fontClass);
        }
        return fontClass;    
    }

}