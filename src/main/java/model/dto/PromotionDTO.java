package model.dto;

/**
 * Data Transfer Object for Promotion details
 */
public class PromotionDTO {
    /**
     * Employee Number
     */
    private int empNo;

    /**
     * New Salary
     */
    private int salary;

    /**
     * New Title
     */
    private String title;

    /**
     * New Department Number
     */
    private String deptNo;

    /**
     * Parameterized constructor
     * @param empNo Employee Number
     * @param salary New Salary
     * @param title New Title
     * @param deptNo New Department Number
     */
    public PromotionDTO(int empNo, int salary, String title, String deptNo) {
        this.empNo = empNo;
        this.salary = salary;
        this.title = title;
        this.deptNo = deptNo;
    }

    /**
     * Default constructor
     */
    public PromotionDTO() {}

// THIS IS USED IF WE WANT TO ACCOMODATE FOR SITUATIONS WHERE NOT ALL FIELDS ARE FILLED UP
// can delete actually
//    public PromotionDTO() {
//        this.salary = -1;
//        this.title = null;
//        this.deptNo = null; // put in "default" values so that you can check whether user has provided that input
//    }

    /**
     * Get Employee Number
     * @return empNo
     */
    public int getEmpNo() {
        return empNo;
    }

    /**
     * Set Employee Number
     * @param empNo Employee Number
     */
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    /**
     * Get Salary
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set Salary
     * @param salary Salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Get Title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set Title
     * @param title Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get Department Number
     * @return deptNo
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * Set Department Number
     * @param deptNo Department Number
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
}
