import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Passd{
    private static Passed passed;
    private static ArrayList<Passed> passedList = new ArrayList<>();
    private static ArrayList<Borrow> borrowList = Borrows.getBorrowList();
    private static ArrayList<Student> studentList = Students.getStudentList();
    private static ArrayList<Staff> staffList = Staffs.getStaffList();
    private static ArrayList<BookData> bookDataList = BooksData.getBookDataList();
    private static ArrayList<Thesis> thesisList = Theses.getThesisList();
    private static ArrayList<Library> libraryList = Libraries.getLibraryList();



    public static void PassedDeadline(String lib , String date , String time) {
        passed = new Passed(lib, date, time);
        ArrayList<String> myArrayList = new ArrayList<>();
        long hours;
        boolean exist = false;
        boolean ok = false;
        for (Library library : libraryList) {
            if (library.getShenase1().equals(lib)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            System.out.println("not-found");
            return;
        }
        for (Borrow brw : borrowList) {
            if(brw.getShenase1().equals(lib)){
                String startDateTimeString = (date + " " + time + ":00");
                String endDateTimeString = (brw.getDate() + " " + brw.getTime() + ":00");
                LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                Duration duration = Duration.between(endDateTime, startDateTime);
                hours = duration.toHours();
                for (Student stu : studentList) {
                    if (brw.getId().equals(stu.getId())) {
                        for (BookData bookData : bookDataList) {
                            if (brw.getShenase2().equals(bookData.getBcode())) {
                                if (hours > 240) {
                                    myArrayList.add(bookData.getBcode());
                                    ok = true;
                                }
                            }
                        }
                        for (Thesis thesis : thesisList) {
                            if (brw.getShenase2().equals(thesis.getShenase3())) {
                                if (hours > 168) {
                                    myArrayList.add(thesis.getShenase3());
                                    ok = true;
                                }
                            }
                        }
                    }
                }
                for (Staff staff : staffList) {
                    if (brw.getId().equals(staff.getId())) {
                        for (BookData bookData : bookDataList) {
                            if (brw.getShenase2().equals(bookData.getBcode())) {
                                if (hours > 336) {
                                    myArrayList.add(bookData.getBcode());
                                    ok = true;
                                }
                            }
                        }
                        for (Thesis thesis : thesisList) {
                            if (brw.getShenase2().equals(thesis.getShenase3())) {
                                if (hours > 240) {
                                    myArrayList.add(thesis.getShenase3());
                                    ok = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!ok) {
            System.out.println("none");
        } else {
            Set<String> uniqueCodes = new HashSet<>(myArrayList);
            List<String> sortedUniqueCodes = new ArrayList<>(uniqueCodes);
            Collections.sort(sortedUniqueCodes);

            for (int i = 0; i < sortedUniqueCodes.size(); i++) {
                if (i > 0) {
                    System.out.print("|");
                }
                System.out.print(sortedUniqueCodes.get(i));
            }
            System.out.println();
        }
    }

}