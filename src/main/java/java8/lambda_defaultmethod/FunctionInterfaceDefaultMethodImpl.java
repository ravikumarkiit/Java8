package java8.lambda_defaultmethod;

public class FunctionInterfaceDefaultMethodImpl implements FunctionInterfaceDefaultMethod{

	@Override
	public void perform(String s) {
		System.out.println("In Impl " + s);
	}
	
	@Override
	public void defaultMethod(){ // Can be overriden in implementing classes
        System.out.println("In Impl Default method called");
    }
	
	static void staticMethod(){ // Can't be overriden in implementing classes
        System.out.println("In Impl static method called in");
    }
}
