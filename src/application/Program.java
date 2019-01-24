package application;

import model.entidades.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto:");
        int numero = sc.nextInt();
        System.out.print("Data de Entrada(dd/mm/yyy):");
        Date dateEntrada = sdf.parse(sc.next());
        System.out.print("Data de Saida(dd/mm/yyy):");
        Date dateSaida = sdf.parse(sc.next());

        if(!dateSaida.after(dateEntrada)){
            System.out.println("Erro na reserva: Data de saida tem que ser depois da data de entrada.");
        }else{
            Reserva reserva = new Reserva(numero,dateEntrada,dateSaida);
            System.out.println(reserva);

            System.out.println("\n\nColoque a data para atualizar a reserva:");
            System.out.print("Data de Entrada(dd/mm/yyy):");
            Date attEntrada = sdf.parse(sc.next());
            System.out.print("Data de Saida(dd/mm/yyy):");
            Date attSaida = sdf.parse(sc.next());

            String error = reserva.atualizarDatas(attEntrada,attSaida);
            if(error != null){
                System.out.println(error);
            }else{
                System.out.println(reserva);
            }

        }

        sc.close();
    }
}
