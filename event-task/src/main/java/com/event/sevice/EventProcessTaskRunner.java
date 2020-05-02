package com.event.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class EventProcessTaskRunner implements CommandLineRunner {

	@Autowired
	private EventProcessService eventProcessService;

	@Override
	public void run(String... args) throws Exception {

		if (args.length > 0) {
			System.out.println("Task running with argument");

			if (eventProcessService.validateDL(args[0])) {
				System.out.println("Validate Driving License..");
			}
		} else {
			System.out.println("Task running without argument");
		}

	}

}
