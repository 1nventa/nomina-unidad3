/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.tuempresa.nomina;

/**
 * Empleado temporal (salario fijo, sin bonos extras).
 */
public class TemporaryEmployee extends Employee {
    private double salarioMensual;

   public TemporaryEmployee(String nombre, int añosAntiguedad, double salarioMensual) {
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
        return 0.0; // sin bonos adicionales
    }
}