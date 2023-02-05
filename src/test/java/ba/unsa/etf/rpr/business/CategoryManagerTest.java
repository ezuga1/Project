package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.CategoryDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Category;
import org.junit.jupiter.api.BeforeEach;
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

    }
}
