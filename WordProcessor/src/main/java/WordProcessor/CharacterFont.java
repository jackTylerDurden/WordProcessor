/*
    Name - Tanmay Deshpande
    Red Id - 824646024
    Subject - CS 635 Advanced Object-Oriented Design & Programming
 */
package WordProcessor;

public class CharacterFont{
    private int startIndex;
    private int endIndex;
    FontClass charFont;


    public CharacterFont(int startIndex, int endIndex, FontClass charFont){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.charFont = charFont;
    }

    public boolean contains(int index){
        return (index >= startIndex && index <= endIndex);
    }
}