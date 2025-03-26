
public class ListasApp {

	public static void main(String[] args) {
		ListaEncadeada minhaLista=new ListaEncadeada();
		// Testa métodos isEmpty, size, add e print
		if(minhaLista.isEmpty())
			System.out.println("Lista Vazia");
		else 
			System.out.println("Size="+minhaLista.size());
			
		minhaLista.print();
		minhaLista.add("Jesus");
		minhaLista.add("José");
		minhaLista.add("Maria");
		minhaLista.add("João");
		minhaLista.add("Pedro");
		minhaLista.add("Judas"); 
		minhaLista.print();

		// testa indexOf		
		String aux="Pedro";
		System.out.println(minhaLista.indexOf(aux));
	
		
		// Testa get
		try {
			System.out.println(minhaLista.get(8));
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}	
		try {
			System.out.println(minhaLista.get(2));
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
			
		// testa método add(index, object)
		minhaLista.add(4,"Mario");  			
		minhaLista.print();


		// testa o método remove(index)
		System.out.println();
		System.out.println("removendo o elemento na posição 4");
		minhaLista.remove(4);
		minhaLista.print();
		
		// testa o método remove(object)
		System.out.println();
		System.out.println("removendo o elemento 'Judas'");
		minhaLista.remove("Judas");
		minhaLista.print();
		
		// testa set
		System.out.println();
		System.out.println("substituindo o elemento na posição 1 por 'Joseph'");
		minhaLista.set(1, "Joseph");
		minhaLista.print();
	}

}