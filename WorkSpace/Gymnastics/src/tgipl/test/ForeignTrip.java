package tgipl.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForeignTrip {
	
	public static void main(String[] args) {
		int numEmployees=3;
		String workHistory="{(1,2),(1,3),(2,3)}";
		System.out.println(emp_violating(numEmployees, workHistory));
		
	}
	
	public static String emp_violating(int numEmployees,String workHistory)
    {
		List<Employee> empList= new ArrayList<Employee>();
		for(int i=1;i<=numEmployees;i++)
		{
			Employee emp= new Employee(i);
			empList.add(emp);
		}
		workHistory= workHistory.replace("{", "");
		workHistory= workHistory.replace("}", "");
		workHistory= workHistory.replace("(", "");
		String []wrkPairs=workHistory.split("\\)");
		for(int i=0;i<wrkPairs.length;i++)
		{
			if(wrkPairs[i].startsWith(","))
			{
				wrkPairs[i]=wrkPairs[i].substring(1);
			}
			
		}
		//String [] pairArr=wrkPairs.split(",");
		Set<Integer> setX = new HashSet<Integer>();
		Set<Integer> setY = new HashSet<Integer>();
		Set<Integer> cloneSetX = new HashSet<Integer>();
		Set<Integer> cloneSetY = new HashSet<Integer>();
		for(String pair: wrkPairs)
		{
			String[] pairXY=pair.split(",");
			Employee emp = getEmployeefromId(Integer.parseInt(pairXY[0]),empList);
			emp.workedWith.add(Integer.parseInt(pairXY[1]));
			setX.add(Integer.parseInt(pairXY[0]));
			setY.add(Integer.parseInt(pairXY[1]));
			
		}
		cloneSets(setX, cloneSetX);
		cloneSets(setY, cloneSetY);
		
		
		removeWorkedPairsFromSet(empList, setX, cloneSetX);
		removeWorkedPairsFromSet(empList, setY, cloneSetY);
		
		if(empList.size()==(cloneSetX.size()+cloneSetY.size()))
		{
			return "yes";
		}
		
		
		
        return "no";
    }

	private static void removeWorkedPairsFromSet(List<Employee> empList,
			Set<Integer> setX, Set<Integer> cloneSetX) {
		for(int x: setX)
		{
			if(!cloneSetX.contains(x))
				continue;
			Employee emp = getEmployeefromId(x,empList);
			
			for(int worked: emp.workedWith)
			{
				if(cloneSetX.contains(worked)&& worked!=x)
				{
					cloneSetX.remove(worked);
				}
			}
		}
	}
	
	
	private static void cloneSets(Set<Integer> set, Set<Integer> cloneSet) {

		for(int i : set)
		{
			cloneSet.add(i);
		}
		
	}

	private static Employee getEmployeefromId(int id,
			List<Employee> empList) {
		for(Employee e: empList)
		{
			if(e.empId==id)
				return e;
			
		}
		return null;
	}


	static class Employee
	{
		int empId;
		List<Integer> workedWith = new ArrayList<Integer>();
		public Employee(int empId)
		{
			this.empId=empId;
		}
		
		@Override
		public int hashCode() {
			
			return Integer.valueOf(empId).hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Employee)
			{
				return empId==((Employee)obj).empId;
			}
			return false;
		}
	}

}
