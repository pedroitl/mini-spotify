import exceptions.EntradaVaziaException;
import exceptions.ListaVaziaException;
import exceptions.OpcaoInvalidaException;

public class Main {
    public static void main(String[] args) throws EntradaVaziaException, OpcaoInvalidaException, ListaVaziaException {
        Sistema sistema = new Sistema();
        try {
			sistema.iniciar();
		} catch (EntradaVaziaException | OpcaoInvalidaException | ListaVaziaException e) {
			System.out.println(e.getMessage());
			sistema.iniciar();
		}
    }
}