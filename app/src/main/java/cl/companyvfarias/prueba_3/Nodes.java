package cl.companyvfarias.prueba_3;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nodes{

    private DatabaseReference root= FirebaseDatabase.getInstance().getReference();

    public DatabaseReference Products() {

        return root.child("products");
    }

    public DatabaseReference Sales() {
        return root.child("Sales");
    }


}

