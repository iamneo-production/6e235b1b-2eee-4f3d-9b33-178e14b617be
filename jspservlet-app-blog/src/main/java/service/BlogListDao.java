package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;
import model.Blog;
import utility.ConnectionManager;

public class BlogListDao {
    /*private ConnectionManager connectionManager;
    public BlogListDao(ConnectionManager connectionManager){
        this.connectionManager=connectionManager;
    }*/
    ConnectionManager con=new ConnectionManager();
    private static final String INSERT_BLOGS_SQL= "INSERT INTO blogs"+" (blogName, blogDescription, blogImageUrl, blogDetails) VALUES"+" (?,?,?,?);";
    private static final String SELECT_BLOG_BY_NAME= "SELECT blogName,blogDescription,blogImageUrl,blogDetails from blogs where blogName=?;";
    private static final String SELECT_ALL_BLOGS= "SELECT * from blogs;";
    private static final String DELETE_BLOG_SQL= "DELETE from blogs where blogId=?;";
    private static final String UPDATE_BLOG_SQL= "UPDATE blogs SET blogName=?, blogDescription=?, blogImageUrl=?, blogDetails=? where blogId=?;";


    public void addBlogList(Blog blog) throws SQLException{
        try(Connection connection=con.connect();
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT_BLOGS_SQL);){
                preparedStatement.setString(1,blog.getName());
                preparedStatement.setString(2,blog.getDescription());
                preparedStatement.setString(3,blog.getUrl());
                preparedStatement.setString(4,blog.getDetails());
                preparedStatement.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }
    }

    public boolean updateBlogList(Blog blog) throws SQLException{
        boolean rowUpdated=false;
        try(Connection connection=con.connect();
            PreparedStatement statement= connection.prepareStatement(UPDATE_BLOG_SQL);){
                statement.setString(1,blog.getName());
                statement.setString(2,blog.getDescription());
                statement.setString(3,blog.getUrl());
                statement.setString(4,blog.getDetails());
                statement.setInt(5,blog.getId());
                rowUpdated=statement.executeUpdate()>0;
            }catch(Exception e){
                e.printStackTrace();
            }
            return rowUpdated;
    }

    public Blog viewBlogListByName(String blogName){
        Blog blog=null;
        try(Connection connection=con.connect();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_BLOG_BY_NAME);){
                preparedStatement.setString(1, blogName);
                System.out.println(preparedStatement);
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()){
                    int id=rs.getInt("blogId");
                    String des=rs.getString("blogDescription");
                    String url=rs.getString("blogImageUrl");
                    String details=rs.getString("blogDetails");
                    blog=new Blog(id,blogName,des,url,details);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return blog;
    }

    public List<Blog> viewAllBlogList(){
        List<Blog> blogs=new ArrayList<>();
        try(Connection connection=con.connect();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_BLOGS);){
                System.out.println(preparedStatement);
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()){
                    int id=rs.getInt("blogId");
                    String name=rs.getString("blogName");
                    String des=rs.getString("blogDescription");
                    String url=rs.getString("blogImageUrl");
                    String details=rs.getString("blogDetails");
                    blogs.add(new Blog(id,name,des,url,details));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return blogs;
    }

    public boolean deleteBlogList(int blogId) throws SQLException{
        boolean rowDeleted=false;
        try(Connection connection=con.connect();
            PreparedStatement statement= connection.prepareStatement(DELETE_BLOG_SQL);){
                statement.setInt(1,blogId);
                rowDeleted=statement.executeUpdate()>0;
            }
            return rowDeleted;
    }
}

