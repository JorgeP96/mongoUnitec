package uniter.org.mongoUnitec;

public class Estatus {
    private boolean Success;

    public Estatus() {
    }

    public Estatus(boolean success) {
        Success = success;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }
}