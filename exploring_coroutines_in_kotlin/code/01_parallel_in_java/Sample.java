import java.util.*;

public class Sample {  
  public static int transform(int n) {
    try { Thread.sleep(1000); } catch(Exception ex) {}
    return n * 1;
  } 
  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println(numbers.stream() //parallelStream instead of stream
      .mapToInt(e -> transform(e))
      .reduce(0, Integer::sum));
  }
}
