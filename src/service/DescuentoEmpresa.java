package service;

/** Aplica el descuento comercial para clientes empresariales. */
public class DescuentoEmpresa implements IDescuentoStrategy {

    private static final double PORCENTAJE = 0.15;

    @Override
    public double aplicar(double monto) {
        return monto * PORCENTAJE;
    }
}
