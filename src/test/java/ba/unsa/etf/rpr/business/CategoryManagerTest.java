package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.CategoryDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Category;

import java.util.List;

public class CategoryManagerTest {
    private CategoryManager categoryManager;
    private Category category;
    private CategoryDaoSQLImpl categoryDaoSQLMock;
    private List<Category> categories;
}
