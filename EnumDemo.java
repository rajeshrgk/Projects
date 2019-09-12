package test;

public class EnumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingletonEnum obj = SingletonEnum.INSTANCE;

		System.out.println(obj.getValue());
		obj.setValue(2);
		System.out.println(obj.getValue());

	}

}
