import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class SistemaDeSoporte{
    private SolicitudSoporte[] cola;
    private int front;
    private int rear;
    private int size;
    private Scanner teclado;
    private final int capacidadVector=5;

    public SistemaDeSoporte(Scanner teclado){
        this.cola=  new SolicitudSoporte[capacidadVector];
        this.front=0;
        this.rear=0;
        this.size=0;
        this.teclado=teclado;
    }

    private boolean estaLlena()
    {
        return size==capacidadVector;
    }

    private boolean estaVacia()
    {
        return size==0;
    }
    public void VerificarEstadoCola()
    {
        System.out.println("////**ESTADO DE LA COLA**\\\\") ;
        System.out.println("Solicitudes pendientes: " + size ) ;  
        System.out.println("Capacidad máxima: "+ capacidadVector) ;    
        System.out.println("Espacios disponibles: "+ (capacidadVector-size)) ;    
    }    
    public void RegistrarSolicitud(){     
         if(estaLlena()){
             System.out.println("Por el momento no es posible ingresar una solicitud, intentelo mas tarde") ;    
             return;
         }
        
         System.out.println("////**REGISTRO DE SOLICITUD**\\\\") ;
         System.out.println("   Ingrese los siguientes datos  ") ;
         System.out.print("   Nombre: ") ;
         String nombre= teclado.nextLine();
         System.out.print("   Contacto: ") ;
         String contacto= teclado.nextLine();
         System.out.print("   Referencia de la maquina: ") ;
         String referencia= teclado.nextLine();
         System.out.print("   Descripcion: ") ;
         String descripcion= teclado.nextLine();
         System.out.print("   Fecha solicitud (dd/MM/yyyy HH:mm): ") ;
         String fecha= teclado.nextLine();
         System.out.print("   Tipo Soporte (virtual/presencial): ") ;
         String tipoSoporte= teclado.nextLine();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        SolicitudSoporte info= new SolicitudSoporte(nombre,contacto,referencia,descripcion, LocalDateTime.parse(fecha,formato),tipoSoporte);
        cola[rear]   =info;
        size++;
        rear = rear==capacidadVector-1?0:rear+1;
        System.out.println("===**SOLICITUD REGISTRADA EXITOSAMENTE**===") ;
    }

    public void AtenderSolicitud(){
         if(estaVacia()){
             System.out.println("No hay solicitudes para atender") ; 
             return;
         }
         SolicitudSoporte solicitud = cola[front];
         System.out.println("////**Informacion Solicitud**\\\\") ;
         ImprimirInfo(solicitud);
        cola[front]=null; 
        front = front==capacidadVector-1 ? 0: front+1;
        size-=1;
        System.out.println("===**SOLICITUD ATENTIDA EXITOSAMENTE**===") ;
    }

    public void ConsultarProximaSolcitud(){
         if(estaVacia()){
              System.out.println("No hay solicitudes") ;   
             return;
         }
         SolicitudSoporte solicitud = cola[front];
         System.out.println("////**Informacion Solicitud**\\\\") ;
         ImprimirInfo(solicitud);
    }

    public void MostrarSolicitudesPendientes(){
        System.out.println("////**SOLICITUDES PENDIENTES**\\\\") ;
        int contador=1;
        int posicionElementos=front;
        while(contador<=size){
            SolicitudSoporte solicitud = cola[posicionElementos];
            if(solicitud!=null){
               ImprimirInfo(solicitud);
            }
            contador++;
            posicionElementos= posicionElementos==capacidadVector-1?0:  posicionElementos+1;  
        }
    }

    private void ImprimirInfo(SolicitudSoporte solicitud){
           System.out.println("    * ID: " + solicitud.getId()) ;
           System.out.println("    * Nombre Cliente: " + solicitud.getNombreCliente()) ;
           System.out.println("    * Contacto: "+ solicitud.getContacto()) ;
           System.out.println("    * Referencia Maquina: "+ solicitud.getReferenciaMaquina()) ;
           System.out.println("    * Descripcion: " + solicitud.getDescripcion()) ;
           System.out.println("    * Fecha solicitud: " + solicitud.getFechaSolicitud()) ;
           System.out.println("    * Tipo Soporte: " + solicitud.getTipoSoporte()) ;
    }
}
