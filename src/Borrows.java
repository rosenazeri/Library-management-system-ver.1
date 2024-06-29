import java.util.ArrayList;

public class Borrows {
    private static Borrow borrow;
    private static ArrayList<Borrow> borrowList = new ArrayList<>();
    private static ArrayList<Student> studentList = Students.getStudentList();
    private static ArrayList<Staff> staffList = Staffs.getStaffList();
    private static ArrayList<BookData> bookDataList = BooksData.getBookDataList();
    private static ArrayList<Library> libraryList = Libraries.getLibraryList();
    private static ArrayList<Thesis> thesisList = Theses.getThesisList();

    public static void BorrowBook(String id, String passwd, String shenase1, String shenase2, String date, String time) {
        borrow = new Borrow(id, passwd, shenase1, shenase2, date, time);
        Student foundStudent = null;
        boolean stu = false;
        boolean stf = false;
        for (Student existingStudent : studentList) {
            if (existingStudent.getId().equals(id)) {
                foundStudent = existingStudent;
                break;
            }
        }
        if (foundStudent != null) {
            if (foundStudent.getPasswd().equals(passwd)) {
                stu = true;
            } else {
                System.out.println("invalid-pass");
                return;
            }
        }
        else {
            Staff foundStaff = null;
            for (Staff existingStaff : staffList) {
                if (existingStaff.getId().equals(id)) {
                    foundStaff = existingStaff;
                    break;
                }
            }
            if (foundStaff != null) {
                if (foundStaff.getPasswd().equals(passwd)) {
                    stf = true;
                } else {
                    System.out.println("invalid-pass");
                    return;
                }
            } else {
                System.out.println("not-found");
                return;
            }
        }
        boolean isDuplicate = false;
        for (Library existingLibrary : libraryList) {
            if (existingLibrary.getShenase1().equals(shenase1)) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            System.out.println("not-found");
            return;
        }
        isDuplicate = false;
        for (BookData existingBook : bookDataList) {
            if (existingBook.getBcode().equals(shenase2) && existingBook.getShenase2().equals(shenase1)
                    && !existingBook.getExistnum().equals("0")) {
                isDuplicate = true;
                break;
            } else if (existingBook.getBcode().equals(shenase2) && existingBook.getShenase2().equals(shenase1)
                    && existingBook.getExistnum().equals("0")) {
                System.out.println("not-allowed");
                return;
            }
        }
        if (!isDuplicate) {
            boolean brrwed = false;
            for (Thesis existingThesis : thesisList) {
                if (existingThesis.getShenase3().equals(shenase2) && existingThesis.getShenase().equals(shenase1)) {
                    if (!existingThesis.isBorrowed()) {
                        brrwed = true;
                    }
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                System.out.println("not-found");
                return;
            } else if (!brrwed) {
                System.out.println("not-allowed");
                return;
            }
        }

        int sum = 0;
        for (Borrow brw : borrowList) {
            if (brw.getId().equals(id)) {
                sum++;
            }
        }
        if (stu && sum >= 3) {
            System.out.println("not-allowed");
            return;
        }
        if (stf && sum >= 5) {
            System.out.println("not-allowed");
            return;
        }

        borrowList.add(borrow);
        //یکی از تعداد کتاب ها کم شد
        for (BookData existingBook : bookDataList) {
            if (existingBook.getBcode().equals(shenase2) && existingBook.getShenase2().equals(shenase1)) {
                BooksData.DecreaseBookCount(shenase1, shenase2);
                break;
            }
        }
        for (Thesis existingThesis : thesisList) {
            if (existingThesis.getShenase3().equals(shenase2) && existingThesis.getShenase().equals(shenase1)) {
                Theses.DecreasethesisCount(shenase2, shenase1);
                break;
            }
        }
    }

    public static ArrayList<Borrow> getBorrowList() {
        return borrowList;
    }

}