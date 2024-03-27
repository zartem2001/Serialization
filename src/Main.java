import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameProgress gameProgress1 = new GameProgress(130, 4, 9, 3000);
        GameProgress gameProgress2 = new GameProgress(100, 2, 7, 1800);
        GameProgress gameProgress3 = new GameProgress(112, 2, 6, 2000);
        File dirSaves1 = new File("D://Users/Games/savegames/hero1/save1.dat");
        File dirSaves2 = new File("D://Users/Games/savegames/hero2/save1.dat");
        File dirSaves3 = new File("D://Users/Games/savegames/hero3/save1.dat");
        gameProgress1.saveGame(dirSaves1.toString());
        gameProgress2.saveGame(dirSaves2.toString());
        gameProgress3.saveGame(dirSaves3.toString());

    }
}