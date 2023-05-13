import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        String cep = "";



        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Digite um Cep: ");
            cep = scanner.next();
            if (cep.equalsIgnoreCase("sair")){
                break;
            } else {

                try {
                    Endereco endereco = consultaCep.buscaEndereco(cep);
                    System.out.println(endereco);
                    Arquivador arquivador = new Arquivador();
                    arquivador.GeradorJson(endereco);
                } catch (RuntimeException | IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Encerrando aplicação");
                    break;


                }

            }





        }
    }
}