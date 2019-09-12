package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class java8Stream {
	private static java8Stream singletonInstance = null;

	public static java8Stream getInstance() {

		if (singletonInstance == null) {
			synchronized (java8Stream.class) {
				if (singletonInstance == null) {
					singletonInstance = new java8Stream();
				}
			}
		}
		return singletonInstance;
	}

	private java8Stream() {

	}

	public static void main(String[] args) {

		Employee john = new Employee(1, "John Nhoj", 200.99, "IT");
		Employee south = new Employee(2, "South Htuos", 299.99, "Sales");
		Employee reet = new Employee(3, "Reet Teer", 300.99, "IT");
		Employee prateema = new Employee(4, "Prateema Rai", 300.99, "Benefits");
		Employee yogen = new Employee(5, "Yogen Rai", 200.99, "Sales");

		List<Employee> employees = Arrays.asList(john, south, reet, prateema, yogen);

		Map<String, List<Employee>> collect = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		List<Employee> collect2 = employees.stream().filter(x -> x.getDepartment().equalsIgnoreCase("Sales"))
				.collect(Collectors.toList());

		System.out.println(collect);

		System.out.println(collect2);

		Map<String, List<Employee>> collect3 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println(collect3);

		Map<String, Long> collect4 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		System.out.println(collect4);

		// get max salary
		Double maxSalary = employees.stream().collect(Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), emp -> emp.get().getSalary()));
		System.out.println(maxSalary);

		String s1 = "test";
		String s2 = new String("test");

		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);

		StringBuffer str = new StringBuffer(s1);
		char[] charArray = str.toString().toCharArray();

		for (int i = charArray.length - 1; i >= 0; i--) {
			System.out.println(charArray[i]);
		}

		StringBuilder str2 = new StringBuilder(s1);
		str.append("test");

		System.out.println(str.toString());
		System.out.println(str2.reverse());

		List<String> asList = Arrays.asList("test", "one", "one");

		HashSet<String> set = new HashSet<>(asList);
		set.forEach(System.out::print);

		HashMap<String, String> hm = new HashMap<>();

		hm.put("one", "test");
		hm.put("two", "test2");
		hm.forEach((k, v) -> System.out.println(k + "," + v));

		// Comparator

		Comparator<Employee> salComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getSalary() - o2.getSalary());
			}
		};

		Comparator<Employee> nameComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		Comparator<Employee> byDept = (Employee e1, Employee e2) -> e1.getDepartment().compareTo(e2.getDepartment());
		Comparator<Employee> byName = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
		Comparator<Employee> bySalary = (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());

		Collections.sort(employees, salComparator.reversed());
		Collections.sort(employees, Collections.reverseOrder(bySalary));
		Collections.sort(employees, nameComparator);

		Collections.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));

		System.out.println(employees.stream().map(emp -> emp.getSalary() * 10).collect(Collectors.toList()));

		// comparator using streams
		employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getDepartment))
				.forEach(System.out::println);

		Map<String, Long> collect5 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Grouping by example::" + collect5);

		// By using Filter

		employees.stream().filter(emp -> emp.getSalary() < 1000).forEach(System.out::println);

	}

}