/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.tuempresa.nomina;

/**
 * Empleado por horas.
 */
public class HourlyEmployee extends Employee {
    private double tarifaPorHora;
    private double horasTrabajadas;
    private boolean aceptaFondoAhorro; // si el empleado acepta fondo de ahorro 2%

   public HourlyEmployee(String nombre, int añosAntiguedad, double tarifaPorHora, double horasTrabajadas, boolean aceptaFondoAhorro) {
    super(nombre, añosAntiguedad);
    if (tarifaPorHora < 0) throw new ValidationException("Tarifa por hora negativa");
    if (horasTrabajadas < 0) throw new ValidationException("Horas trabajadas negativas");

    this.tarifaPorHora = tarifaPorHora;
    this.horasTrabajadas = horasTrabajadas;
    this.aceptaFondoAhorro = aceptaFondoAhorro;
}

    @Override
    public double calcularSalarioBruto() {
        double bruto;
        if (horasTrabajadas <= 40) {
            bruto = horasTrabajadas * tarifaPorHora;
        } else {
            double extra = horasTrabajadas - 40;
            bruto = 40 * tarifaPorHora + extra * tarifaPorHora * 1.5;
        }
        return bruto;
    }

    @Override
    public double calcularBeneficios() {
        double fondo = 0.0;
        if (añosAntiguedad >= 1 && aceptaFondoAhorro) {
            fondo = calcularSalarioBruto() * 0.02; // 2% si acepta y tiene >1 año
        }
        return fondo;
    }

    @Override
    public double calcularDeducciones() {
        double ded = super.calcularDeducciones();
        // si aplica fondo de ahorro, lo consideramos deducción (ya lo agregamos en beneficios como aporte del empleado, pero para simplificar sumamos aquí)
        if (añosAntiguedad >= 1 && aceptaFondoAhorro) {
            ded += calcularSalarioBruto() * 0.02; // resta adicional (si se desea)
        }
        return ded;
    }
}