package br.com.labbs.workout.httpclientbattle;

import br.com.labbs.workout.httpclientbattle.shared.HttpClient;
import com.wizzardo.tools.http.Request;
import com.wizzardo.tools.http.Response;

import java.io.IOException;

@SuppressWarnings("unused")
public class Wizzardo implements HttpClient<Request, Response> {

    public static final String WIZZARDO = "Wizzardo";

    @Override
    public String getClientName() {
        return WIZZARDO;
    }

    @Override
    public Request newRequest(String url) {
        return new Request(url);
    }

    @Override
    public void addHeaderToRequest(Request request, String key, String value) {
        request.addHeader(key, value);
    }

    @Override
    public Response execRequest(Request request, int request_number) throws Exception {
        return request.get();
    }

    @Override
    public int getResponseStatusCode(Response response) {
        int responseCode = 500;
        try {
            responseCode = response.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseCode;
    }
}
