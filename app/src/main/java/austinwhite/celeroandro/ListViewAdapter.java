package austinwhite.celeroandro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

class ListViewAdapter extends BaseAdapter {

    private List<Customer> customers;
    private Context context;

    public ListViewAdapter(Context context,List<Customer> customers){
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
    public long getItemId(int visitOrder) {
        return visitOrder;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(context).inflate(R.layout.model,viewGroup,false);
        }

        TextView customerName = view.findViewById(R.id.customerName);
        TextView customerIssue = view.findViewById(R.id.customerIssue);
        ImageView customerImageView = view.findViewById(R.id.customerImage);

        final Customer thisCustomer= customers.get(position);

        customerName.setText(thisCustomer.getName());
        customerIssue.setText(thisCustomer.getServiceReason());


        if(thisCustomer.getThumbnailImage() != null && thisCustomer.getMediumImage().length()>0)
        {
            Picasso.get().load(thisCustomer.getMediumImage()).placeholder(R.drawable.ic_launcher_background).into(customerImageView);
        }else {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_LONG).show();
            Picasso.get().load(R.drawable.ic_launcher_background).into(customerImageView);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, thisCustomer.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}



