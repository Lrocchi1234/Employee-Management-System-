public interface Employeedbintrf {

    void createEmployee(employee emp);

    void showAllEmployee();

    void showEmployeeBasedOnID(int id);

    void updateEmployee(int id, String name);

    void deleteEmployee(int id);
}
