import java.util.ArrayList;

public class Staffs {
    private static Staff staff;
    private static ArrayList<Staff> staffList = new ArrayList<>();
    private static ArrayList<Borrow> borrowList = Borrows.getBorrowList();
    private static ArrayList<DeletedBorrow> deletedBorrowList = Returns.getDeletedBorrowList();

    public static void AddStaff(String id, String passwd, String name, String lastname, String nationalNum, String year, String address) {
        staff = new Staff(id, passwd, name, lastname, nationalNum, year, address);
        boolean isDuplicate = false;

        for (Staff existingStaff : staffList) {
            if (existingStaff.getId().equals(id)) {
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate) {
            System.out.println("duplicate-id");
        } else {
            staffList.add(staff);
            System.out.println("success");
        }
    }

    public static void EditStaff(String id, String passwd, String name, String lastname, String nationalNum, String year, String address) {
        boolean target = false;

        for (Staff existingStaff : staffList) {
            if (existingStaff.getId().equals(id)) {
                target = true;
                if (!passwd.equals("-")) {
                    existingStaff.setPasswd(passwd);
                }
                if (!name.equals("-")) {
                    existingStaff.setName(name);
                }
                if (!lastname.equals("-")) {
                    existingStaff.setLastname(lastname);
                }
                if (!nationalNum.equals("-")) {
                    existingStaff.setNationalNum(nationalNum);
                }
                if (!year.equals("-")) {
                    existingStaff.setYear(year);
                }
                if (!address.equals("-")) {
                    existingStaff.setAddress(address);
                }
                for (Borrow brw : borrowList){
                    if (brw.getId().equals(id)) {
                        if (!passwd.equals("-")) {
                            brw.setPasswd(passwd);
                        }
                    }
                }
                /*System.out.println("اطلاعات دانشجو یا کارمند به‌روزرسانی شد :");
                System.out.println(" شماره دانشجویی یا کارمندی : " + existingStaff.getId());
                System.out.println("رمز : " + existingStaff.getPasswd());
                System.out.println("نام : " + existingStaff.getName());
                System.out.println("نام خانوادگی : " + existingStaff.getLastname());
                System.out.println(" کد ملی : " + existingStaff.getNationalNum());
                System.out.println("سال ورود : " + existingStaff.getYear());
                System.out.println(" آدرس : " + existingStaff.getAddress());*/
            }
        }

        if (!target) {
            System.out.println("not-found");
        } else {
            System.out.println("success");
        }
    }

    public static void removeStaff(String id) {
        deletedBorrowList = Returns.getDeletedBorrowList();
        for (Borrow brw : borrowList) {
            if (brw.getId().equals(id)) {
                System.out.println("not-allowed");
                return;
            }
        }
        for (DeletedBorrow DB : deletedBorrowList) {
            if (DB.getId().equals(id)) {
                System.out.println("not-allowed");
                return;
            }
        }

        for (Staff staff : staffList) {
            if (staff.getId().equals(id)) {
                staffList.remove(staff);
                System.out.println("success");
                return;
            }
        }
        System.out.println("not-found");
    }

    public static ArrayList<Staff> getStaffList() {
        return staffList;
    }
}