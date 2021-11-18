import java.io.*;


public class FileMaker {

    private static char[] characters(){
        char[] characters = new char[32001];
         char character = 0;
        for (int i = 0; i <= 32000; i++) {
            characters[i] = character;
            character++;
            if (character == 127)
                character = 0;
        }
        return characters;
    }
    public static long make (String path, long sizeMB) throws IOException {

        long mbToLong = (long) (sizeMB*31.25);
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter( new FileWriter(file));
        char[] chars = characters();//char[] chars = {'T','h','i','s',' ','I','s',' ','A',' ','T','e','s','t'};
        for (int i = 0; i <= mbToLong; i++)
            writer.write(chars);
        writer.flush();
        writer.close();;
        System.out.println("File of " + sizeMB + " megabytes created successfully!");
        return file.length();
    }
}
