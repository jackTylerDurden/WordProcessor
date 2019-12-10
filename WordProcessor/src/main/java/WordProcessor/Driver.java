package WordProcessor;
/**
 * Hello world!
 */
public final class Driver {
    private Driver() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String testText = "CS 635 Advanced Object-Oriented Design & Programming Fall Semester, 2018 Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object Nov 19, 2019 Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license defines the copyright on this document. ";
        
        char[] charArray = testText.toCharArray();
        double memoryUsedWithFlyWeight = new SizeofUtil(){
        
            @Override
            protected int create() {
                // FontClass charFont = FontFactory.getFont("Times","Bold",10);                
                // RunArray test = new RunArray(testText.toCharArray());
                // test.addRun(0,250, charFont);

                // charFont = FontFactory.getFont("Courier","Italic",15);                
                // test.addRun(250,10, charFont);


                // charFont = FontFactory.getFont("Times","Bold",10);                
                // test.appendRun(97, charFont);                

                for(int i=0;i<charArray.length;i++){
                    char textChar = charArray[i];
                    CharacterClass charClass = CharacterFactory.getChar(textChar);
                    // FontClass singleCharFont = test.getFont(i);
                    // charClass.setFont(singleCharFont);
                }
                return 1;
            }
        }.averageBytes();
        System.out.println("memoryUsedWithFlyWeight----->>>>"+memoryUsedWithFlyWeight);
        System.out.printf("The average memory used by Flyweight for \"abc\" + \"def\" is %.1f bytes%n",memoryUsedWithFlyWeight);

        double memoryUsedWithoutFlyweight = new SizeofUtil(){
        
            @Override
            protected int create() {                
                // FontClass charFont = new FontClass("Times","Bold",10);                
                // RunArray test = new RunArray(testText.toCharArray());
                // test.addRun(0,250, charFont);

                // charFont = new FontClass("Courier","Italic",15);                
                // test.addRun(250,10, charFont);


                // charFont = new FontClass("Times","Bold",10);                
                // test.appendRun(97, charFont);                

                for(int i=0;i<charArray.length;i++){
                    char textChar = charArray[i];
                    CharacterClass charClass = new CharacterClass (textChar);
                    // FontClass singleCharFont = test.getFont(i);
                    // charClass.setFont(singleCharFont);
                }
                return 1;
            }
        }.averageBytes();
        System.out.println("memoryUsedWithoutFlyweight---------->>>"+memoryUsedWithoutFlyweight);
        System.out.printf("The average memory used by Flyweight for \"abc\" + \"def\" is %.1f bytes%n",memoryUsedWithoutFlyweight);

        System.out.println("memory saved---------->>>"+(memoryUsedWithoutFlyweight-memoryUsedWithFlyWeight));        
    }
}
