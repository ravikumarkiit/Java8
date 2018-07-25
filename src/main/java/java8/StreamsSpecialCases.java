package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsSpecialCases {

	public static void main(String[] args) {
		/**Object Arrays*/
		System.out.println("Using Stream.of");
		String[] stringArr = new String[] {"s1", "s2", "s3"};
		Stream.of(stringArr).forEach(System.out::println);
		
		System.out.println("Using Arrays.stream()");
		Arrays.stream(stringArr).forEach(System.out::println);
		
		/**For primitive array, the Arrays.stream and Stream.of will return different output.*/
		int[] intArray = {1, 2, 3, 4, 5};

        // 1. Arrays.stream -> IntStream 
        IntStream intStream1 = Arrays.stream(intArray);
        intStream1.forEach(System.out::println);
        
        // 2. Stream.of -> Stream<int[]>
        Stream<int[]> temp = Stream.of(intArray);
        // Cant print Stream<int[]> directly, convert / flat it to IntStream 
        IntStream intStream2 = temp.flatMapToInt(Arrays::stream);
        intStream2.forEach(System.out::println);
        
        //3. Array To IntStream To list
        IntStream intStream3 = Arrays.stream(intArray);
        List<Integer> list = intStream3.boxed().collect(Collectors.toList());
        list.forEach(System.out::println);
        
        //4. IntStream To Array
        int[] result = IntStream.range(0, 5).toArray();
        Arrays.stream(result).forEach(System.out::println);
        
        
	}

}
