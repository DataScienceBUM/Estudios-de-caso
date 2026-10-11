public class AlgoritmoShuntingYard {

    public int ranking(String token) {
        switch (token) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 0; // Si es un numero, una letra o un parentesis
        }
    }

    public String AlgoritmoShuntingYard(String data) {
        PilaDinamica pila = new PilaDinamica();
        String salida = "";
        String[] tokens = data.trim().split("\\s+");

        for (String token : tokens) {
            if (token.equals("(")) {
                pila.push(token);
            } else if (ranking(token) > 0) {
                while (!pila.isEmpty() && ranking(pila.peek()) >= ranking(token)) {
                    salida += pila.pop() + " ";
                }
                pila.push(token);
            } else if (token.equals(")")) {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    salida += pila.pop() + " ";
                }
                if (!pila.isEmpty()) {
                    pila.pop();
                }
            } else {
                salida += token + " ";
            }
        }

        while (!pila.isEmpty()) {
            salida += pila.pop() + " ";
        }

        return salida.trim();
    }

}