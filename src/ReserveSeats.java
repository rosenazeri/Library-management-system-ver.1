import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReserveSeats{
    private static ReserveSeat reserveSeat;
    private static ArrayList<ReserveSeat> reserveSeatList= new ArrayList<>();
    private static ArrayList<Lib2> lib2List = new ArrayList<>();
    private static ArrayList<Student> studentList = Students.getStudentList();
    private static ArrayList<Staff> staffList = Staffs.getStaffList();
    private static ArrayList<Library> libraryList = Libraries.getLibraryList();
    public static void ReserveSeat(String id, String passwd, String shenase1, String date, String time1 , String time2){
        reserveSeat = new ReserveSeat( id, passwd, shenase1 , date, time1 , time2);
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
            if (existingLibrary.getShenase1().equals(shenase1)){
                isDuplicate = true;
            }
            boolean exist = false;
            for (Lib2 lib : lib2List) {
                if (lib.getDate().equals(date)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                Lib2 newLib = new Lib2(date, shenase1, existingLibrary.getTableNum());
                lib2List.add(newLib);
            }
        }
        if (!isDuplicate) {
            System.out.println("not-found");
            return;
        }
        long hours ;
        LocalTime startTime = LocalTime.parse(time1, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse(time2, DateTimeFormatter.ofPattern("HH:mm"));
        Duration duration = Duration.between(startTime, endTime);
        hours = duration.toHours();
        if (hours > 8){
            System.out.println("not-allowed");
            return;
        }

        for (ReserveSeat Rsrv : reserveSeatList) {
            if (Rsrv.getId().equals(id) && Rsrv.getDate().equals(date) && Rsrv.getPasswd().equals(passwd) && Rsrv.getShenase1().equals(shenase1)) {
                System.out.println("not-allowed");
                return;
            }
        }
        for (ReserveSeat rzr : reserveSeatList){
            if (rzr.getId().equals(id) && rzr.getPasswd().equals(passwd) && rzr.getDate().equals(date)){
                LocalTime end2 = LocalTime.parse(rzr.getTime2(), DateTimeFormatter.ofPattern("HH:mm"));
                LocalTime start1 = LocalTime.parse(rzr.getTime1(), DateTimeFormatter.ofPattern("HH:mm"));
                if (end2.isAfter(startTime) || endTime.isAfter(start1)) {
                    System.out.println("not-allowed");
                    return;
                }
            }
        }

        for (Lib2 existSeat : lib2List) {
            if (existSeat.getShenase1().equals(shenase1) && existSeat.getDate().equals(date)) {
                int number = Integer.parseInt(existSeat.getTablenum());
                if (number == 0) {
                    boolean mot = false;
                    for (ReserveSeat Rsrv : reserveSeatList) {
                        if (!Rsrv.getId().equals(id) && Rsrv.getDate().equals(date) && Rsrv.getShenase1().equals(shenase1)) {
                            mot = true;
                            LocalTime end2 = LocalTime.parse(Rsrv.getTime2(), DateTimeFormatter.ofPattern("HH:mm"));
                            Duration duration2 = Duration.between(end2, startTime);
                            if (duration2.toMinutes() < 0) {
                                System.out.println("not-available");
                                return;
                            }
                            if (duration2.toMinutes() >= 0) {
                                System.out.println("success");
                                reserveSeatList.add(reserveSeat);
                                return;
                            }
                        }
                    }
                    if (!mot){
                        System.out.println("not-available");
                        return;
                    }
                }
                int newNumber = number - 1;
                existSeat.setTablenum(String.valueOf(newNumber));
                System.out.println("success");
                reserveSeatList.add(reserveSeat);
                for (int i = 0; i < lib2List.size(); i++) {
                    if (lib2List.get(i).getShenase1().equals(shenase1)) {
                        lib2List.set(i, existSeat);
                        break;
                    }
                }
                return;
            }
        }

    }
}