package edu.kh.collection.run;

import edu.kh.collection.model.service.ClientService;

public class ClientRun {

	public static void main(String[] args) {

		ClientService service = new ClientService();
		service.displayMenu();
		
	}

}
