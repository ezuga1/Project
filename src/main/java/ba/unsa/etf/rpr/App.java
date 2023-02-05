package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.MarketException;


import net.bytebuddy.asm.Advice;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.util.List;


/**
 * Command Line Interface implementation in following class
 * @author Ernad Zuga
 *
 */
public class App {
    /**
     * Defining final variables to describe all code having options
     */
    private static final Option addItem = new Option("i", "add-item", false, "Adding new item to Tech market database");
    private static final Option addCategory = new Option("c", "add-category", false, "Adding new category to Tech market database");
    private static final Option getItems = new Option("getI", "get-items", false, "Printing all items from Tech market database");
    private static final Option getCategories = new Option("getC", "get-categories", false, "Printing all categories from Teck market database");
    private static final Option categoryDefinition = new Option(null, "category", false, "Defining category for next added item");


    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar Project.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addItem);
        options.addOption(addCategory);
        options.addOption(getItems);
        options.addOption(getCategories);
        options.addOption(categoryDefinition);
        return options;
    }

    public static Category searchThroughCategories(List<Category> listOfCategories, String categoryName){
        Category category = null;
        category = listOfCategories.stream().filter(cat -> cat.getName().toLowerCase().equals(categoryName.toLowerCase())).findAny().get();
        return category;
    }

}
