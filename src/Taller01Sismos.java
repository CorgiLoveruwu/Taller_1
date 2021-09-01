import java.text.DecimalFormat;
import java.util.Scanner;

public class Taller01Sismos {
    public static void main(String[] args) {
        double[][] sismos= new double[7][10];
        MostrarMenu(sismos);
    }
    public static void MostrarMenu(double[][] arreglo){
        System.out.println("[0] Ingresar datos");
        System.out.println("[1] Mostrar sismos de mayor magnitud");
        System.out.println("[2] Contar sismos mayores o iguales a 5.0");
        System.out.println("[3] Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("[4] Salir");
        OpcionesMenu(arreglo);
    }

    public static void OpcionesMenu(double[][] arreglo) {
        switch (validar(4)){
            case 0:
                GenerarArreglo(arreglo);
                MostrarMenu(arreglo);
                break;
            case 1:
                if (validarsismos(arreglo)){
                    BuscarMayorSismo(arreglo);
                }
                MostrarMenu(arreglo);
                break;
            case 2:
                if (validarsismos(arreglo)){
                    contarSismos(arreglo);
                }
                MostrarMenu(arreglo);
                break;
            case 3:
                if (validarsismos(arreglo)){
                    EnviarSMS(arreglo);
                }
                MostrarMenu(arreglo);
                break;
            case 4:
                Salir(arreglo);

        }
    }

    public static void EnviarSMS(double[][] arreglo) {
        for (int i=0;i<arreglo.length;i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j]>7){
                    System.out.println("Alerta!!! se debe evacuar zona costera!");
                }
            }
        }

    }

    public static void Salir(double[][] arreglo) {
        System.out.println("Desea salir? [1]Si [2]No");
        if (validar(2)==2){
            MostrarMenu(arreglo);
        }
    }

    public static void BuscarMayorSismo(double[][] arreglo) {
        double mayor =0;
        String pattern = "#.#";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        for (int i=0;i<arreglo.length;i++){
            for (int j=0;j<arreglo[i].length;j++){
                if (arreglo[i][j]>mayor){
                    mayor=arreglo[i][j];
                }
            }
        }
        String formattedDouble = decimalFormat.format(mayor);
        System.out.print("["+formattedDouble+"]");
        System.out.println();
    }

    public static void contarSismos(double[][] arreglo) {
        String pattern = "#.#";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        for (int i=0;i<arreglo.length;i++){
            for (int j=0;j<arreglo[i].length;j++){
                if (arreglo[i][j]>5.0){
                    String formattedDouble = decimalFormat.format(arreglo[i][j]);
                    System.out.print("["+formattedDouble+"]");
                    System.out.println();
                }
            }
        }
    }

    public static void GenerarArreglo(double[][] arreglo) {
        String pattern = "#.#";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        for (int i=0;i<arreglo.length;i++){
            for (int j=0;j<arreglo[i].length;j++){
                arreglo[i][j]=(Math.random()*10);
                String formattedDouble = decimalFormat.format(arreglo[i][j]);
                System.out.print("["+formattedDouble+"]");
                System.out.println();
            }
        }
    }

    public static int validar(int x) {
        int n = -1;
        do {
            //Scanner ponerlo dentro del DO, y dentro de una funcion
            Scanner teclado = new Scanner(System.in);
            //System.out.println("ingrese otro numero");
            try {
                n = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Error");
            }
            if (n < 0 || n > x) {
                System.out.println("ingrese un numero valido");
            }
        } while (n < 0 || n > x);
        return n;
    }

    public static boolean validarsismos(double[][] arreglo){
        if (arreglo==null){
            return false;
        }else {
            return true;
        }


    }

}
