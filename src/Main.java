import exceptions.EntradaVaziaException;
import exceptions.ListaVaziaException;
import exceptions.OpcaoInvalidaException;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws EntradaVaziaException, OpcaoInvalidaException, ListaVaziaException, InputMismatchException {
        Sistema sistema = new Sistema();
        try {
            sistema.iniciar();
        } catch (EntradaVaziaException | OpcaoInvalidaException | ListaVaziaException | InputMismatchException e) {
            System.out.println(e.getMessage());
            sistema.iniciar();
        }
    }
}
