
public class ListasApp {

	public static void main(String[] args) {
		ListaEncadeada minhaLista=new ListaEncadeada();
		
		minhaLista.add("Jesus");
		minhaLista.add("José");
		minhaLista.add("Maria");
		minhaLista.add("João");
		minhaLista.add("Pedro");
		minhaLista.add("Judas"); 
		minhaLista.print();

		// testa os métodos remove
		System.out.println();
		System.out.println("removendo o elemento na posição 4");
		minhaLista.remove(4);
		minhaLista.print();
		
		System.out.println();
		System.out.println("removendo o elemento 'Judas'");
		minhaLista.remove("Judas");
		minhaLista.print();
		
		// testa set
		System.out.println();
		System.out.println("subbstituindo o elemento na posição 1 por 'Joseph'");
		minhaLista.set(1, "Joseph");
		minhaLista.print();
	}

}