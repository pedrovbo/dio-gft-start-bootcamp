package telas;

public enum Bancos {
    BB("Banco do Brasil"),
    CEF("Caixa Econômica Federal")
    ;

    private final String text;

    Bancos(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }
}
