package java8.optional.with.optional;

import java.util.Optional;

import java8.optional.with.optional.MobileService;

/**
 * https://www.mkyong.com/java8/java-8-optional-in-depth/
 * Optional.ofNullable() method returns a Non-empty Optional if a value present in the given object. Otherwise returns empty Optional.
 * Optional.empty() method is useful to create an empty Optional object.
 * Optional.of(null);will throw NullPointerException
 * Optional.isPresent() returns true if the given Optional object is non-empty. Otherwise it returns false.
 * Optional.ifPresent() performs given action if the given Optional object is non-empty. Otherwise it returns false.
 * optionalObj.orElse() returns the object actual VALUE if present in Optional Container. Otherwise returns given default value.
*/
public class MobileTesterWithOptional {
	
	public static void main(String[] args) {
		ScreenResolution resolution = new ScreenResolution(750,1334);
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
		Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
		
		MobileService mService = new MobileService();
		
		int width = mService.getMobileScreenWidth(Optional.of(mobile));
		System.out.println("Apple iPhone 6s Screen Width = " + width);

		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", /*Optional.empty()*/Optional.ofNullable(null));		
		int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
		System.out.println("Apple iPhone 16s Screen Width = " + width2);
	}

}
