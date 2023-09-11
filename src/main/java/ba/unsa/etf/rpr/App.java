package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ItemsManager;
import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.domain.Items;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.MarketException;


import org.apache.commons.cli.CommandLineParser;
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
        category = listOfCategories.stream().filter(cat -> cat.getName().equalsIgnoreCase(categoryName)).findAny().get();
        return category;
    }

    public static void main(String[] args) throws ParseException, MarketException {
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options,args);

        if((cl.hasOption(addItem.getOpt()) || cl.hasOption(addItem.getLongOpt())) && cl.hasOption((categoryDefinition.getLongOpt()))){
            ItemsManager itemsManager = new ItemsManager();
            CategoryManager categoryManager = new CategoryManager();
            Category category = null;
            try{
                category = searchThroughCategories(categoryManager.getAll(), cl.getArgList().get(1));
            }catch (Exception e){
                System.out.println("There is no category in the list! Try again");
                System.exit(1);
            }
            Items item = new Items();
            item.setCategoryID(category);
            item.setItemName(cl.getArgList().get(0));
            item.setPrice(cl.getArgList().get(2));
            item.setDescription(cl.getArgList().get(3));
            /*String itemToAdd= cl.getArgList().get(0);
            String itemName = "";
            String[] tmp = itemToAdd.split(" ");
            for(int i=0; i<2; i++){
                itemName += tmp[i]+" ";
            }
            String itemPrice = " ";
            for(int i=2; i<4; i++)
                itemPrice+=tmp[i]+" ";
            String itemDesc = " ";
            for(int i=4; i< tmp.length; i++)
                itemDesc += tmp[i]+" ";
            item.setItemName(itemName);
            item.setPrice(itemPrice);
            item.setDescription(itemDesc);*/
            item.setUserID(2);
            itemsManager.add(item);
            System.out.println("You successfully added item to database");

        }
        else if(cl.hasOption(getItems.getOpt()) || cl.hasOption(getItems.getLongOpt())){
            ItemsManager itemsManager = new ItemsManager();
            itemsManager.getAll().forEach(i -> System.out.println(i.getItemName()));
        }
        else if(cl.hasOption(addCategory.getOpt()) || cl.hasOption(addCategory.getLongOpt())){
            try{
                CategoryManager categoryManager = new CategoryManager();
                Category cat = new Category();
                cat.setName(cl.getArgList().get(0));
                cat.setStatus(cl.getArgList().get(1));
                categoryManager.add(cat);
                System.out.println("Category added successfully");
            }
            catch (Exception e){
                System.out.println("There is already category with same name in database! Try again");
                System.exit(1);
            }
        }
        else if(cl.hasOption(getCategories.getOpt()) || cl.hasOption(getCategories.getLongOpt())){
            CategoryManager categoryManager = new CategoryManager();
            categoryManager.getAll().forEach(c -> System.out.println(c.getName()));
        }
        else{
            printFormattedOptions(options);
            System.exit(-1);
        }
    }


}
