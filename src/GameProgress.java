import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;


    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;

    }


    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String saveWay) throws IOException {
        StringBuilder sb = new StringBuilder(saveWay.toString()).delete(saveWay.toString().length() - 10, saveWay.toString().length());

        File dir =new File(sb.toString());
        dir.mkdirs();
        File dir2 =new File(saveWay);
        dir2.createNewFile();

        try (FileOutputStream fos = new FileOutputStream(saveWay)) {

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(oos);
            byte[] bytes = fos.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        zipFiles(saveWay);
        delete(saveWay);
    }

    private void delete(String saveWay) {
        File file=new File(saveWay);
        file.delete();
    }

    public void zipFiles(String dir) {
        StringBuilder sb = new StringBuilder(dir).delete(dir.length() - 4, dir.length());
        sb.append("_zip.zip");
        try ( ZipOutputStream zous = new ZipOutputStream(new FileOutputStream(sb.toString()));
              FileInputStream fis = new FileInputStream(dir)){
            ZipEntry zipEntry = new ZipEntry(dir);
            zous.putNextEntry(zipEntry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zous.write(buffer);
            zous.closeEntry();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}