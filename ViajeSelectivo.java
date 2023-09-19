package cochesyviajes;

import java.time.LocalDate;
import java.util.LinkedList;

public class ViajeSelectivo extends Viaje{
    private LinkedList<String> usuariosVetados;
    public ViajeSelectivo(String propietarioVehiculo, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
        super(propietarioVehiculo, coche, ruta, fechaSalida, plazasOfrecidas);
        usuariosVetados = new LinkedList<>();
    }

    public ViajeSelectivo(String propietarioVehiculo, String coche, String ruta, LocalDate fechaSalida) {
        super(propietarioVehiculo, coche, ruta, fechaSalida);
        usuariosVetados = new LinkedList<>();
    }

    public boolean vetarUsuario(String usuario){
        return this.usuariosVetados.add(usuario);
    }

    public boolean permitirUsuario(String usuario){
        return this.usuariosVetados.remove(usuario);
    }

    @Override
    public Reserva realizarReserva(String usuario, int nplazas) {
        if (!usuariosVetados.contains(usuario)){
            return super.realizarReserva(usuario, nplazas);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "propietarioVehiculo='" + super.getPropietarioVehiculo() + '\'' +
                ", coche='" + super.getCoche() + '\'' +
                ", ruta='" + super.getRuta() + '\'' +
                ", fechaSalida=" + super.getFechaSalida() +
                ", plazasOfrecidas=" + super.getPlazasOfrecidas() +
                ", reservas=" + super.getReservas() +
                ", usuariosVetados" + usuariosVetados +
                '}';
    }
}
