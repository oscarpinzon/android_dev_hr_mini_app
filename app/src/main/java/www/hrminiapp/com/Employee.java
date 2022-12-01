package www.hrminiapp.com;

public class Employee {
    private int id, salary;
    private String name, desig, dept, emailid;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesig() {
        return desig;
    }

    public String getDept() {
        return dept;
    }

    public String getEmailid() {
        return emailid;
    }

    public int getSalary() {
        return salary;
    }
}
