package arbol;

import java.io.*;

public class Arbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{

        String Conductor = "";
        int horas = 0;
        String placa = "";
        int op = 0, orden = 0;
        boolean V = true;
        String eliminar;
        BufferedReader re;
        re = new BufferedReader(new InputStreamReader(System.in));
        Carro p;
        ArbolBin n = new ArbolBin();
        while (V) {
            try {
                System.out.println("1. Ingrese datos del vehiculo:");
                System.out.println("2. Mostrar vehiculos en InOrden");
                System.out.println("3. Mostrar vehiculos en PreOrden");
                System.out.println("4. Mostrar vehiculos en PostOrden");
                System.out.println("5. Mostrar vehiculo");
                System.out.println("6. eliminar dato menor");
                System.out.println("7. eliminar dato mayor");
                System.out.println("8. eliminar dato por placa");
                System.out.println("9. valor por pagar");
                System.out.println("10. salir");
                op = Integer.parseInt(re.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("ERROR" + e);
            }
            switch (op) {

                case 1:
                try {
                    System.out.println("Placa");
                    placa = re.readLine();
                } catch (IOException e) {
                    System.out.println("ERROR" + e);

                }

                try {
                    System.out.println("Horas");
                    horas = Integer.parseInt(re.readLine());
                    System.out.println("Conductor");
                } catch (IOException | NumberFormatException e) {
                    System.out.println("ERROR" + e);
                }
                Conductor = re.readLine();
                p = new Carro( Conductor,horas, placa);

                n.Insertarnombre(p);

                break;

                case 2:
                    n.InOrden(n.raiz);
                    break;

                case 3:
                    n.PreOrden(n.raiz);
                    break;

                case 4:
                    n.PostOrden(n.raiz);
                    break;

                case 5:
                    n.hermanos(n.raiz);

                    break;

                case 6:
                    n.borrarMenor();
                    break;

                case 7:
                    n.borrarMayor();
                    break;

                case 8:
                    System.out.println("INGRSE LA PLACA QUE DESEA ELIMINAR");
                    eliminar = re.readLine();
                    p = new Carro(eliminar, op, op);
                    n.Eliminar(p);
                    break;
                case 9:
                    System.out.println("ingrese Horas:\n");
                    horas = Integer.parseInt(re.readLine());
                    horas = horas * 2000;
                    System.out.println("el valor a pagar es de:\n" + horas);
                    break;

                default:
                    V = false;
                    break;

            }
        }
    }

}
    

   
    

