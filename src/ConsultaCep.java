import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public Endereco buscaEndereco(String cep){
        URI link = URI.create("https://viacep.com.br/ws/"+cep+"/json/");


        HttpRequest request = HttpRequest.newBuilder().uri(link).build();


        try {
            HttpResponse<String>   response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException("CEP Invalido!");
        }




    }


}
