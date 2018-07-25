package java8.lambda_defaultmethod;

@FunctionalInterface
public interface FunctionInterfaceDefaultMethod {
	public void perform(String s);
	
    default void defaultMethod(){ // Can be overriden in implementing classes
        System.out.println("Default method called");
    }

    static void staticMethod(){ // Can't be overriden in implementing classes
        System.out.println("static method called");
    }

}
