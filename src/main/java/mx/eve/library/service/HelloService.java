package mx.eve.library.service;

import org.springframework.stereotype.Service;

import mx.eve.library.service.interfaces.IHello;

@Service
public class HelloService  implements IHello{

	@Override
	public String grettings(String name, int age) {
				return String.format("%s with age: %d;", name, age);
	}

}
