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

            Date now = new Date();
            if(attEntrada.before(now) || attSaida.before(now)){
                System.out.println("Erro na reserva: Datas de atualização tem que ser datas futuras");
            }else if(!attSaida.after(attEntrada)){
                System.out.println("Erro na reserva: Data de saida tem que ser depois da data de entrada.");
            }else{
                reserva.atualizarDatas(attEntrada,attSaida);
                System.out.println(reserva);
            }


        }







        sc.close();
    }
}
