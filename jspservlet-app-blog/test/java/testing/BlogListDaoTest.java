package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 
import model.BlogList;
import service.BlogListDao;
 
class BlogListDaoTest {
     
    private static BlogListDao dao;
     
    @BeforeAll
    static void init() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao = new BlogListDao(conn);
    }
     
    @AfterAll
    static void teardown() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    @Test
    void addListTest() {
        Blog list = new Blog();
        list.setBlogName("Sales strategy");
        list.setBlogDescription("Its time to move from always be closing to new sales");
        list.setBlogImageUrl("salesmarketing.png");
		list.setBlogDetails("About Sales");
        dao.addBlogList(list);
        Blog listFromDb = dao.viewBlogListByName("Sales strategy");
        assertEquals("About Sales", listFromDb.getBlogDetails(), "Blog details must be equal");
    }
    
    @Test
    void deleteListTest() {
        dao.deleteBlogList(1);
        Blog listFromDb = dao.viewBlogListByName("Sales strategy");
        assertNull(listFromDb.getBlogDetails(), "List type should be null");
    }
    
    @Test
    void updateListTest() {
        Blog list = new BlogList();
        list.setBlogName("Sales strategy");
        list.setBlogDescription("Its time to move from always be closing to new sales");
        list.setBlogImageUrl("salesmarketing.png");
		list.setBlogDetails("About Sales");
        dao.addBlogList(list);
        list.setBlogDetails("About Sales Marketing");
        dao.updateBlogList(list);
        Blog listFromDb = dao.viewBlogListByName("Sales strategy");
        assertEquals("About Sales Marketing", listFromDb.getBlogDetails(), "Blog details must be equal");
    }
 
}