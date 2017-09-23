package com.pkg.utilities;

import java.util.Comparator;

public class CompEmp implements Comparator<Employee>{
	
@Override
public int compare(Employee o1, Employee o2) {
if(o1.getEmployeeId()>o2.getEmployeeId())
	return -1;
else
	return 1;
}
}
