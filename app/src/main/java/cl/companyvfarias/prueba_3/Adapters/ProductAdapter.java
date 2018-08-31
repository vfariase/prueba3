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

import cl.companyvfarias.prueba_3.Nodes;
import cl.companyvfarias.prueba_3.NodesListerner;
import cl.companyvfarias.prueba_3.R;
import cl.companyvfarias.prueba_3.models.Product;
import cl.companyvfarias.prueba_3.models.Sale;

public class ProductAdapter extends FirebaseRecyclerAdapter<Product,ProductAdapter.ProductViewHolder>{

    private NodesListerner listerner;
    private  DatabaseReference root, productNode;
    Product auxProduct,product;
    private boolean flag=true;


    public ProductAdapter(@NonNull FirebaseRecyclerOptions<Product> options,NodesListerner listener) {
       super(options);
       this.listerner = listener;

    }

    @Override
    protected void onBindViewHolder(@NonNull final ProductViewHolder holder, int position, @NonNull Product product) {

           holder.name.setText(product.getName());
           holder.price.setText(product.getPrice());
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   auxProduct=getItem(holder.getAdapterPosition());
                   addChild();

               }
           });





    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_sales, parent, false);
        return new ProductViewHolder(view);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder
    {

        TextView name,price;

        public ProductViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.nameProductTv);
            price = view.findViewById(R.id.priceTv);



        }
    }


    public void addChild() {
        Sale sale = new Sale();
        root = FirebaseDatabase.getInstance().getReference();
        String key = root.child("Sales").push().getKey();

        Log.d("sale", "addChild: "+sale);
        Log.d("flag", "addChild: "+flag);

            sale.setUid(key);
            sale.setName(auxProduct.getName());
            sale.setPrice(auxProduct.getPrice());
            root.child("Sales").child(key).setValue(sale);


            root.child("Sales").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }










}
