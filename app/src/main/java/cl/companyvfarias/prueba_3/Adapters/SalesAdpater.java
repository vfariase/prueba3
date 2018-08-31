package cl.companyvfarias.prueba_3.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cl.companyvfarias.prueba_3.NodesListerner;
import cl.companyvfarias.prueba_3.R;
import cl.companyvfarias.prueba_3.models.Product;
import cl.companyvfarias.prueba_3.models.Sale;

public class SalesAdpater extends FirebaseRecyclerAdapter<Sale,SalesAdpater.SalesViewHolder> {

    private NodesListerner listener;
    private Sale auxSale;
    private DatabaseReference root;

     public SalesAdpater(@NonNull FirebaseRecyclerOptions<Sale> options, NodesListerner listener) {
        super(options);
        this.listener = listener;
    }



    @NonNull
    @Override
    public SalesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_product, parent, false);
        return new SalesViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final SalesViewHolder holder, int position, @NonNull Sale sale) {

        holder.name.setText(sale.getName());
        holder.price.setText(sale.getPrice());
        Log.d("UID", "onBindViewHolder:+ "+sale.getUid());
        root = FirebaseDatabase.getInstance().getReference("Sales");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                auxSale=getItem(holder.getAdapterPosition());
                eraseChild();

            }
        });

    }

    public static class SalesViewHolder extends RecyclerView.ViewHolder
    {

        private TextView name,price;

        public SalesViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameProductTv);
            price = itemView.findViewById(R.id.priceTv);

        }
    }

     public void eraseChild(){

         root= FirebaseDatabase.getInstance().getReference();
         root.child("Sales").child(auxSale.getUid()).removeValue();

     }
}
