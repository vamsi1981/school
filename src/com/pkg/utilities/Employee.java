package com.pkg.utilities;

public class Employee {  
    private int employeeId;         
        private String name;  
        public Employee(int employeeId,String name)
        {
        	this.employeeId=employeeId;
        	this.name=name;
        }
    public int getEmployeeId() {  
        return employeeId;  
    }  
    public void setEmployeeId(int employeeId) {  
        this.employeeId = employeeId;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
      
    @Override  
    public int hashCode() {  
        final int prime = 31;  
        int result = 1;  
        result = (prime * result + employeeId)/3;  
        return result;  
    }  
    @Override  
    public boolean equals(Object obj) {  
        if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        Employee other = (Employee) obj;  
        if (employeeId != other.employeeId)  
            return false;  
        return true;  
    }  
      
} 