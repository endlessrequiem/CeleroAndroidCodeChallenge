package austinwhite.celeroandro;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

import austinwhite.celeroandro.Database.DatabaseHelper;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

class ListViewAdapter extends BaseAdapter {

    private List<Customer> customers;
    private Context context;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    DatabaseHelper customerDB = new DatabaseHelper(context);




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


        String name = thisCustomer.getName();
        String serviceIssue = thisCustomer.getServiceReason();
        String customerPhoneNumber = thisCustomer.getPhoneNumber(); //this can be highlighted in case the customer needs to be called quickly
        final String address = String.format("%s\n%s %s\n%s",
                thisCustomer.getLocation().getAddress().getStreet(),
                thisCustomer.getLocation().getAddress().getCity() + ",",
                thisCustomer.getLocation().getAddress().getState(),
                thisCustomer.getLocation().getAddress().getPostalCode());
        String customerPicture = thisCustomer.getProfilePicture().getLarge();

        final Double latitude = thisCustomer.getLocation().getCoordinate().getLatitude();
        final Double longitude = thisCustomer.getLocation().getCoordinate().getLongitude();

        final int customerIdentifier = thisCustomer.getIdentifier();
        final int visitOrder = thisCustomer.getVisitOrder();

        customerDB = new DatabaseHelper(context);
        customerDB.addData(customerIdentifier, visitOrder, name, customerPhoneNumber, serviceIssue, address, latitude, longitude, customerPicture);

        Cursor data = customerDB.getData();
        Cursor id = customerDB.getItemID(name);

        customerName.setText(String.valueOf(id));
        customerIssue.setText(serviceIssue);
        customerNumber.setText(customerPhoneNumber);
        customerAddress.setText(address);

        customerDB.close();


        if(customerPicture != null && customerPicture.length()>0)
        {
            Picasso.get().load(customerPicture).placeholder(R.drawable.ic_launcher_background).into(customerImageView);
        }else {
            makeText(context, "Empty Image URL", LENGTH_SHORT).show();
            Picasso.get().load(R.drawable.ic_launcher_background).into(customerImageView);
        }


        GoogleMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?daddr=" + latitude + "," + longitude;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Some of the GPS coordinates weren't giving exact location, so this is a back-up in case the coordinates don't work right
                //Addresses are also able to be highlighted, so the user can highlight the address and directly open google maps through that

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", address);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Address copied!", Toast.LENGTH_SHORT).show();

            }
        });




        return view;
    }

}



