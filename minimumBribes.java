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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
     long minimumBribes = 0;
    for (int i = 0; i < q.size(); i++) {
        if(q.get(i).intValue() - (i+1) > 2)
        {
            System.out.println("Too chaotic");
            return ;
        }
        
        int start = q.get(i).intValue() - 2 < 0 ? 0 : q.get(i).intValue() - 2;
        
        for (int j = start; j < i; j++) {
            if (q.get(j) > q.get(i)) {
               minimumBribes +=1; 
            }
            
        }   
        
    }
    System.out.println(minimumBribes);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
