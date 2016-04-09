/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author notte
 */
public class MusicPlayer {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            menu();

            int menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 0:
                    System.exit(0);
                    break;
                case 1: {
                    System.out.print("Ten bai hat: ");
                    String name = sc.nextLine();
                    try {
                        FileOutputStream fos = new FileOutputStream("list.txt",true);
                        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
                        Writer writer = new BufferedWriter(osw);
                        writer.write(name.toString());
                        System.out.println("Ghi thanh cong bang FileOutputStream");
                        writer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                }
                default: {
                    System.out.println("Ban chon sai roi!");
                    break;
                }
            }
            try {
                FileInputStream fis = new FileInputStream("music/song.mp3");
                Player playMP3 = new Player(fis);
                playMP3.play();
            } catch (FileNotFoundException | JavaLayerException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        }
    }

    private static void menu() {
        System.out.println("----Media Player----");
        System.out.println("1. Add 1 media");
        System.out.println("2. Display playlist");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    private static void display() {
        System.out.println("----Playlist----");
        System.out.println("No.\tName");
        //TODO code here
        System.out.print("Choose to play: ");
    }

    private static void player() {
        System.out.println("Playing: ????");
        System.out.println("P. Play/Pause");
        System.out.println("S. Stop");
        System.out.println("0. Back to menu");
    }

}

class Song {

    private String name;

    public Song() {
    }

    public Song(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\r\n";
    }
}
