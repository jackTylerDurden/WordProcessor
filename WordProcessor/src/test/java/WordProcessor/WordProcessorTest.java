/*
    Name - Tanmay Deshpande
    Red Id - 824646024
    Subject - CS 635 Advanced Object-Oriented Design & Programming
 */
package WordProcessor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class WordProcessorTest{
    /**
     * Rigorous Test.
     */
    @Test
    public void testFlyweightMemoryUsage() {
        String testText = "CS 635 Advanced Object-Oriented Design & Programming Fall Semester, 2018 Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object Nov 19, 2019 Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license defines the copyright on this document. ";
        
        char[] charArray = testText.toCharArray();
        double memoryUsedWithFlyweight = new SizeofUtil(){
        
            @Override
            protected int create() { //24 bytes
                FontClass charFont = FontFactory.getFont("Times","Bold",10);                
                RunArray test = new RunArray(testText.toCharArray());
                test.addRun(0,250, charFont);

                charFont = FontFactory.getFont("Courier","Italic",15);                
                test.addRun(250,10, charFont);


                charFont = FontFactory.getFont("Times","Bold",10);                
                test.appendRun(97, charFont);                

                for(int i=0;i<charArray.length;i++){
                    char textChar = charArray[i];
                    CharacterClass charClass = CharacterFactory.getChar(textChar);
                    FontClass singleCharFont = test.getFont(i);
                    charClass.setFont(singleCharFont);
                }
                return 1;
            }
        }.averageBytes();
        //Memory used with implementing Flyweight is 24 bytes
        

        double memoryUsedWithoutFlyweight = new SizeofUtil(){ 
        
            @Override
            protected int create() {                
                FontClass charFont = new FontClass("Times","Bold",10);                
                RunArray test = new RunArray(testText.toCharArray());
                test.addRun(0,250, charFont);

                charFont = new FontClass("Courier","Italic",15);                
                test.addRun(250,10, charFont);


                charFont = new FontClass("Times","Bold",10);                
                test.appendRun(97, charFont);                

                for(int i=0;i<charArray.length;i++){
                    char textChar = charArray[i];
                    CharacterClass charClass = new CharacterClass (textChar);
                    FontClass singleCharFont = test.getFont(i);
                    charClass.setFont(singleCharFont);
                }
                return 1;
            }
        }.averageBytes();
        //Memory used without implementing Flyweight is 8568 bytes
        
        
        assertTrue(memoryUsedWithoutFlyweight > memoryUsedWithFlyweight);
    }


    @Test
    public void testCheckCharacter() {
        String testText = "Tanmay Deshpande";
        
        char[] charArray = testText.toCharArray();        
        CharacterClass charA1 = CharacterFactory.getChar(charArray[1]);
        CharacterClass charA2 = CharacterFactory.getChar(charArray[4]);
        assertEquals(charA1,charA2);        
    }



    @Test
    public void testCheckFont() {
        String testText = "CS 635 Advanced Object-Oriented Design & Programming Fall Semester, 2018 Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object Nov 19, 2019 Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license defines the copyright on this document. ";
        
        char[] charArray = testText.toCharArray();        
        FontClass charFont = FontFactory.getFont("Times","Bold",10);                
        RunArray test = new RunArray(testText.toCharArray());
        test.addRun(0,250, charFont);

        charFont = FontFactory.getFont("Courier","Italic",15);                
        test.addRun(250,10, charFont);


        charFont = FontFactory.getFont("Times","Bold",10);                
        test.appendRun(97, charFont);                

        assertEquals(test.getFont(0),test.getFont(249));
        
    }
}
