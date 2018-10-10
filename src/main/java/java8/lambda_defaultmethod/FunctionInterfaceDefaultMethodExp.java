package java8.lambda_defaultmethod;

public class FunctionInterfaceDefaultMethodExp {

    public static void main(String[] args) {
        FunctionInterfaceDefaultMethod concept = (s) -> System.out.println(s.length());
        concept.perform("Test");
        concept.defaultMethod();
        FunctionInterfaceDefaultMethod.staticMethod();
        
        
        FunctionInterfaceDefaultMethod impl = new FunctionInterfaceDefaultMethodImpl();
        impl.perform("Test Impl");
        impl.defaultMethod();
        
        
        FunctionInterfaceDefaultMethodImpl.staticMethod();
    }

}



