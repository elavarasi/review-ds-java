//
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//
//
//class Result {
//
//    /*
//     * Complete the 'maxDifference' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts INTEGER_ARRAY px as parameter.
//     */
//
//    public static int maxDifference(List<Integer> px) {
//        if (px.size() < 2) {
//            return -1;
//        }
//
//        int maxDifference = -1;
//
//        for (int i = 0; i < px.size()-1; i++) {
//            for (int j = 1; j < px.size(); j++) {
//                if (px.get(j) >= px.get(i)) {
//                    maxDifference = Math.max(maxDifference, px.get(j) - px.get(i));
//                } else {
//                    i++;
//                    j = i + 1;
//                }
//            }
//        }
//
//        return maxDifference;
//
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int pxCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> px = IntStream.range(0, pxCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.maxDifference(px);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
