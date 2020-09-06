package user_interface;

import dao.EmployeeDAO;
import dao.ItemDAO;
import dto.Employee;
import dto.Item;
import user_interface.table_creator.ItemTableComponents;
import user_interface.table_creator.TableComponents;

import java.util.List;

public class ItemTablePrint {

    public static void printItems() {
        ItemDAO itemDAO = new ItemDAO();
        List<Item> itemList = itemDAO.getAll();
        System.out.println(ItemTableComponents.tableHeader());
        for (Item item: itemList) {
            System.out.println(ItemTableComponents.itemRecord(item));
            System.out.println(ItemTableComponents.tableInterline());
        }
    }
}
