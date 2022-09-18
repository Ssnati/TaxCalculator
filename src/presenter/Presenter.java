package presenter;

import java.io.FileNotFoundException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.io.IOException;

import view.*;
import model.*;

public class Presenter {

    private View view;
    private TaxCalculator taxCalculator;
    private ResourceBundle bundle;

    public Presenter() {
        view = new View();
        try {
            taxCalculator = new TaxCalculator();
        } catch (IOException e) {
            view.showMessage("IO Exception");
            view.showMessage(bundle.getString("fin"));
        }
        bundle = PropertyResourceBundle.getBundle("resources/labels_es");
    }

    public void makeChangesMenu() throws IOException {
        int option = 0;
        while (option != 4) {
            switch (view.readInt(bundle.getString("menuCambios"))) {
                case 1:
                    modifyRanksMenu();
                    break;
                case 2:
                    taxCalculator.modifyRank("rank1", "1.5");
                    taxCalculator.modifyRank("rank2", "2.0");
                    taxCalculator.modifyRank("rank3", "2.5");
                    taxCalculator.modifyRank("payment", "10");
                    taxCalculator.modifyRank("public", "50000");
                    taxCalculator.modifyRank("boyaca", "20");
                    taxCalculator.modifyRank("minim", "30000000");
                    taxCalculator.modifyRank("maxim", "70000000");
                    break;
                case 3:
                    addAttributes();
                    break;
                case 4:
                    option = 4;
                    break;
            }
        }
    }

    public void run() {
        try {
            mainMenu();
        } catch (FileNotFoundException e) {
            view.showMessage("File Exception");
        } catch (IOException e) {
            view.showMessage("IO Exception");
        } finally {
            view.showMessage(bundle.getString("fin"));
        }
    }

    public void mainMenu() throws IOException {
        int option = 0;
        do {
            switch (view.readInt(bundle.getString("menuPrincipal"))) {
                case 1:
                    makeChangesMenu();
                    break;
                case 2:
                    calculateValue();
                    break;
                case 3:
                    changeId();
                    break;
                case 4:
                    option = 4;
                    end();
                    break;
            }
        } while (option != 4);
    }

    private void modifyRanksMenu() throws IOException {
        String message = bundle.getString("nuevoValor");
        int option = 0;
        while (option != 9) {
            switch (view.readInt(bundle.getString("menuCambios2"))) {
                case 1:
                    taxCalculator.modifyRank("rank1", view.readString(message));
                    break;
                case 2:
                    taxCalculator.modifyRank("rank2", view.readString(message));
                    break;
                case 3:
                    taxCalculator.modifyRank("rank3", view.readString(message));
                    break;
                case 4:
                    taxCalculator.modifyRank("payment", view.readString(message));
                    break;
                case 5:
                    taxCalculator.modifyRank("public", view.readString(message));
                    break;
                case 6:
                    taxCalculator.modifyRank("boyaca", view.readString(message));
                    break;
                case 7:
                    taxCalculator.modifyRank("minim", view.readString(message));
                    break;
                case 8:
                    taxCalculator.modifyRank("maxim", view.readString(message));
                    break;
                case 9:
                    option = 9;
                    break;
            }
        }
    }

    private void changeId() throws IOException {
        int option = 0;
        while (option != 2) {
            switch (view.readInt(bundle.getString("menuIdiomas"))) {
                case 1:
                    bundle = PropertyResourceBundle.getBundle("resources/labels_es");
                    mainMenu();
                    break;
                case 2:
                    bundle = PropertyResourceBundle.getBundle("resources/labels_en");
                    mainMenu();
                    break;
                case 3:
                    bundle = PropertyResourceBundle.getBundle("resources/labels_it");
                    mainMenu();
                    break;

            }
        }
    }

    private void calculateValue() {
        String mark = view.readString(bundle.getString("smarca") + taxCalculator.getMarkList());
        String line = view.readString(bundle.getString("slinea") + taxCalculator.searchMark(mark).getLineList());
        int model = view.readInt(bundle.getString("smodelo") + taxCalculator.searchMark(mark).searchLine(line).getModelList());
        double message = taxCalculator.calculateTotalValue(mark, model, line,
                view.readInt(bundle.getString("primerDescuento")),
                view.readInt(bundle.getString("tercerDescuento")));
        view.showMessage(bundle.getString("resultado") + message);
    }

    private void end() {
        view.showMessage(bundle.getString("fin"));
        System.exit(0);
    }

    private void addAttributes() {
        int option = 0;
        while (option != 4) {
            switch (view.readInt(bundle.getString("menuAgregar"))) {
                case 1:
                    taxCalculator.addMark(new Mark(bundle.getString("admarca")));
                    break;
                case 2:
                    taxCalculator.searchMark(view.readString(bundle.getString("adlmarca"))).addLine(new Line(view.readString(bundle.getString("adlinea"))));
                    break;
                case 3:
                    taxCalculator.searchMark(view.readString(bundle.getString("admmarca"))).searchLine(view.readString(bundle.getString("admlinea"))).addModel(new Model(view.readInt(bundle.getString("admodelo")), view.readInt(bundle.getString("adprecio")), 0));
                    break;
                case 4:
                    option = 4;
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Presenter().run();
    }
}
