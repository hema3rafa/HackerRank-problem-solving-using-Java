import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
    String alphabet = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    List<String> alphabetList = Arrays.asList(alphabet.split(","));
    int routingKey = k % 26 ;
    String rotatedString = "";
    int newIndex = 0 ;
    
    for (int i = 0; i < s.length(); i++) {
      if (alphabetList.contains((s.charAt(i)+"").toLowerCase())) {
        newIndex = alphabetList.indexOf((s.charAt(i)+"").toLowerCase()) + routingKey ;
         if (newIndex > alphabetList.size()-1) 
           newIndex -= alphabetList.size();
         
          if (Character.isUpperCase(s.charAt(i))) {
            rotatedString += alphabetList.get(newIndex).toUpperCase() ; 
          } else {
             rotatedString += alphabetList.get(newIndex) ; 
          }  

        }else{
           rotatedString += s.charAt(i) ; 
        }
        
    }
    
    
    
    return rotatedString ;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
