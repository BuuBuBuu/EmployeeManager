package model.dto;

public class PromotionDTO {
    private int empNo;
    private int salary;
    private String title;
    private String deptNo;

    public PromotionDTO(int empNo, int salary, String title, String deptNo) {
        this.empNo = empNo;
        this.salary = salary;
        this.title = title;
        this.deptNo = deptNo;
    }

    public PromotionDTO() {}

// THIS IS USED IF WE WANT TO ACCOMODATE FOR SITUATIONS WHERE NOT ALL FIELDS ARE FILLED UP
// can delete actually
//    public PromotionDTO() {
//        this.salary = -1;
//        this.title = null;
//        this.deptNo = null; // put in "default" values so that you can check whether user has provided that input
//    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
}
