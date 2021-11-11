import java.net.*;
import java.io.*;
import java.util.ArrayList;
// Mostly the sample code you gave on Worlds tips.
public class Reader {
    // The url of the verb list we use to check the words created.
    static String url = "https://gist.githubusercontent.com/sirkets/2b7c3122db8c0bc08aa9e82a35175b3e/raw/16f6c7296d21910ee28cfcd637a9176f093e0da6/verbs.txt";
    static String url1 = "https://gist.githubusercontent.com/Willthepenguin/516a45bc035b08527b315de122e102fb/raw/152c8de9e267f8c73511e8ff4ad391e02a0a3125/Alphabet.txt";
    
    public static void readIntoVerb(ArrayList<String> list) throws Exception {
        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(wordsURL.openStream()));
        String word;
        while ((word = in.readLine()) != null)
            list.add(word);
        in.close();
        
        
    }
    // url1 is the list of the alphabet and we put that into an arrayList
    public static void readIntoAlpha(ArrayList<String> list) throws Exception {
        URL wordsURL1 = new URL(url1);
        BufferedReader in1 = new BufferedReader(
        new InputStreamReader(wordsURL1.openStream()));
        String word1;
        while ((word1 = in1.readLine()) != null)
            list.add(word1);
        in1.close();
    }
}