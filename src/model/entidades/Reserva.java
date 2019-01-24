package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private int numeroQuarto;
    private Date dataEntrada;
    private Date dataSaida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reserva(int numeroQuarto, Date dataEntrada, Date dataSaida) {
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public long duracao(){
        long dif = dataSaida.getTime() - dataEntrada.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public String atualizarDatas(Date entrada, Date saida){
        Date now = new Date();
        if(entrada.before(now) || saida.before(now)){
            return "Erro na reserva: Datas de atualização tem que ser datas futuras";
        }
        if(!saida.after(entrada)) {
            return "Erro na reserva: Data de saida tem que ser depois da data de entrada.";
        }

        this.dataEntrada = entrada;
        this.dataSaida = saida;

        return null;
    }

    @Override
    public String toString() {

        return "Reserva " +
                "numeroQuarto:" + numeroQuarto +
                ", dataEntrada:" + sdf.format(dataEntrada) +
                ", dataSaida:" + sdf.format(dataSaida) +
                ", "+ duracao() + "dias }";
    }
}
