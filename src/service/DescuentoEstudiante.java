package service;

/** Aplica el beneficio asignado a estudiantes. */
public class DescuentoEstudiante implements IDescuentoStrategy {

    private static final double PORCENTAJE = 0.10;

    @Override
    public double aplicar(double monto) {
        return monto * PORCENTAJE;
    }
}
