package telas;

public class GerarTela {
    public static void listarBancos(){
        for (Bancos item: Bancos.values()
             ) {
            System.out.println(item);
        }
    }
}
