package atguigu.java8;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {

	@Override
	public boolean apply(Employee t) {
		return t.getSalary() >= 5000;
	}

}
