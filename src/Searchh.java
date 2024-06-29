import java.util.ArrayList;
import java.util.Collections;

public class Searchh {
    private static Search search;
    private static ArrayList<Search> searchList = new ArrayList<>();
    private static ArrayList<BookData> bookDataList = BooksData.getBookDataList();
    private static ArrayList<Thesis> thesisList = Theses.getThesisList();

    public static void Searching(String something) {
        search = new Search(something);
        ArrayList<String> myArrayList = new ArrayList<>();
        boolean isDuplicate = false;
        boolean isFirstMatch = true;

        for (BookData existingBookData : bookDataList) {
            if (existingBookData.getOnvan().toLowerCase().contains(something.toLowerCase()) ||
                    existingBookData.getCreator().toLowerCase().contains(something.toLowerCase()) ||
                    existingBookData.getPub().toLowerCase().contains(something.toLowerCase())) {
                isDuplicate = true;
                myArrayList.add(existingBookData.getBcode());
            }
        }

        for (Thesis existingThesis : thesisList) {
            if (existingThesis.getOnvan().toLowerCase().contains(something.toLowerCase()) ||
                    existingThesis.getCreatorName().toLowerCase().contains(something.toLowerCase()) ||
                    existingThesis.getProfessor().toLowerCase().contains(something.toLowerCase())) {
                isDuplicate = true;
                myArrayList.add(existingThesis.getShenase3());
            }
        }

        if (!isDuplicate) {
            System.out.print("not-found");
        }
        else {
            Collections.sort(myArrayList);
            for (String codes : myArrayList){

                if (!isFirstMatch){
                    System.out.print("|");
                }
                else {
                    isFirstMatch = false;
                }
                System.out.print(codes);
            }
        }
    }
}