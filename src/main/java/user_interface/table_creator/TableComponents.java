package user_interface.table_creator;

import dto.Employee;

public class TableComponents {

    public static String tableHeader() {
        String header =
                "+----+-----------------+-----------------+-----------------+--------------+--------+\n" +
                "| ID | Imie            | Nazwisko        | Stanowisko      | Data urodzin | Pensja |\n" +
                "+----+-----------------+-----------------+-----------------+--------------+--------+";
        return header;
    }

    public static String tableInterline() {
        String bottom =
                "+----+-----------------+-----------------+-----------------+--------------+--------+";
        return bottom;
    }

    public static String empRecord(Employee emp) {
        StringBuilder record = new StringBuilder();
        record.append("| ");
        record.append(emp.getId());
        record.append("  | ");
        record.append(emp.getFirstName());
        record.append(generateSeparator(emp.getFirstName()));
        record.append(emp.getLastName());
        record.append(generateSeparator(emp.getLastName()));
        record.append(emp.getPosition());
        record.append(generateSeparator(emp.getPosition()));
        record.append(emp.getBirthDate());
        record.append("   | ");
        record.append(emp.getSalary().toString());
        record.append("   |");
        return record.toString();
    }

    public static String generateSeparator(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 15-str.length(); i++) {
            result.append(" ");
        }
        result.append(" | ");
        return result.toString();
    }
}