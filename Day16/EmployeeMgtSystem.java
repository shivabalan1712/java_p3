import java.util.*;
import java.util.stream.*;

public class EmployeeMgtSystem {
  public static void main(String[] args) {
    List<Employee> emp = EmployeeDataBase.getAllEmployees();
    
    //emp.forEach(e->System.out.println(e.getName()+" : "+e.getSalary()));
    
    //get the employee details
    emp.stream()
       .map(e->e.getName()+" : "+e.getSalary())
       .forEach(System.out::println);
    System.out.println();
    //get dept = development and 
    emp.stream()
       .filter(e->e.getDept().equals("Development") && e.getSalary()>80000)
       .map(e -> e.getName() + " : " + e.getDept() + " : Rs." + e.getSalary())
       .forEach(System.out::println);
    System.out.println();
    //get employee name start with s and k
    emp.stream()
       .filter(e -> e.getName().toLowerCase().startsWith("s") ||      
                    e.getName().toLowerCase().startsWith("k"))
       .map(e->e.getName())
       .forEach(System.out::println);
    System.out.println();
    //map
    emp.stream()
       .map(e->e.getDept())
       .distinct()
       .sorted()
       .forEach(System.out::println);
    System.out.println();     
    //flatmap to get projects bcos the projects are part of the other cls and it also have same func of class employee
    //reaching to the stream from cls 1 stream 
    //nested class stream 
    emp.stream()
       .flatMap(e->e.getProjects().stream())
       .map(p->p.getName())
       .forEach(System.out::println);
    System.out.println(); 
    
    //sort employee based on salary
    emp.stream()
       .sorted(Comparator.comparing(Employee::getSalary))
       .map(e -> e.getName() + " : " + e.getDept() + " : Rs." + e.getSalary())
       .forEach(System.out::println);
    System.out.println(); 
    //sort in desc order of salary
    emp.stream()
       .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
       .map(e -> e.getName() + " : " + e.getDept() + " : Rs." + e.getSalary())
       .forEach(System.out::println);
    System.out.println(); 
    //min and max
    emp.stream()
        .max(Comparator.comparing(Employee::getSalary))
        .map(e->e.getName()+" : "+e.getSalary())
        .ifPresent(System.out::println);
    System.out.println();
    emp.stream()
        .min(Comparator.comparing(Employee::getSalary))
        .map(e->e.getName()+" : "+e.getSalary())
        .ifPresent(System.out::println);
    System.out.println();
    
    //how many male and female employee
    //groupingBy the employee gender
    Map<String, List<String>> empgrp = emp.stream()
                                          .collect(Collectors.groupingBy(
                                              Employee::getGender,
                                              Collectors.mapping(Employee::getName, Collectors.toList())))
                                              //.forEach(System.out::println)
                                              ;

    //empgrp.forEach((gender, names) -> System.out.println(gender + " : " + names));
    System.out.println(empgrp);
  }	
}

//aggr
//map convert
//common - without filter 

