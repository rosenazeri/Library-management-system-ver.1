import java.util.ArrayList;

public class Categories {
    private static Category category;
    private static ArrayList<Category> categoryList = new ArrayList<>();
    private static ArrayList<BookData> bookDataList = BooksData.getBookDataList();
    private static ArrayList<Thesis> thesisList = Theses.getThesisList();

    private static ArrayList<BookDataForEditAndCount> bookDataForEditAndCountList= BooksData.getBookDataForEditAndCountList();

    public static void AddCat(String code, String category1) {
        category = new Category(code, category1);
        boolean isDuplicate = false;
        for (Category existingCategory : categoryList) {
            if (existingCategory.getCode().equals(category.getCode())) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate) {
            System.out.println("duplicate-id");

        } else {
            categoryList.add(category);
            System.out.println("success");
        }
    }

    public static void CatReport(String code) {
        int sum = 0;
        int sum2 = 0;
        boolean hast = false;
        for (BookDataForEditAndCount books : bookDataForEditAndCountList) {
            if (books.getCode().equals(code)) {
                hast = true;
                int number = Integer.parseInt(books.getExistnum());
                sum += number;
            }

        }
        for (Thesis thesiss : thesisList) {
            if (thesiss.getCode().equals(code)) {
                hast = true;
                sum2++;
            }
        }

        if (hast) {
            System.out.println(sum + " " + sum2);
        } else {
            System.out.println("not-found");
        }
    }

    public static ArrayList<Category> getCategoryListList() {
        return categoryList;
    }
}