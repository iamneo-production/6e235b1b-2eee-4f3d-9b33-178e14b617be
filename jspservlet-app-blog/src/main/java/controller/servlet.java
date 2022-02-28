package controller;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import service.BlogListDao;

@WebServlet("/")
public class servlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private BlogListDao blogListDao;

    public servlet(){
        this.blogListDao=new BlogListDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String action = request.getContextPath();
        try{
			switch (action){
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBlog(request, response);
                    break;
                case "/delete":
                    deleteBlog(request, response);
                    break;
                case "/edit":
                    EditBlog(request, response);
                    break;
                case "/update":
                    updateBlog(request, response);
                    break;
                default:
                    blogsList(request, response);
                    break;
			}
		}
        catch (SQLException ex){
			ex.printStackTrace();
        }
	}

    private void blogsList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<Blog> blogsList = blogListDao.viewAllBlogList();
        request.setAttribute("blogsList", blogsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Blogs-list.jsp");
        dispatcher.forward(request, response);
	}

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog-form.jsp");
		dispatcher.forward(request, response);
	}

    private void EditBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String name = request.getParameter("blogName");
		Blog existingBlog = blogListDao.viewBlogListByName(name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog-form.jsp");
		request.setAttribute("blog", existingBlog);
		dispatcher.forward(request, response);
	}

    private void insertBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("blogName");
		String des = request.getParameter("blogDescription");
		String url = request.getParameter("blogImageUrl");
        String details=request.getParameter("blogDetails");
		Blog newBlog=new Blog(name, des,url,details);
		blogListDao.addBlogList(newBlog);
		response.sendRedirect("blogslist");
	}

    private void updateBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("blogId"));
		String name = request.getParameter("blogName");
		String des = request.getParameter("blogDescription");
		String url = request.getParameter("blogImageUrl");
        String details=request.getParameter("blogDetails");
		Blog b = new Blog(id, name,des,url,details);
		blogListDao.updateBlogList(b);
		response.sendRedirect("blogslist");
	}

    private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		blogListDao.deleteBlogList(id);
		response.sendRedirect("blogslist");
	}

}    
