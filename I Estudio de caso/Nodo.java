public class Nodo {
    private String dato;
    private Nodo siguiente;

    public Nodo() {
        siguiente = null;
        dato = null;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }
}
