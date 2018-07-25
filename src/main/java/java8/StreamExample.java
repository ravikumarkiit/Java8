package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {

	StreamExample(){
	}

	public static void main(String args[]){
		List<Integer> numbers = getList();
	    
		/*===================== List operations==========================*/
		System.out.println("List operations===============");
	    // Count
	    long count = numbers.stream().count();
	    System.out.println("Count : " + count);

	    // Find Any
	    Integer findEle = numbers.stream().findAny().get();
	    System.out.println("FindAny : " + findEle);

	    // Find First
	    Integer findFirstEle = numbers.stream().findFirst().get();
	    System.out.println("FindFirst : " + findFirstEle);

	    // Max
	    Integer max = numbers.stream().max((a, b) -> {
	    			int diff = a - b;
	    			System.out.println(a+ " "+b);
	    			return diff;
	    		}
	        ).get();
	    System.out.println("Max : " + max);

	    // Min Alter#1
	    Integer min = numbers.stream().min((a, b) -> a - b).get();
	    System.out.println("Min : " + min);
	    
	    //reduce Alter#2
	    min = numbers.stream().reduce((a, b) -> (a > b) ? b : a).get();
	    System.out.println("Min : " + min);
	    
	    //anyMatch returns TRUE if any elements match a predicate.
	    boolean isPresent = numbers.stream().anyMatch(a -> a==20);
	    System.out.println("isPresent : "+ isPresent);
	    
	    //noneMatch returns TRUE if ALL or NO elements match a predicate.
	    boolean isNotPresent = numbers.stream().noneMatch(a -> a!=2);
	    System.out.println("isNotPresent : "+ isNotPresent);
	    
	    //List to Map // To Avoid IllegalStateException >> Use mergeFunction toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
	    Map<Integer, String> listToMap = numbers.stream().collect(Collectors.toMap(Function.identity(), i -> String.valueOf(i), (a, b) -> a));
	    listToMap.entrySet().forEach(entry -> System.out.println(entry.getKey()+ " "+entry.getValue()));
	    
	   /* Map<Integer, String> listToMap = new HashMap<>();
	    for(Integer i : numbers) {
	    	listToMap.put(i, String.valueOf(i));
	    }
	    listToMap.entrySet().forEach(entry -> System.out.println(entry.getKey()+ " "+entry.getValue()));*/
	    
	    /*===================== MAP operations==========================*/
	    System.out.println("\n\nMap operations===============");
	    
	    Map<String, Integer> map = getMap();
	    for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue().equals(4)) {
				System.out.println(entry.getKey());
			}
		}
		
	    //ifPresent() get Key from Map for a given Value
		map.entrySet().stream().filter(e -> e.getValue().equals(5)).map(Map.Entry::getKey).findFirst().ifPresent(System.out::print);
		
		HashMap<Set<Integer>, Double> container = new HashMap<Set<Integer>, Double>();
		//Collecting to Map
		Map<Set<Integer>, Double> map1 = container.entrySet()
								        .stream()
								        .filter(k -> k.getKey().size() == 2)
								        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		//Collecting to HashMap to TreeMap
		map1 = container.entrySet()
		        .stream()
		        .filter(k -> k.getKey().size() == 2)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> newValue, TreeMap::new));
		
		//ketSet() are backed by Map so if any alteration it will reflect in Map
		Set<String> keys = map.keySet();
		keys.remove("B");// add() will throw UnsupportedOperationException
		map.entrySet().forEach(entry -> System.out.println(entry.getKey()+ " - "+entry.getValue()));
		
	}
	
	private static List<Integer> getList() {
		List<Integer> numbers = new ArrayList<>();
	    numbers.add(1);
	    numbers.add(4);
	    numbers.add(5);
	    numbers.add(2);
	    numbers.add(3);
	    numbers.add(3);
		
	    //Java8
	    // List numbers = IntStream.range(1, 5).boxed().collect(Collectors.toList());
	    
		return numbers;
	}
	
	private static Map<String, Integer> getMap() {
		Map<String, Integer> map = new HashMap<String, Integer>(32, 0.75f);
		map.put("A", 4);
		map.put("B", 5);
		map.put("C", 1);
		map.put("D", 2);
		map.put("E", 0);
		
		/*Long collect = (Long) lst.stream().collect(Function.identity(), LinkedHashMap::new, Collectors.counting());
		System.out.println(collect);*/
		
		return map;
	}
}
