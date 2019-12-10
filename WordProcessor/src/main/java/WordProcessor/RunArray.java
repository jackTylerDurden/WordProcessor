package WordProcessor;

import java.util.ArrayList;

public class RunArray{
    char[] text;
    int lastIndex;
    private ArrayList<CharacterFont> runList = new ArrayList<>();

    public RunArray(char[] text){
        this.text = text;
    }
    public void addRun(int startIndex, int runs, FontClass charFont){
        lastIndex = (startIndex + runs) - 1;
        runList.add(new CharacterFont(startIndex, lastIndex, charFont));

    }

    public void appendRun(int runs, FontClass charFont){
        int startIndex = lastIndex + 1;
        lastIndex = startIndex + runs - 1;
        runList.add(new CharacterFont(startIndex, lastIndex, charFont));
    }

    public FontClass getFont(int index){       
       for(CharacterFont charF : runList){
           if(charF.contains(index)){
               return charF.charFont;
           }
       }
       return null;
    }
}