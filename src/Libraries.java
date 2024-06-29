import java.util.ArrayList;

public class Libraries {
    private static Library library;

    private static ArrayList<Library> libraryList = new ArrayList<>();
    private static ArrayList<BookData> bookDataList = BooksData.getBookDataList();
    private static ArrayList<BookDataForEditAndCount> bookDataForEditAndCountList = BooksData.getBookDataForEditAndCountList();
    private static ArrayList<Thesis> thesisList = Theses.getThesisList();
    private static ArrayList<Borrow> borrowList = Borrows.getBorrowList();

    public static void AddLib(String shenase1, String libname, String start, String tableNum, String address) {
        library = new Library(shenase1, libname, start, tableNum, address);
        boolean isDuplicate = false;
        for (Library existingLibrary : libraryList) {
            if (existingLibrary.getShenase1().equals(library.getShenase1())) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate) {
            System.out.println("duplicate-id");

        } else {
            libraryList.add(library);
            System.out.println("success");

        }
    }

    public static void LibReport(String shenase1) {
        int totalBookCount = 0;
        int totalThesisCount = 0;
        int borrowedBookCount = 0;
        int borrowedThesisCount = 0;
        boolean exist = false;

        for (Library library : libraryList) {
            if (library.getShenase1().equals(shenase1)) {
                exist = true;
                for (BookDataForEditAndCount book : bookDataForEditAndCountList) {
                    if (book.getShenase2().equals(shenase1)) {
                        totalBookCount += Integer.parseInt(book.getExistnum());
                    }
                }
                for (Thesis thesis : thesisList) {
                    if (thesis.getShenase().equals(shenase1)) {
                        totalThesisCount++;
                    }
                }
            }
        }
        for (BookData book : bookDataList) {
            for (Borrow brw : borrowList) {
                if (brw.getShenase2().equals(book.getBcode()) && brw.getShenase1().equals(shenase1) && book.getShenase2().equals(shenase1)) {
                    borrowedBookCount++;
                }
            }
        }
        for (Thesis tes : thesisList) {
            for (Borrow brw : borrowList) {
                if (brw.getShenase2().equals(tes.getShenase3()) && brw.getShenase1().equals(shenase1) && tes.getShenase().equals(shenase1)) {
                    borrowedThesisCount++;
                }
            }
        }
        if (exist) {
            System.out.println(totalBookCount + " " + totalThesisCount + " " + borrowedBookCount + " " + borrowedThesisCount);
        } else {
            System.out.println("not-found");
        }
    }

    public static ArrayList<Library> getLibraryList() {
        return libraryList;
    }

}