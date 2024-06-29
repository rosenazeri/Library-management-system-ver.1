import java.util.ArrayList;
import java.util.Collections;

public class SearchhUser {
    private static SearchUser searchUser;
    private static ArrayList<Search> searchList = new ArrayList<>();
    private static ArrayList<Student> studentList = Students.getStudentList();
    private static ArrayList<Staff> staffList = Staffs.getStaffList();

    public static void SearchUsr(String id1, String password, String nameOrLast) {
        searchUser = new SearchUser(id1, password, nameOrLast);
        Student foundStudent = null;
        boolean isDuplicate = false;
        boolean isFirstMatch = true;
        ArrayList<String> myArrayList = new ArrayList<>();
        for (Student existingStudent : studentList) {
            if (existingStudent.getId().equals(id1)) {
                foundStudent = existingStudent;
                break;
            }
        }
        if (foundStudent != null) {
            if (foundStudent.getPasswd().equals(password)) {
            }
            else {
                System.out.print("invalid-pass");
                return;
            }
        }
        else {
            Staff foundStaff = null;
            for (Staff existingStaff : staffList) {
                if (existingStaff.getId().equals(id1)) {
                    foundStaff = existingStaff;
                    break;
                }
            }
            if (foundStaff != null) {
                if (foundStaff.getPasswd().equals(password)) {
                }
                else {
                    System.out.print("invalid-pass");
                    return;
                }
            } else {
                System.out.print("not-found");
                return;
            }
        }
        for (Student existingstu : studentList) {
            if (existingstu.getName().toLowerCase().contains(nameOrLast.toLowerCase()) || existingstu.getLastname().toLowerCase().contains(nameOrLast.toLowerCase())) {
                isDuplicate = true;
                myArrayList.add(existingstu.getId());
            }
        }
        for (Staff existingStf : staffList) {
            if (existingStf.getName().toLowerCase().contains(nameOrLast.toLowerCase())) {
                isDuplicate = true;
                myArrayList.add(existingStf.getId());
            }
        }
        if (!isDuplicate) {
            System.out.print("not-found");
        }
        else {
            Collections.sort(myArrayList);
            for (String id : myArrayList) {

                if (!isFirstMatch){
                    System.out.print("|");
                }
                else {
                    isFirstMatch = false;
                }
                System.out.print(id);
            }
        }
    }
}