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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    Integer maxGradeValue = Collections.max(grades);
    List<Integer> output =  new ArrayList<>();
    
    for (Integer element : grades) {
        if (element < 38) {
            output.add(element);
        }else if (element >= 38) {
            Integer  nextMultipleOfFiveNumebr = 0;
            if(element % 5 == 0)
            {
                output.add(element);
            }else{
                for (int i = element; i < element + 5; i++) {
                if(i % 5 == 0){
                   nextMultipleOfFiveNumebr = i; 
                }
            }
                if (nextMultipleOfFiveNumebr - element < 3) {
                    output.add(nextMultipleOfFiveNumebr);
                }else{
                    output.add(element);
                }
            }
           
            
        }
        
        
    }

        return output ;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
