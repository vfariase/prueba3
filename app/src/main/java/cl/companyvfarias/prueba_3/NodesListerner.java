package cl.companyvfarias.prueba_3;

import cl.companyvfarias.prueba_3.models.Product;

public interface NodesListerner {

    interface ProductNode {
        void clicked(Product product);

        void dataChanged();

        void sendData(Product product);
    }

    interface SalesNode {

      void addChild();
      void removeChild();
      void update();

    }

}
