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
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.companyvfarias.prueba_3.Adapters.ProductAdapter;
import cl.companyvfarias.prueba_3.Adapters.SalesAdpater;
import cl.companyvfarias.prueba_3.models.Product;
import cl.companyvfarias.prueba_3.models.Sale;


/**
 * A simple {@link Fragment} subclass.
 */
public class SalesFragment extends Fragment implements  NodesListerner.SalesNode{

    FirebaseRecyclerOptions<Sale> options;
    NodesListerner listener;
    SalesAdpater salesAdapter;


    public SalesFragment() {
        // Required empty public constructor
    }

    public static SalesFragment newInstance()
    {
        return new SalesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sales, container, false);


            }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView=view.findViewById(R.id.recyclerSales);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        options= new FirebaseRecyclerOptions.Builder<Sale>()
                .setQuery(new Nodes().Sales(),Sale.class)
                .setLifecycleOwner(this)
                .build();

        salesAdapter = new SalesAdpater(options,this.listener);
        recyclerView.setAdapter(salesAdapter);

    }

    @Override
    public void addChild() {

    }

    @Override
    public void removeChild() {

    }

    @Override
    public void update() {

    }
}
