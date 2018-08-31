package cl.companyvfarias.prueba_3;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.companyvfarias.prueba_3.Adapters.ProductAdapter;
import cl.companyvfarias.prueba_3.models.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment implements NodesListerner.ProductNode {

    FirebaseRecyclerOptions<Product> options;
    NodesListerner listener;
    ProductAdapter productAdapter;
    public ProductsFragment() {
        // Required empty public constructor
    }

    public static ProductsFragment newInstance()
    {
        return new ProductsFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        RecyclerView recyclerView=v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        options= new FirebaseRecyclerOptions.Builder<Product>()
                .setQuery(new Nodes().Products(),Product.class)
                .setLifecycleOwner(this)
                .build();

        productAdapter = new ProductAdapter(options, this.listener);
        recyclerView.setAdapter(productAdapter);

    }




    @Override
    public void clicked(Product product) {

    }

    @Override
    public void dataChanged() {

    }

    @Override
    public void sendData(Product product) {

    }




    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
