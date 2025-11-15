/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.tuempresa.nomina;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Sistema de Nómina - Ejecución de ejemplo ====");
        try {
            SalariedEmployee e1 = new SalariedEmployee("Ana Perez", 6, 3_000_000.0);
            HourlyEmployee e2 = new HourlyEmployee("Carlos Gómez", 2, 20_000.0, 45, true);
            CommissionEmployee e3 = new CommissionEmployee("Laura Ruiz", 3, 1_000_000.0, 25_000_000.0, 0.05);
            TemporaryEmployee e4 = new TemporaryEmployee("Jorge Díaz", 0, 1_200_000.0);

            imprimirResumen(e1);
            imprimirResumen(e2);
            imprimirResumen(e3);
            imprimirResumen(e4);
        } catch (ValidationException ex) {
            System.err.println("Error de validación: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Error inesperado: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void imprimirResumen(Employee e) {
        System.out.println("----------------------------------------");
        System.out.println(e.toString());
        System.out.printf("Salario bruto: %.2f%n", e.calcularSalarioBruto());
        System.out.printf("Beneficios: %.2f%n", e.calcularBeneficios());
        System.out.printf("Deducciones: %.2f%n", e.calcularDeducciones());
        System.out.printf("Salario neto: %.2f%n", e.calcularSalarioNeto());
    }
}