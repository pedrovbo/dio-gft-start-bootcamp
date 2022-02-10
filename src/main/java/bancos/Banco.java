package bancos;

import clientes.Cliente;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
public class Banco {

    @NonNull
    @Getter(AccessLevel.PUBLIC)
    protected String nome;

    public static List<Cliente> Clientes = new ArrayList<Cliente>();

    public static void setClientes(Cliente cliente){
        Clientes.add(cliente);
    }

    public static void getClientes() {
        for (Cliente cliente: Clientes) {
            System.out.println(cliente);
        }

    }


}
