package bancos;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
public class Banco {

    @NonNull
    @Getter(AccessLevel.PROTECTED) protected String nome;

    //TODO: Implementar lista de clientes
}
