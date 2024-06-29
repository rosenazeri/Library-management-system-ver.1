import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Returns {
    private static Return1 return1;
    private static ArrayList<Return1> return1List = new ArrayList<>();
    private static ArrayList<Borrow> borrowList = Borrows.getBorrowList();
    private static ArrayList<Student> studentList = Students.getStudentList();
    private static ArrayList<Staff> staffList = Staffs.getStaffList();
    private static ArrayList<BookData> bookDataList = BooksData.getBookDataList();
    private static ArrayList<Thesis> thesisList = Theses.getThesisList();
    private static ArrayList<DeletedBorrow> deletedBorrowList = new ArrayList<>();
    private static ArrayList<KolJarime> kolJarimeList = new ArrayList<>();

    public static void Return1Book(String id, String passwd, String shenase1, String shenase2, String date2, String time2) {
        return1 = new Return1(id, passwd, shenase1, shenase2, date2, time2);
        Student foundStudent = null;
        for (Student existingStudent : studentList) {
            if (existingStudent.getId().equals(id)) {
                foundStudent = existingStudent;
                break;
            }
        }
        if (foundStudent != null) {
            if (foundStudent.getPasswd().equals(passwd)) {
            } else {
                System.out.println("invalid-pass");
                return;
            }
        } else {
            Staff foundStaff = null;
            for (Staff existingStaff : staffList) {
                if (existingStaff.getId().equals(id)) {
                    foundStaff = existingStaff;
                    break;
                }
            }
            if (foundStaff != null) {
                if (foundStaff.getPasswd().equals(passwd)) {
                } else {
                    System.out.println("invalid-pass");
                    return;
                }
            } else {
                System.out.println("not-found");
                return;
            }
        }
        Iterator<Borrow> iterator = borrowList.iterator();
        Borrow latestBorrow = null;
        long hours;
        while (iterator.hasNext()) {
            Borrow existingBorrow = iterator.next();
            if (existingBorrow.getId().equals(id) && existingBorrow.getPasswd().equals(passwd) &&
                    existingBorrow.getShenase1().equals(shenase1) && existingBorrow.getShenase2().equals(shenase2)) {
                if (latestBorrow == null || (existingBorrow.getDate().compareTo(latestBorrow.getDate()) >= 0)
                        && existingBorrow.getTime().compareTo(latestBorrow.getTime()) >= 0) {
                    latestBorrow = existingBorrow;
                }
            }
        }
        if (latestBorrow != null) {
            String startDateTimeString = (date2 + " " + time2 + ":00");
            String endDateTimeString = (latestBorrow.getDate() + " " + latestBorrow.getTime() + ":00");
            LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Duration duration = Duration.between(endDateTime, startDateTime);
            hours = duration.toHours();
            borrowList.remove(latestBorrow);
        } else {
            System.out.println("not-found");
            return;
        }
        for (BookData existingBook : bookDataList) {
            if (existingBook.getBcode().equals(shenase2)) {
                BooksData.IncreaseBookCount(shenase1, shenase2);
                for (Student stu : studentList) {
                    if (stu.getId().equals(id)) {
                        if (hours > 240) {
                            long sum = ((hours - 240) * 50);
                            System.out.println(sum);
                            KolJarime newKolJarime = new KolJarime(sum);
                            kolJarimeList.add(newKolJarime);
                            DeletedBorrow deletedBorrow = new DeletedBorrow(id, passwd, shenase1, shenase2, date2, time2);
                            deletedBorrowList.add(deletedBorrow);
                            return;
                        } else {
                            System.out.println("success");
                            return;
                        }
                    }
                }
                for (Staff stf : staffList) {
                    if (stf.getId().equals(id)) {
                        if (hours > 336) {
                            long sum = ((hours - 336) * 100);
                            System.out.println(sum);
                            KolJarime newKolJarime = new KolJarime(sum);
                            kolJarimeList.add(newKolJarime);
                            DeletedBorrow deletedBorrow = new DeletedBorrow(id, passwd, shenase1, shenase2, date2, time2);
                            deletedBorrowList.add(deletedBorrow);
                            return;
                        } else {
                            System.out.println("success");
                            return;
                        }
                    }
                }
            }
        }
        for (Thesis existingThesis : thesisList) {
            if (existingThesis.getShenase3().equals(shenase2)) {
                Theses.IncreasethesisCount(shenase2, shenase1);
                for (Student stu : studentList) {
                    if (stu.getId().equals(id)) {
                        if (hours > 168) {
                            long sum = ((hours - 168) * 50);
                            System.out.println(sum);
                            KolJarime newKolJarime = new KolJarime(sum);
                            kolJarimeList.add(newKolJarime);
                            DeletedBorrow deletedBorrow = new DeletedBorrow(id, passwd, shenase1, shenase2, date2, time2);
                            deletedBorrowList.add(deletedBorrow);
                            return;
                        } else {
                            System.out.println("success");
                            return;
                        }
                    }
                }
                for (Staff stf : staffList) {
                    if (stf.getId().equals(id)) {
                        if (hours > 240) {
                            long sum = ((hours - 240) * 100);
                            System.out.println(sum);
                            KolJarime newKolJarime = new KolJarime(sum);
                            kolJarimeList.add(newKolJarime);
                            DeletedBorrow deletedBorrow = new DeletedBorrow(id, passwd, shenase1, shenase2, date2, time2);
                            deletedBorrowList.add(deletedBorrow);
                            return;
                        } else {
                            System.out.println("success");
                            return;
                        }
                    }
                }
            }
        }
    }
    public static void jarime(){
        long total = 0L;
        for (int i = 0; i < kolJarimeList.size(); i++) {
            total += kolJarimeList.get(i).getJarime();
        }

        System.out.println(total);
    }

    public static ArrayList<Return1> getReturn1List() {
        return return1List;
    }
    public static ArrayList<DeletedBorrow> getDeletedBorrowList() {

        return deletedBorrowList;
    }
    public static ArrayList<KolJarime> getKolJarimeList() {

        return kolJarimeList;
    }
}