package service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DescuentoFactory {

    private static final Map<String, IDescuentoStrategy> ESTRATEGIAS = new HashMap<>();

    static {
        registrar("VIP", new DescuentoVIP());
        registrar("NORMAL", new DescuentoNormal());
        registrar("EMPRESA", new DescuentoEmpresa());
        registrar("ESTUDIANTE", new DescuentoEstudiante());
    }

    private DescuentoFactory() {
        // Clase de utilidad: no debe instanciarse.
    }

    public static IDescuentoStrategy obtenerEstrategia(String tipoCliente) {
        if (tipoCliente == null) {
            return new DescuentoSinDescuento();
        }

        return ESTRATEGIAS.getOrDefault(tipoCliente.toUpperCase(Locale.ROOT), new DescuentoSinDescuento());
    }

    /** Permite incorporar una estrategia nueva sin cambiar el servicio de descuentos. */
    public static void registrar(String tipoCliente, IDescuentoStrategy estrategia) {
        if (tipoCliente == null || estrategia == null) {
            throw new IllegalArgumentException("El tipo de cliente y la estrategia son obligatorios");
        }
        ESTRATEGIAS.put(tipoCliente.toUpperCase(Locale.ROOT), estrategia);
    }
}
