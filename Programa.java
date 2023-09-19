package cochesyviajes;

import java.time.LocalDate;
import java.util.LinkedList;

public class Programa {
    public static void main(String[] args) {
        Viaje viaje1 = new Viaje("Jose Antonio","Seat Leon","Murcia-Cartagena", LocalDate.of(2023,10,5));
        ViajeSelectivo viaje2 = new ViajeSelectivo("Jose Antonio","Seat Leon","Murcia-Campus",LocalDate.of(2023,9,20),4);
        viaje2.vetarUsuario("Beatriz");
        ViajePremium viaje3 = new ViajePremium("Jose Antonio","Seat Leon","Murcia-Barcelona",LocalDate.of(2023,9,19),6);
        System.out.println(viaje1.realizarReserva("Alberto",2));
        System.out.println(viaje2.realizarReserva("Enrique",3));
        System.out.println(viaje2.realizarReserva("Beatriz",1));
        Reserva reserva = viaje3.realizarReserva("Ana",2);
        System.out.println(reserva);
        viaje3.cancelarReserva(reserva.getCodigoReserva());
        LinkedList<Viaje> viajes = new LinkedList<>();
        viajes.add(viaje1);
        viajes.add(viaje2);
        viajes.add(viaje3);
        for (Viaje viaje:viajes) {
            if (viaje instanceof ViajeSelectivo){
                ((ViajeSelectivo) viaje).permitirUsuario("Beatriz");
            }
            System.out.println(viaje);
        }
    }
}
