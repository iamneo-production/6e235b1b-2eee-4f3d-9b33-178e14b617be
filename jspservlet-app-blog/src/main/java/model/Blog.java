package model;
public class Blog{
    private int blogId; 
    private String blogName; 
    private String blogDescription; 
    private String blogImageUrl; 
    private String blogDetails;

    public Blog(int Id,String Name, String Description, String ImageUrl, String Details){
        super();
        this.blogId=Id;
        this.blogName=Name;
        this.blogDescription=Description;
        this.blogImageUrl=ImageUrl;
        this.blogDetails=Details;
    }

    public Blog(String Name, String Description, String ImageUrl, String Details){
        super();
        this.blogName=Name;
        this.blogDescription=Description;
        this.blogImageUrl=ImageUrl;
        this.blogDetails=Details;
    }

    public int getId(){
        return blogId;
    }
    public void setId(int blogId){
        this.blogId=blogId;
    }
    public String getName(){
        return blogName;
    }
    public void setName(String blogName){
        this.blogName=blogName;
    }
    public String getDescription(){
        return blogDescription;
    }
    public void setDescription(String blogDescription){
        this.blogDescription=blogDescription;
    }
    public String getUrl(){
        return blogImageUrl;
    }
    public void setUrl(String blogImageUrl){
        this.blogImageUrl=blogImageUrl;
    }
    public String getDetails(){
        return blogDetails;
    }
    public void setDetails(String blogDetails){
        this.blogDetails=blogDetails;
    }

}