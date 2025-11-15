/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.tuempresa.nomina;

/**
 * Empleado asalariado (salario fijo mensual).
 */
public class SalariedEmployee extends Employee {
    private double salarioMensual;

    public SalariedEmployee(String nombre, int añosAntiguedad, double salarioMensual) {
    super(nombre, añosAntiguedad);
    if (salarioMensual < 0) throw new ValidationException("Salario negativo");
    this.salarioMensual = salarioMensual;
}

    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }

    @Override
    public double calcularBeneficios() {
        double bonoAntiguedad = (añosAntiguedad > 5) ? salarioMensual * 0.10 : 0.0;
        double bonoAlimentacion = PayrollConfig.MONTO_BONO_ALIMENTACION; // aplicable a permanentes
        return bonoAntiguedad + bonoAlimentacion;
    }
}