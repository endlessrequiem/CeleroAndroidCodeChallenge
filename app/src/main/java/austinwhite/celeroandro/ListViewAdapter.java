package austinwhite.celeroandro;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.squareup.picasso.Picasso;

import java.util.List;

class ListViewAdapter extends BaseAdapter {

    private List<Customer> customers;
    private Context context;
    protected LocationManager locationManager;
    protected LocationListener locationListener;




    @RequiresApi(api = Build.VERSION_CODES.N)
    public ListViewAdapter(Context context, List<Customer> customers){
        this.context = context;
        this.customers = customers;

    }

    @Override
    public int getCount() {
        return customers.size();
    }

    @Override
    public Object getItem(int pos) {
        return customers.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(context).inflate(R.layout.model,viewGroup,false);
        }


        TextView customerName = view.findViewById(R.id.customerName);
        TextView customerIssue = view.findViewById(R.id.customerIssue);
        TextView customerNumber = view.findViewById(R.id.customerNumber);
        TextView customerAddress = view.findViewById(R.id.customerAddress);
        ImageButton GoogleMapButton = view.findViewById(R.id.GoogleMapButton);
        ImageView customerImageView = view.findViewById(R.id.customerImage);

        final Customer thisCustomer = customers.get(position);

        customerName.setText(thisCustomer.getName());
        customerIssue.setText(thisCustomer.getServiceReason());
        customerNumber.setText(thisCustomer.getPhoneNumber());
        customerAddress.setText(String.format("%s\n%s %s\n%s",
                thisCustomer.getLocation().getAddress().getStreet(),
                thisCustomer.getLocation().getAddress().getCity() + ",",
                thisCustomer.getLocation().getAddress().getState(),
                thisCustomer.getLocation().getAddress().getPostalCode())
        );

        if(thisCustomer.getProfilePicture().getLarge() != null && thisCustomer.getProfilePicture().getLarge().length()>0)
        {
            Picasso.get().load(thisCustomer.getProfilePicture().getLarge()).placeholder(R.drawable.ic_launcher_background).into(customerImageView);
        }else {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_SHORT).show();
            Picasso.get().load(R.drawable.ic_launcher_background).into(customerImageView);
        }


        GoogleMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?daddr=" + thisCustomer.getLocation().getCoordinate().getLatitude() + "," + thisCustomer.getLocation().getCoordinate().getLongitude();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, thisCustomer.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}



