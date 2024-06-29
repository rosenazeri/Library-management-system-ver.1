import java.util.ArrayList;

public class BooksData {
    private static BookData bookData;
    private static BookDataForEditAndCount bookDataForEditAndCount;
    private static ArrayList<BookData> bookDataList = new ArrayList<>();
    private static ArrayList<BookDataForEditAndCount> bookDataForEditAndCountList = new ArrayList<>();
    private static ArrayList<Category> categoryList = Categories.getCategoryListList();
    private static ArrayList<Library> libraryList = Libraries.getLibraryList();
    private static ArrayList<Borrow> borrowList = Borrows.getBorrowList();

    public static void AddBook(String Bcode, String onvan, String creator, String pub, String year2, String existnum, String code, String shenase2) {
        bookData = new BookData(Bcode, onvan, creator, pub, year2, existnum, code, shenase2);
        bookDataForEditAndCount = new BookDataForEditAndCount(Bcode, onvan, creator, pub, year2, existnum, code, shenase2);
        boolean isDuplicate = false;
        if (code.equals("null")) {

        } else {
            for (Category existingCat : categoryList) {
                if (existingCat.getCode().equals(code)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                System.out.println("not-found");
                return;
            }
        }
        isDuplicate = false;
        for (Library existingLab : libraryList) {
            if (existingLab.getShenase1().equals(shenase2)) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            System.out.println("not-found");
            return;
        }

        isDuplicate = false;
        for (BookData existingBookData : bookDataList) {
            if (existingBookData.getBcode().equals(Bcode) && existingBookData.getShenase2().equals(shenase2)) {
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate) {
            System.out.println("duplicate-id");
        } else {
            bookDataList.add(bookData);
            bookDataForEditAndCountList.add(bookDataForEditAndCount);
            System.out.println("success");
        }
    }

    public static void EditBook(String Bcode, String onvan, String creator, String pub, String year2, String existnum, String code, String shenase2) {
        String targetTitle1 = Bcode;
        String targetTitle2 = shenase2;
        String targetTitle3 = code;
        boolean target = false;
        for (int i = 0 , j = 0 ; i < bookDataList.size() && j < bookDataForEditAndCountList.size() ; i++ , j++) {
            BookData book = bookDataList.get(i);
            if (book.getBcode().equals(targetTitle1) && book.getShenase2().equals(targetTitle2) &&
                    (code.equals("-") || code.equals("null") || book.getCode().equals(targetTitle3)|| book.getCode().equals("null"))) {

                if (onvan.equals("-")) {
                    onvan = book.getOnvan();
                }
                if (creator.equals("-")) {
                    creator = book.getCreator();
                }
                if (pub.equals("-")) {
                    pub = book.getPub();
                }
                if (year2.equals("-")) {
                    year2 = book.getYear2();
                }
                if (existnum.equals("-")) {
                    existnum = book.getExistnum();
                }
                if (code.equals("null") || code.equals("-")) {
                    code = book.getCode();
                }
                BookData updatedBookData = new BookData(targetTitle1, onvan, creator, pub, year2, existnum, code, targetTitle2);
                BookDataForEditAndCount updatedBookDataForEditAndCount = new BookDataForEditAndCount(targetTitle1,
                        onvan, creator, pub, year2, existnum, code, targetTitle2);
                bookDataList.set(i, updatedBookData);
                bookDataForEditAndCountList.set(j, updatedBookDataForEditAndCount);
                target = true;
                    /*  System.out.println("اطلاعات کتاب به‌روزرسانی شده:");
                System.out.println("کد کتاب: " + updatedBookData.getBcode());
                System.out.println("عنوان کتاب: " + updatedBookData.getOnvan());
                System.out.println("نویسنده: " + updatedBookData.getCreator());
                System.out.println("ناشر: " + updatedBookData.getPub());
                System.out.println("سال انتشار: " + updatedBookData.getYear2());
                System.out.println("تعداد موجودی: " + updatedBookData.getExistnum());
                System.out.println("کد شابک: " + updatedBookData.getCode());
                System.out.println("شماره شناسه: " + updatedBookData.getShenase2());*/
                break;
            }
        }
        if (target) {
            System.out.println("success");
        } else {
            System.out.println("not-found");
        }
    }

    public static void removeBook(String Bcode, String shenase2) {
        for (Borrow brw : borrowList) {
            if (brw.getShenase2().equals(Bcode) && brw.getShenase1().equals(shenase2)) {
                System.out.println("not-allowed");
                return;
            }
        }
        for (BookDataForEditAndCount boook : bookDataForEditAndCountList ){
            if(boook.getBcode().equals(Bcode) && boook.getShenase2().equals(shenase2)){
                bookDataForEditAndCountList.remove(boook);
                break;
            }
        }
        for (BookData bookData : bookDataList) {
            if (bookData.getBcode().equals(Bcode) && bookData.getShenase2().equals(shenase2)) {
                bookDataList.remove(bookData);
                System.out.println("success");
                return;
            }
        }
        System.out.println("not-found");
    }

    public static void DecreaseBookCount(String Shenase2, String Bcode) {
        for (BookData existingBook : bookDataList) {
            if (existingBook.getBcode().equals(Bcode) && existingBook.getShenase2().equals(Shenase2)) {
                int number = Integer.parseInt(existingBook.getExistnum());
                if (number == 0) {
                    System.out.println("not-allowed");
                    return;
                }
                int newNumber = number - 1;
                existingBook.setExistnum(String.valueOf(newNumber));
                System.out.println("success");
                for (int i = 0; i < bookDataList.size(); i++) {
                    if (bookDataList.get(i).getBcode().equals(Bcode) && bookDataList.get(i).getShenase2().equals(Shenase2)) {
                        bookDataList.set(i, existingBook);
                        break;
                    }
                }
                return;
            }
        }
        System.out.println("not-found");
    }

    public static void IncreaseBookCount(String Shenase2, String Bcode) {
        for (BookData existingBook : bookDataList) {
            if (existingBook.getBcode().equals(Bcode) && existingBook.getShenase2().equals(Shenase2)) {
                int number = Integer.parseInt(existingBook.getExistnum());
                int newNumber = number + 1;
                String afterChange = String.valueOf(newNumber);
                existingBook.setExistnum(afterChange);
                for (int i = 0; i < bookDataList.size(); i++) {
                    if (bookDataList.get(i).getBcode().equals(Bcode) && bookDataList.get(i).getShenase2().equals(Shenase2)) {
                        bookDataList.set(i, existingBook);
                        break;
                    }
                }
            }
        }
    }

    public static ArrayList<BookData> getBookDataList() {
        return bookDataList;
    }
    public static ArrayList<BookDataForEditAndCount> getBookDataForEditAndCountList() {
        return bookDataForEditAndCountList;
    }
}