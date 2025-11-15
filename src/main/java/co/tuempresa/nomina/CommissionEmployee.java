/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.tuempresa.nomina;

/**
 * Empleado con salario base + comisión sobre ventas.
 */
public class CommissionEmployee extends Employee {
    private double salarioBase;
    private double ventas;
    private double porcentajeComision; // ejemplo 0.05 = 5%

    public CommissionEmployee(String nombre, int añosAntiguedad, double salarioBase, double ventas, double porcentajeComision) {
    super(nombre, añosAntiguedad);
    if (salarioBase < 0) throw new ValidationException("Salario base negativo");
    if (ventas < 0) throw new ValidationException("Ventas negativas");
    if (porcentajeComision < 0) throw new ValidationException("Porcentaje comisión negativo");

    this.salarioBase = salarioBase;
    this.ventas = ventas;
    this.porcentajeComision = porcentajeComision;
}

    @Override
    public double calcularSalarioBruto() {
        return salarioBase + ventas * porcentajeComision;
    }

    @Override
    public double calcularBeneficios() {
        double bonoVentas = (ventas > 20_000_000.0) ? ventas * 0.03 : 0.0; // 3% bono si ventas > 20M
        double bonoAlimentacion = PayrollConfig.MONTO_BONO_ALIMENTACION;
        return bonoVentas + bonoAlimentacion;
    }
}