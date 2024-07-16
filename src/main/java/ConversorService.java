import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {

    public void conversor(int option, Double amount) throws IOException, InterruptedException {
        String baseCode = "";
        String targetCode = "";
        System.out.print("Su selección es: ");

        switch (option){
            case 1:
                baseCode = "COP";
                targetCode = "USD";
                System.out.println("Conversion de Pesos colombianos a doláres americanos =");
                break;
            case 2:
                baseCode = "USD";
                targetCode = "COP";
                System.out.println("Conversion de doláres americanos a pesos colombianos =");
                break;
            case 3:
                baseCode = "COP";
                targetCode = "MXN";
                System.out.println("Conversion de Pesos colombianos a pesos mexicanos =");
                break;
            case 4:
                baseCode = "MXN";
                targetCode = "COP";
                System.out.println("Conversion de pesos mexicanos a pesos colombianos =");
                break;
            case 5:
                baseCode = "COP";
                targetCode = "EUR";
                System.out.println("Conversion de Pesos colombianos a euros =");
                break;
            case 6:
                baseCode = "EUR";
                targetCode = "COP";
                System.out.println("Conversion de euros a pesos colombianos =");
                break;
            case 9:
                System.out.println("Gracias por utilizar el conversor de monedas Challenge");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        final String API_KEY = System.getenv("API_KEY_CHALLENGE_1_ONE");
        //System.out.println("API KEY= " + API_KEY);

        final String url = "https://v6.exchangerate-api.com/v6/"+ API_KEY +"/pair/" + baseCode + "/" + targetCode + "/" + amount;
        //System.out.println(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);
        var gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        ValorConvertido conversionApi = gson.fromJson(json, ValorConvertido.class);
        final String result = conversionApi.conversion_result();
        System.out.println(result);

        System.out.println("El valor de " + amount + " " + baseCode + " corresponde al valor de " + result + " " + targetCode);
        System.out.println("Gracias por usar el conversor Challenge");

    }


}
