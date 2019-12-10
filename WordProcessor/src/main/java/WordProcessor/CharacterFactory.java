/*
    Name - Tanmay Deshpande
    Red Id - 824646024
    Subject - CS 635 Advanced Object-Oriented Design & Programming
 */
package WordProcessor;
import java.util.HashMap;

public class CharacterFactory{
    private static final HashMap<Character, CharacterClass> charToCharacterMap = new HashMap<Character,CharacterClass>();
    
    public static CharacterClass getChar(char charVal){
        CharacterClass charClass = (CharacterClass) charToCharacterMap.get(charVal);        
        if(charClass == null){
            charClass = new CharacterClass(charVal);
            charToCharacterMap.put(charVal,charClass);
        }        
        return charClass;
    }
}