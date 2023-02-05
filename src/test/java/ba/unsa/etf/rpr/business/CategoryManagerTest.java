package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.CategoryDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.MarketException;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryManagerTest {
    private CategoryManager categoryManager;
    private Category category;
    private CategoryDaoSQLImpl categoryDaoSQLMock;
    private List<Category> categories;

    /**
     * This method will be called before each test method
     */
    @BeforeEach
    public void initializeObjectsWeNeed(){
        categoryManager = Mockito.mock(CategoryManager.class);
        category = new Category();
        category.setName("PC");
        category.setId(20);

        categoryDaoSQLMock = Mockito.mock(CategoryDaoSQLImpl.class);
        categories = new ArrayList<>();
        categories.addAll(Arrays.asList(new Category("PC"), new Category("Tablet"), new Category("Keyboard"), new Category("Mouse")));
    }
    @Test
    void validateCategoryName() throws MarketException{
        String correctName = "Tablet";
        try{
            Mockito.doCallRealMethod().when(categoryManager).validateCategoryName(correctName);
        }catch (MarketException e){
            e.printStackTrace();
            Assertions.assertTrue(false);
        }

        String incorrectNameShort = "C";
        Mockito.doCallRealMethod().when(categoryManager).validateCategoryName(incorrectNameShort);
        MarketException marketException1 = Assertions.assertThrows(MarketException.class, () -> {
            categoryManager.validateCategoryName(incorrectNameShort);
        }, "Category name must be between 2 and 45 chars");
        Assertions.assertEquals("Category name must be between 2 and 45 chars", marketException1.getMessage());

        String incorrectNameLong = "";
        for(int i=0; i<48; i++)
            incorrectNameLong += 'a';
        Mockito.doCallRealMethod().when(categoryManager).validateCategoryName(incorrectNameLong);
        String finalIncorrectNameLong = incorrectNameLong;
        MarketException marketException2 = Assertions.assertThrows(MarketException.class, () -> {
            categoryManager.validateCategoryName(finalIncorrectNameLong);
        }, "Category name must be between 2 and 45 chars");
        Assertions.assertEquals("Category name must be between 2 and 45 chars", marketException2.getMessage());
    }
}
