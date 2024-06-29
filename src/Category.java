import java.util.ArrayList;


public class Category {
    private String code;
    private String category1;
    private ArrayList<Category> categoryList = new ArrayList<>();

    public Category(String code, String category) {
        this.code = code;
        this.category1 = category1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public void addCat(Category category) {
        categoryList.add(category);
    }
}