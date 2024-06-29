import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        while (true) {
            String inpt = x.nextLine();
            if (inpt.equals("report-penalties-sum")){
                //محاسبه کل جریمه ها
               Returns.jarime();
               continue;
            }
            if (inpt.equals("finish")) {
                return;
            }
            String[] command = inpt.split("#");
            String[] info = command[1].split("\\|");

            if (command[0].equals("add-library")) {
                //اضافه کردن کتابخانه
                Libraries.AddLib(info[0], info[1], info[2], info[3], info[4]);
            } else if (command[0].equals("add-category")) {
                //اضافه کردن کتگوری
                Categories.AddCat(info[0], info[1]);
            } else if (command[0].equals("add-book")) {
                //اضافه کردن کتاب
                BooksData.AddBook(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7]);
            } else if (command[0].equals("edit-book")) {
                //ادیت کردن مشخصات کتاب
                BooksData.EditBook(info[0], info[2], info[3], info[4], info[5], info[6], info[7], info[1]);
            } else if (command[0].equals("remove-book")) {
                //حذف کتاب
                BooksData.removeBook(info[0], info[1]);
            } else if (command[0].equals("add-thesis")) {
                //اضاف کردن پایان نامه
                Theses.AddTheses(info[0], info[1], info[2], info[3], info[4], info[5], info[6]);
            } else if (command[0].equals("edit-thesis")) {
                //ادیت کردن مشخصات پایان‌نامه
                Theses.EditThesis(info[0], info[2], info[3], info[4], info[5], info[6], info[1]);
            } else if (command[0].equals("remove-thesis")) {
                // کد حذف پایان‌نامه
                Theses.removeThesis(info[0], info[1]);
            } else if (command[0].equals("add-student")) {
                //اضافه کردن دانشجو و کارمند
                Students.AddStu(info[0], info[1], info[2], info[3], info[4], info[5], info[6]);
            } else if (command[0].equals("add-staff")) {
                //اضافه کردن دانشجو و کارمند
                Staffs.AddStaff(info[0], info[1], info[2], info[3], info[4], info[5], info[6]);
            } else if (command[0].equals("edit-student")) {
                //  تغیرات دانشجو یا کارمند
                Students.EditStu(info[0], info[1], info[2], info[3], info[4], info[5], info[6]);
            } else if (command[0].equals("edit-staff")) {
                //  تغیرات دانشجو یا کارمند
                Staffs.EditStaff(info[0], info[1], info[2], info[3], info[4], info[5], info[6]);
            } else if (command[0].equals("remove-student")) {
                // حذف کاربر
                Students.removeStu(info[0]);
            } else if (command[0].equals("remove-staff")) {
                // حذف کاربر
                Staffs.removeStaff(info[0]);
            } else if (command[0].equals("borrow")) {
                // قرض کتاب
                Borrows.BorrowBook(info[0], info[1], info[2], info[3], info[4], info[5]);
            } else if (command[0].equals("return")) {
                // پس دادن کتاب
                Returns.Return1Book(info[0], info[1], info[2], info[3], info[4], info[5]);
            } else if (command[0].equals("search")) {
                // سرچ
                Searchh.Searching(info[0]);
                System.out.println();
            } else if (command[0].equals("search-user")) {
                // سرچ
                SearchhUser.SearchUsr(info[0], info[1], info[2]);
                System.out.println();
            } else if (command[0].equals("category-report")) {
                //گزارش
                Categories.CatReport(info[0]);
            } else if (command[0].equals("library-report")) {
                //گزارش
                Libraries.LibReport(info[0]);
            }
            else if (command[0].equals("report-passed-deadline")) {
                //گزارش
                Passd.PassedDeadline(info[0], info[1], info[2]);
            }
            else if (command[0].equals("reserve-seat")){
                //رزرو میز
                ReserveSeats.ReserveSeat(info[0], info[1], info[2], info[3], info[4], info[5]);
            }
        }
    }
}