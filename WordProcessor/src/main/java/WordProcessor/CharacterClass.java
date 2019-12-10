/*
    Name - Tanmay Deshpande
    Red Id - 824646024
    Subject - CS 635 Advanced Object-Oriented Design & Programming
 */
package WordProcessor;

public class CharacterClass implements CharacterInterface{
    private char charValue;
    // public FontClass charFont;

    public CharacterClass(char charValue){
        this.charValue = charValue;
    }

    @Override
    public Object setFont(FontClass charFont) {
        String setFontResult = "Character "+charValue+" has font "+charFont.font+" with style "+charFont.fontStyle+" and size "+charFont.fontSize;
        return setFontResult;
    }
}
