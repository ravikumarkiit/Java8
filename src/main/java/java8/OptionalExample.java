package java8;

import java.util.Optional;

/**
 * https://www.mkyong.com/java8/java-8-optional-in-depth/
 * Optional.ofNullable() method returns a Non-empty Optional if a value present in the given object. Otherwise returns empty Optional.
 * Optional.empty() method is useful to create an empty Optional object.
 * Optional.of(null);will throw NullPointerException
 * Optional.isPresent() returns true if the given Optional object is non-empty. Otherwise it returns false.
 * Optional.ifPresent() performs given action if the given Optional object is non-empty. Otherwise it returns false.
 * optionalObj.orElse() returns the object actual VALUE if present in Optional Container. Otherwise returns given default value.
*/
public class OptionalExample {

	public static void main(String[] args) {
		Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();
        
        System.out.println(gender); //Optional[MALE]
        System.out.println(emptyGender);//Optional.empty
        
        System.out.println(gender.orElse("<N/A>")); //MALE
        System.out.println(emptyGender.orElse("<N/A>")); //<N/A>
        
        Optional<String> nonEmptyGender = Optional.of("male");
        
        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase)); //Optional[MALE]
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase)); //Optional.empty

        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOtionalGender);//Optional[Optional[male]]
        System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(negender -> negender.map(String::toUpperCase)));//Optional[Optional[MALE]]
        System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(negender -> negender.map(String::toUpperCase)));//Optional[MALE]
        
        //Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty
        
        System.out.println(Optional.ofNullable(null));//Optional.empty
		
	}
}
