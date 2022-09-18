package view;
import java.util.Scanner;

public class View {
    private Scanner console;

    public View() {
        console = new Scanner(System.in);
    }

    public void showMessage(String message){
        System.out.println(message);
    }

    public int readInt(String message){
        System.out.println(message);
        return Integer.parseInt(console.nextLine());
    }

    public String readString(String message) {
        System.out.println(message);
        return console.nextLine();
    }

    public double readDouble(String message){
        System.out.println(message);
        return Double.parseDouble(console.nextLine());
    }
}