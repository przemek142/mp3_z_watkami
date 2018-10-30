import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        System.out.println("hello");

        InputStream inputStream = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 czy 2\n");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("1");
                inputStream = new FileInputStream("src/main/resources/muza.mp3");
                javazoom.jl.player.Player player = new Player(inputStream);

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            player.play();

                        } catch (JavaLayerException e) {

                        }
                    }
                };
                Thread thread = new Thread(runnable);

                thread.start();

                scanner.nextLine();
                if (scanner.nextInt() == 0) {
                    player.close();
                }
                break;
            case 2:
                System.out.println("2 - no file");
        }


    }
}
