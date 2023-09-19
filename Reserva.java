package cochesyviajes;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva {
    private final String codigoReserva;
    private final String usuario;
    private final int nplazas;
    private final LocalDate fechaReserva;

    public Reserva(String usuario, int nplazas) {
        this.codigoReserva = UUID.randomUUID().toString();
        this.usuario = usuario;
        this.nplazas = nplazas;
        this.fechaReserva = LocalDate.now();
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getNplazas() {
        return nplazas;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", usuario='" + usuario + '\'' +
                ", nplazas=" + nplazas +
                ", fechaReserva=" + fechaReserva +
                '}';
    }
}
