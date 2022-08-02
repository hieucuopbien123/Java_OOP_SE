package testinterface;

// Interface

public class ClassImplementation implements InterfaceCha {
    @Override
    public void createAbstractMethod() {
        System.out.println("Override Method for interface");
	}

	public static void main(String[] args) {
		ClassImplementation classImplementsInterface = new ClassImplementation();
		classImplementsInterface.createAbstractMethod();
		InterfaceCha InterfaceChaVar = new ClassImplementation();
	}
}
