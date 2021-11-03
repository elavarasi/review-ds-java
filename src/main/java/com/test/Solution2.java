package com.test;
/* 2 Table
emp -> id, name, salary
1 ela 500

dept -> dep, id, name
software 1 ela
software 1 santosh


software 1 ela 500
software 2 santhosh 500


GET /empDetail/dept

Response{


}


**/
public class Solution2 {
}

class emp {
    int id;
    String name;
    double salary;

    //getter and setter
}

class dept {
    String dept;
    int id;
    String name;
}

class AllEmp {
    int id;
    String name;
    double salary;
    String dept;


}

// handler
class employeeDetail {
    @GET()
    public ResponseVO getEmpDetail(ReqquestVO) {
        AllEmp  allEmpInfo =  Db connection and fetch details;
        // apply business logic


        return allEmpInfo;
    }
}


// process Emp data
class GenerateEmpData {

    public


}


// DB helpers
class  AccessDB {
    // Methods to use connectors
    select dept.dept, emp.id, emp.name, emp.salary
    from emp innerJoin dept on id
    groupBy dept;

}

//emp -> id, name, salary
//        1 ela 500
//
//        dept -> dep, id, name