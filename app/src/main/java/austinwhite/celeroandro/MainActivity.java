package austinwhite.celeroandro;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListViewAdapter adapter;
    private ListView mListView;
    ProgressBar myProgressBar;


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void populateListView(List<Customer> customerList) {
        mListView = findViewById(R.id.mListView);
        adapter = new ListViewAdapter(this,customerList);


        mListView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar myProgressBar= findViewById(R.id.myProgressBar);
        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);

        ApiInterface myAPIService = ApiClient.getClient().create(ApiInterface.class);


        Call<ArrayList<Customer>> call = myAPIService.getCustomer();

        call.enqueue(new Callback<ArrayList<Customer>>() {


            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<ArrayList<Customer>> call, Response<ArrayList<Customer>> response) {
                myProgressBar.setVisibility(View.GONE);
                populateListView(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<Customer>> call, Throwable throwable) {
                myProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
