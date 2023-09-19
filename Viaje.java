package cochesyviajes;

import java.time.LocalDate;
import java.util.LinkedList;

public class Viaje {
    private final String propietarioVehiculo;
    private final  String coche;
    private final String ruta;
    private final LocalDate fechaSalida;
    private final int plazasOfrecidas;
    private LinkedList<Reserva> reservas;

    public Viaje(String propietarioVehiculo, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
        this.propietarioVehiculo = propietarioVehiculo;
        this.coche = coche;
        this.ruta = ruta;
        this.fechaSalida = fechaSalida;
        this.plazasOfrecidas = plazasOfrecidas;
        this.reservas = new LinkedList<>();
    }

    public String getPropietarioVehiculo() {
        return propietarioVehiculo;
    }

    public String getCoche() {
        return coche;
    }

    public String getRuta() {
        return ruta;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public int getPlazasOfrecidas() {
        return plazasOfrecidas;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public Viaje(String propietarioVehiculo, String coche, String ruta, LocalDate fechaSalida) {
        this(propietarioVehiculo,coche,ruta,fechaSalida,1);
    }

    public int plazasReservadas(){
        int plazas = 0;
        if (!this.reservas.isEmpty()) {
            for (Reserva reserva : this.reservas) {
                plazas += reserva.getNplazas();
            }
        }
        return plazas;
    }

    public int plazasDisponibles(){
        return this.plazasOfrecidas - plazasReservadas();
    }

    public Reserva realizarReserva(String usuario, int nplazas){
        if (plazasDisponibles() > 0 && LocalDate.now().isBefore(this.fechaSalida)){
            Reserva reserva = new Reserva(usuario,nplazas);
            this.reservas.add(reserva);
            return reserva;
        }
        return null;
    }

    public Reserva consultarReserva(String codigo){
        for (Reserva reserva:this.reservas) {
            if (reserva.getCodigoReserva().equals(codigo)){
                return reserva;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "propietarioVehiculo='" + propietarioVehiculo + '\'' +
                ", coche='" + coche + '\'' +
                ", ruta='" + ruta + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", plazasOfrecidas=" + plazasOfrecidas +
                ", reservas=" + reservas +
                '}';
    }
}
