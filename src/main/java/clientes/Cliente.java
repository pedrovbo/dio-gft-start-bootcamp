package clientes;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Getter
    @Setter(AccessLevel.PROTECTED)
    @NonNull
    protected String nome;

}
