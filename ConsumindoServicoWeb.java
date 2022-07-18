import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //conexão HTTP (protocolo), acessando o top 250 filmes.
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";       //Criando variável com o nome de url, do tipo string.
        URI endereco = URI.create(url);                                                // Criando a variável do endereco
        HttpClient client = HttpClient.newHttpClient();                                //Após chamar a biblioteca, vamos criar o httpclient depois criar a variável client.
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();          // Pode-se trocar o HttpClient por var, pois o java ja reconhece.
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
            //System.out.println(body);

        // filtrar/parcear os dados que interessam: titíulo, poster (imagem) e a classificação.
        JsonParser parser = new JsonParser();        
        List<Map<String, String>> listadefilmes = parser.parse(body);
            //System.out.println(listadefilmes.size());

        //exibir e manupilar dados.
        for (Map<String, String> filme : listadefilmes){
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
        }
    }
}
