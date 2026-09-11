import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado= new  Scanner(System.in);
        int opcion=0;
        SistemaDeSoporte sistema = new SistemaDeSoporte(teclado);
        do{
            
             System.out.println("////**BIENVENIDO SISTEMA DE SOPORTE**\\\\") ;
             System.out.println("           Menu de acciones              ") ;
             System.out.println("       1. Registrar solicitud            ") ;
             System.out.println("       2. Atender solicitud              ") ;
             System.out.println("       3. Consultar proxima solicitud    ") ;
             System.out.println("       4. Mostrar solicitudes pendientes ") ;
             System.out.println("       5. Verificar estado de la cola    ") ;
             System.out.println("       6. Salir                          ") ;
             opcion= teclado.nextInt();
             teclado.nextLine();  
             switch(opcion){
                 case 1: 
                     sistema.RegistrarSolicitud();
                     break;
                 case 2: 
                     sistema.AtenderSolicitud();
                     break;
                 case 3: 
                     sistema.ConsultarProximaSolcitud();
                     break;
                 case 4: 
                     sistema.MostrarSolicitudesPendientes();
                     break;
                 case 5: 
                     sistema.VerificarEstadoCola();
                     break;
                 default: 
                      System.out.println("****OPCION NO VALIDA****") ;
                     break;
             }
            
        }while(opcion!=6);
        teclado.close();
    }
}
