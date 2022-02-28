<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.*,java.util.*"%>
<html>
    <head>
        <title>Add Blog</title>
        <link rel="stylesheet" href="assets/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <header>
			<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #fa6d80">
				<div>
					<a href="index.jsp" class="navbar-brand" style="color: black;padding-left: 60px;"><b>Blog Name</b></a>
				</div>
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/list" class="nav-link" id="addBlog" style="color: black;padding-left:800px"><b>Add Blog</b></a></li>
				</ul>
			</nav>
		</header><br>
        <!--<div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${blog != null}">
                        <form action="update" method="post">
                    </c:if>
                    <c:if test="${blog == null}">
                        <form action="insert" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${blog != null}">
                            Edit blog
                        </c:if>
                            <c:if test="${blog == null}">
                            Add new Blog
                        </c:if>
                        </h2>
                    </caption>
    
                    <c:if test="${blog != null}">
                        <input type="hidden" name="id" value="<c:out value='${blog.blogId}' />" />
                    </c:if>
    
                    <fieldset class="form-group">
                        <label>Blog Name</label> <input type="text"
                            value="<c:out value='${blog.blogName}' />" class="form-control"
                            name="blogName" required="required">
                    </fieldset>
    
                    <fieldset class="form-group">
                        <label>Blog Description</label> <input type="text"
                            value="<c:out value='${blog.blogDescription}' />" class="form-control"
                            name="blogDescription">
                    </fieldset>
    
                    <fieldset class="form-group">
                        <label>Blog Image Url</label> <input type="text"
                            value="<c:out value='${blog.blogImageUrl}' />" class="form-control"
                            name="blogImageUrl">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Blog Details</label> <input type="text"
                            value="<c:out value='${blog.blogDetails}' />" class="form-control"
                            name="blogDetails">
                    </fieldset>
    
                    <button type="submit" class="btn btn-success">Save</button>
                    </form>
                </div>
            </div>
        </div>-->
        <form name="addblog" action="servlet.java">
            <input type="text" value="Blog Name">
            <input type="text" value="Blog Description">
            <input type="text" value="Blog Image Url">
            <input type="text" value="Blog Details">
            <button><input type="submit" value="Save"></button>
        </form>
    </body>
</html>