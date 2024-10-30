package clase_30_octubre;

public class EMail {
    public final byte PERSONAL = 1;
    public final byte TRABAJO = 2;
    public final byte OTRO = 3;
    private String dirEMail;
    private byte tipo;

    public EMail(String dirEMail, byte tipo) {
        this.dirEMail = dirEMail;
        this.tipo = tipo;
    }

    public String getDirEMail() {
        return dirEMail;
    }

    public byte getTipo() {
        return tipo;
    }
}
