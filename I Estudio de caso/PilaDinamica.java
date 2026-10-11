public class PilaDinamica {
    private Nodo top;

    public PilaDinamica() {
        top = null;
    }

    public void push(String valor) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);
        nuevo.setSiguiente(top);
        top = nuevo;
    }

    public String pop() {
        if (top == null) {
            return null;
        }
        String valor = top.getDato();
        top = top.getSiguiente();
        return valor;
    }

    public String peek() {
        if (top == null) {
            return null;
        }
        return top.getDato();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        Nodo temp = top;
        while (temp != null) {
            count++;
            temp = temp.getSiguiente();
        }
        return count;
    }

    public void view() {
        if (isEmpty()) {
            System.out.println("Pila vacía");
            return;
        }

        Nodo temp = top;
        while (temp != null) {
            System.out.println(temp.getDato());
            temp = temp.getSiguiente();
        }
    }
}
