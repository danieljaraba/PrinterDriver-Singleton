package model;

public class PrinterDriver {

    private PrinterDriver(){}

    private static PrinterDriver instance;

    public static PrinterDriver getInstance(){
        if (instance==null){
            instance = new PrinterDriver();
            System.out.println("Se inicializó el driver de impresora");
        }
        return instance;
    }

    public void printFile(String file){
        System.out.println("Imprimiendo archivo: "+file);
    }

}
