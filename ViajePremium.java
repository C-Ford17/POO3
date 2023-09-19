package cochesyviajes;

import java.time.LocalDate;

public class ViajePremium extends Viaje{

    public ViajePremium(String propietarioVehiculo, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
        super(propietarioVehiculo, coche, ruta, fechaSalida, plazasOfrecidas);
    }

    public ViajePremium(String propietarioVehiculo, String coche, String ruta, LocalDate fechaSalida) {
        super(propietarioVehiculo, coche, ruta, fechaSalida);
    }

    public boolean cancelarReserva(String codigo){
        Reserva reserva = consultarReserva(codigo);
        if (LocalDate.now().isBefore(getFechaSalida())){
            getReservas().remove(reserva);
            return true;
        }
        return false;
    }
}
