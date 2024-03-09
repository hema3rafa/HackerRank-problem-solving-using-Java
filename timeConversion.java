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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
     // Write your code here
    String newDateFormat = s;
    String hh =  s.substring(0, 2);
    int hhint =  Integer.parseInt(hh);
    String newhh = hh ;
    if(s.contains("PM"))
    {
         if(hhint < 12)
        {
              
        Integer newint = 12 + hhint; 
        newhh = newint.toString(); 
        }
        
        
    }else if(s.contains("AM")){
        
       if(hhint == 12)
        {
           newhh = "00"; 
        }
    }
    
    
    newDateFormat = newDateFormat.replace("AM","");
   newDateFormat = newDateFormat.replace("PM","");
   newDateFormat =  newDateFormat.substring(2);
   newDateFormat = newhh.concat(newDateFormat);
    return newDateFormat;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
