package application;

import model.entidades.Reserva;
import model.excecoes.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Numero do quarto:");
            int numero = sc.nextInt();
            System.out.print("Data de Entrada(dd/mm/yyy):");
            Date dateEntrada = sdf.parse(sc.next());
            System.out.print("Data de Saida(dd/mm/yyy):");
            Date dateSaida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, dateEntrada, dateSaida);
            System.out.println(reserva);

            System.out.println("\n\nColoque a data para atualizar a reserva:");
            System.out.print("Data de Entrada(dd/mm/yyy):");
            Date attEntrada = sdf.parse(sc.next());
            System.out.print("Data de Saida(dd/mm/yyy):");
            Date attSaida = sdf.parse(sc.next());

            reserva.atualizarDatas(attEntrada, attSaida);
            System.out.println(reserva);
        }
        catch (ParseException e){
            System.out.println("Data Invalida");
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Número incorreto");
        }
        catch (RuntimeException e){
            System.out.println("Erro Inesperado");
        }



        sc.close();
    }
}
