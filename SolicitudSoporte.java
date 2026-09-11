import java.time.LocalDateTime;
public class SolicitudSoporte{
    private static int contador =1;
    private String id;  
    private String nombreCliente;
    private String contacto;
    private String referenciaMaquina;
    private String descripcion;
    private LocalDateTime fechaSolicitud;
    private String tipoSoporte;

    public  SolicitudSoporte(String nombreCliente, String contacto,
        String referenciaMaquina, String descripcion,LocalDateTime fechaSolicitud, String tipoSoporte){
        this.id=generarCodigo();
        this.nombreCliente=nombreCliente;
        this.contacto=contacto;
        this.referenciaMaquina=referenciaMaquina;
        this.descripcion=descripcion;
        this.fechaSolicitud=fechaSolicitud;
        this.tipoSoporte=tipoSoporte;
    }

    private String generarCodigo(){
        String codigo="S";
         if (contador < 10) {
            codigo += "00";
        } else if (contador < 100) {
            codigo += "0";
        }
        codigo+=contador;
        contador ++;
        return codigo;
    }

    public String getId(){
        return this.id;
    }
    
    public String getNombreCliente(){
        return this.nombreCliente;
    }
    
    public String getContacto(){
        return this.contacto;
    }
    
    public String getReferenciaMaquina(){
        return this.referenciaMaquina;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    public LocalDateTime getFechaSolicitud(){
        return this.fechaSolicitud;
    }
    public String getTipoSoporte(){
        return this.tipoSoporte;
    }
}
