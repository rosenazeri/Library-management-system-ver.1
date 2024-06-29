import java.util.ArrayList;

public class Students {
    private static Student student;
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Borrow> borrowList = Borrows.getBorrowList();

    private static ArrayList<DeletedBorrow> deletedBorrowList = Returns.getDeletedBorrowList();
    public static void AddStu(String id, String passwd, String name, String lastname, String nationalNum, String year, String address) {
        student = new Student(id, passwd, name, lastname, nationalNum, year, address);
        boolean isDuplicate = false;

        for (Student existingStudent : studentList) {
            if (existingStudent.getId().equals(id)) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate) {
            System.out.println("duplicate-id");
        } else {
            studentList.add(student);
            System.out.println("success");
        }
    }

    public static void EditStu(String id, String passwd, String name, String lastname, String nationalNum, String year, String address) {
        boolean target = false;

        for (Student updatedStudent : studentList) {
            if (updatedStudent.getId().equals(id)) {
                target = true;
                if (!passwd.equals("-")) {
                    updatedStudent.setPasswd(passwd);
                }
                if (!name.equals("-")) {
                    updatedStudent.setName(name);
                }
                if (!lastname.equals("-")) {
                    updatedStudent.setLastname(lastname);
                }
                if (!nationalNum.equals("-")) {
                    updatedStudent.setNationalNum(nationalNum);
                }
                if (!year.equals("-")) {
                    updatedStudent.setYear(year);
                }
                if (!address.equals("-")) {
                    updatedStudent.setAddress(address);
                }
                for (Borrow brw : borrowList){
                    if (brw.getId().equals(id)) {
                        if (!passwd.equals("-")) {
                            brw.setPasswd(passwd);
                        }
                    }
                }

               /*System.out.println("اطلاعات دانشجو یا کارمند به‌روزرسانی شد :");
                System.out.println(" شماره دانشجویی یا کارمندی : " + updatedStudent.getId());
                System.out.println("رمز : " + updatedStudent.getPasswd());
                System.out.println("نام : " + updatedStudent.getName());
                System.out.println("نام خانوادگی : " + updatedStudent.getLastname());
                System.out.println(" کد ملی : " + updatedStudent.getNationalNum());
                System.out.println("سال ورود : " + updatedStudent.getYear());
                System.out.println(" آدرس : " + updatedStudent.getAddress());*/
            }
        }

        if (!target) {
            System.out.println("not-found");
        } else {
            System.out.println("success");
        }
    }
    public static void removeStu(String id) {
        for (Borrow brw : borrowList) {
            if (brw.getId().equals(id)) {
                System.out.println("not-allowed");
                return;
            }
        }
        for (DeletedBorrow DB : deletedBorrowList){
            if (DB.getId().equals(id)) {
                System.out.println("not-allowed");
                return;
            }
        }
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                System.out.println("success");
                return;
            }
        }
        System.out.println("not-found");
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }
}