package austinwhite.celeroandro;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

    public interface ApiInterface {

        @GET("https://hulet.tech/celerocustomers.json")
        Call<ArrayList<Customer>> getCustomer();

    }

