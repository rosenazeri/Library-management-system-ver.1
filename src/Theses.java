import java.util.ArrayList;
public class Theses {
    private static Thesis thesis;
    private static ArrayList<Thesis> thesisList = new ArrayList<>();
    private static ArrayList<Category> categoryList = Categories.getCategoryListList();
    private static ArrayList<Library> libraryList = Libraries.getLibraryList();
    private static ArrayList<Borrow> borrowList = Borrows.getBorrowList();

    public static void AddTheses(String shenase3, String onvan, String creatorname, String professor, String year2, String code, String shenase) {
        thesis = new Thesis(shenase3, onvan, creatorname, professor, year2, code, shenase);
        boolean isDuplicate = false;
        if (code.equals("null")) {
        } else {
            for (Category existingCat : categoryList) {
                if (existingCat.getCode().equals(code)) {
                    isDuplicate = true;
                }
            }
            if (!isDuplicate) {
                System.out.println("not-found");
                return;
            }
        }
        isDuplicate = false;
        for (Library existingLab : libraryList) {
            if (existingLab.getShenase1().equals(shenase)) {
                isDuplicate = true;
            }
        }
        if (!isDuplicate) {
            System.out.println("not-found");
            return;
        }
        isDuplicate = false;
        for (Thesis existingThesis : thesisList) {
            if (existingThesis.getShenase3().equals(shenase3) && existingThesis.getShenase().equals(shenase)) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate) {
            System.out.println("duplicate-id");
        } else {
            thesisList.add(thesis);
            System.out.println("success");
        }
    }

    public static void EditThesis(String shenase3, String onvan, String creatorName, String professor, String year2, String code, String shenase) {
        String targetTitle1 = shenase3;
        String targetTitle2 = shenase;
        String targetTitle3 = code;
        boolean target = false;

        for (int i = 0; i < thesisList.size(); i++) {
            Thesis tss = thesisList.get(i);
            if (tss.getShenase3().equals(targetTitle1) && tss.getShenase().equals(targetTitle2) &&
                    (code.equals("-") || code.equals("null") || tss.getCode().equals(targetTitle3)|| tss.getCode().equals("null"))) {
                if (onvan.equals("-")) {
                    onvan = tss.getOnvan();
                }
                if (creatorName.equals("-")) {
                    creatorName = tss.getCreatorName();
                }
                if (professor.equals("-")) {
                    professor = tss.getProfessor();
                }
                if (year2.equals("-")) {
                    year2 = tss.getYear2();
                }
                if (code.equals("null") || code.equals("-")) {
                    code = tss.getCode();
                }
                target = true;
                Thesis updatedThesis = new Thesis(targetTitle1, onvan, creatorName, professor, year2, code, targetTitle2);
                thesisList.set(i, updatedThesis);
                   /* System.out.println("اطلاعات پایان‌نامه به‌روزرسانی شد:");
                    System.out.println("شماره شناسه: " + updatedThesis.getShenase3());
                    System.out.println("عنوان: " + updatedThesis.getOnvan());
                    System.out.println("نام نویسنده: " + updatedThesis.getCreatorName());
                    System.out.println("نام استاد راهنما: " + updatedThesis.getProfessor());
                    System.out.println("سال انتشار: " + updatedThesis.getYear2());
                    System.out.println("کد: " + updatedThesis.getCode());
                    System.out.println("شماره شناسه: " + updatedThesis.getShenase());*/
                break;
            }
        }
        if (target) {
            System.out.println("success");
        } else {
            System.out.println("not-found");
        }
    }

    public static void removeThesis(String shenase3, String shenase) {
        for (Borrow brw : borrowList) {
            if (brw.getShenase2().equals(shenase3) && brw.getShenase1().equals(shenase)) {
                System.out.println("not-allowed");
                return;
            }
        }
        for (Thesis thesis : thesisList) {
            if (thesis.getShenase3().equals(shenase3) && thesis.getShenase().equals(shenase)) {
                thesisList.remove(thesis);
                System.out.println("success");
                return;
            }
        }
        System.out.println("not-found");
    }

    public static void DecreasethesisCount(String Shenase3, String Shenase) {
        for (Thesis existingThesis : thesisList) {
            if (existingThesis.getShenase3().equals(Shenase3) && existingThesis.getShenase().equals(Shenase)
                    && (!existingThesis.isBorrowed())) {
                existingThesis.setBorrowed(true);
                System.out.println("success");
                return;
            }
        }
        System.out.println("not-allowed");

    }

    public static void IncreasethesisCount(String Shenase3, String Shenase) {
        for (Thesis existingThesis : thesisList) {
            if (existingThesis.getShenase3().equals(Shenase3) && existingThesis.getShenase().equals(Shenase)) {
                existingThesis.setBorrowed(false);
                break;
            }
        }
    }

    public static ArrayList<Thesis> getThesisList() {
        return thesisList;
    }

}