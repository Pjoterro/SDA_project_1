package user_interface.table_creator;

import dto.Employee;
import dto.Item;

public class ItemTableComponents {

    public static String tableHeader() {
        String header =
                "+----+----------------------+--------------+--------------------------------------------------+\n" +
                "| ID | Wlasciciel           | Nazwa        | Opis                                             |\n" +
                "+----+----------------------+--------------+--------------------------------------------------+";
        return header;
    }

    public static String tableInterline() {
        String bottom =
                "+----+----------------------+--------------+--------------------------------------------------+";
        return bottom;
    }

    public static String generateSeparator(int charNumber, String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < charNumber-str.length(); i++) {
            result.append(" ");
        }
        result.append(" | ");
        return result.toString();
    }

    public static String itemRecord(Item item) {
        StringBuilder record = new StringBuilder();
        record.append("| ");
        record.append(item.getId());
        record.append("  | ");
        record.append(item.getOwner().getFirstName());
        record.append(generateSeparator(20, item.getOwner().getFirstName()));
        record.append(item.getName());
        record.append(generateSeparator(12, item.getName()));
        record.append(item.getDescription());
        record.append(generateSeparator(48, item.getDescription()));
        return record.toString();
    }
}
