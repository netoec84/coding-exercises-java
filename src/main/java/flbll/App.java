package flbll;

import flbll.domain.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class App {

    private static ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
    private static HashMap<String, Employee> employeeHashMap = new HashMap<String, Employee>();
    public static final String CSV_SEPARATOR = ";";

    public static void main(String[] args) {
        try {
            String csvFilePath = filePath("flbll/data.csv");
            loadListFromFile(csvFilePath);
            loadDictionaryFromFile(csvFilePath);
            printEmployeesList();
            printEmployeesDictionary();

        } catch (IOException | URISyntaxException e) {
            System.out.println("Error:: " + e.getMessage());
        }

    }

    private static String filePath(String fileName) throws URISyntaxException {
        URL resource = App.class.getClassLoader().getResource(fileName);
        File file = Paths.get(resource.toURI()).toFile();
        return file.getAbsolutePath();
    }

    private static void printEmployeesDictionary() {
        System.out.println("--------------------------------");
        System.out.println("-- EMPLOYEES DICTIONARY       --");
        System.out.println("--------------------------------");

        for (Employee employee : getEmployeeHashMap().values()) {
            System.out.println(employee);
        }
    }

    private static void loadDictionaryFromFile(String filePath) throws IOException {
        BufferedReader bufferedReader;
        String line;

        bufferedReader = new BufferedReader(new FileReader(filePath));
        while ((line = bufferedReader.readLine()) != null) {
            Employee employee = readLine(line);
            getEmployeeHashMap().put(employee.getLastName(), employee);
        }
        bufferedReader.close();
    }

    private static void printEmployeesList() {
        System.out.println("--------------------------------");
        System.out.println("-- EMPLOYEES LIST             --");
        System.out.println("--------------------------------");
        for (Employee employee : getEmployeeArrayList()) {
            System.out.println(employee);
        }
    }

    public static void loadListFromFile(String filePath) throws IOException {
        BufferedReader bufferedReader;
        String line;

        bufferedReader = new BufferedReader(new FileReader(filePath));
        while ((line = bufferedReader.readLine()) != null) {
            getEmployeeArrayList().add(readLine(line));
        }
        bufferedReader.close();
    }

    public static Employee readLine(String linea) {
        String[] employee = linea.split(CSV_SEPARATOR);
        Employee objEmployee = new Employee();

        objEmployee.setAge(Integer.parseInt(employee[0]));
        objEmployee.setName(employee[1]);
        objEmployee.setLastName(employee[2]);
        objEmployee.setGender(employee[3].charAt(0));

        return objEmployee;
    }

    public static ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public static void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        App.employeeArrayList = employeeArrayList;
    }

    public static HashMap<String, Employee> getEmployeeHashMap() {
        return employeeHashMap;
    }

    public static void setEmployeeHashMap(HashMap<String, Employee> employeeHashMap) {
        App.employeeHashMap = employeeHashMap;
    }
}
