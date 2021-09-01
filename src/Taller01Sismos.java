import java.util.Scanner;

public class Taller01Sismos {
    public static void main(String[] args) {

    }
    public static void MostrarMenu(){
        double[][] sismos= new double[7][10];
        System.out.println("[0] Ingresar datos");
        System.out.println("[1] Mostrar sismos de mayor magnitud");
        System.out.println("[2] Contar sismos mayores o iguales a 5.0");
        System.out.println("[3] Enviar SMS por vasa sismo mayor o igual a 7.0");
        System.out.println("[4] Salir");
        OpcionesMenu(sismos);

        }


    public static void OpcionesMenu(double[][] arreglo) {
        switch (validar(4)){
            case 0:
                GenerarArreglo(arreglo);
                break;
            case 1:
                break;
            case 2:
                contarSismos(arreglo);
                break;
            case 3:
                break;
            case 4:

        }
    }

    private static void contarSismos(double[][] arreglo) {
        for (int i=0;i<arreglo.length;i++){
            for (int j=0;j<arreglo[i].length;j++){
                if (arreglo[i][j]<5.0){
                    
                }
            }
        }
    }

    private static void GenerarArreglo(double[][] arreglo) {
        for (int i=0;i<arreglo.length;i++){
            for (int j=0;j<arreglo[i].length;j++){
                arreglo[i][j]=Math.random()*10;
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
    public static int validarint() {
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
            if (n < 0 ) {
                System.out.println("ingrese un numero valido");
            }
        } while (n < 0 );
        return n;
    }

}
