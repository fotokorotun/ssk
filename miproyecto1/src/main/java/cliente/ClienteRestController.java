package cliente;


	import java.util.Optional;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/webapi")
	public class ClienteRestController {

		@Autowired
		ClienteRepository clienteRepository;

		// ---------------------- crud: READ -------------------------------------------
		// -----------------------------------------------------------------------------
		@GetMapping("/allClientes")
		public Iterable<Cliente> getAllClientes() {

			return clienteRepository.findAll();
		}

		// ---------------------- crud: READ (by Id) ---------------------------------
		// ---------------------------------------------------------------------------
		@GetMapping("/getCliente/{id}")
		public Cliente findById(@PathVariable int id) {

			Optional<Cliente> clienteFound = clienteRepository.findById(id);

			if (clienteFound.isPresent()) {

				return clienteFound.get();
			}

			return null;
		}

		// ---------------------- crud: DELETE (by Id) -------------------------------
		// ----------------------------------------------------------------------------
		@DeleteMapping("/deleteCliente/{id}")
		public void deletCliente(@PathVariable int id) {

			Optional<Cliente> clienteFound = clienteRepository.findById(id);

			if (clienteFound.isPresent()) {

				clienteRepository.deleteById(id);
			}

		}

		// ---------------------- crud: CREATE (by Id) -------------------------------
		// ---------------------------------------------------------------------------
		@PostMapping(path = "/addCliente", consumes = "application/json")
		public void insertCliente(@RequestBody Cliente cliente) {

			// System.out.println(book);
			clienteRepository.save(cliente);
		}

		// ---------------------- crud: UPADATE (by Id) -------------------------------
		// ----------------------------------------------------------------------------
		@PutMapping("/updateCliente/{id}")
		public void upadatecliente(@RequestBody Cliente cliente, @PathVariable int id) {

			Optional<Cliente> clienteFound = clienteRepository.findById(id);

			if (clienteFound.isPresent()) {

				if (!cliente.getName().equals(clienteFound.get().getName()))
					clienteFound.get().setName(cliente.getName());

				if (!cliente.getSurname().equals(clienteFound.get().getSurname()))
					clienteFound.get().setSurname(cliente.getSurname());

				if (cliente.getAge() != clienteFound.get().getAge())
					clienteFound.get().setAge(cliente.getAge());

				if (!cliente.getEmail().equals(clienteFound.get().getEmail()))
					clienteFound.get().setEmail(cliente.getEmail());

				if (cliente.getMonthSalary() != clienteFound.get().getMonthSalary())
					clienteFound.get().setMonthSalary(cliente.getMonthSalary());

				if (!cliente.getPassword().equals(clienteFound.get().getPassword()))
					clienteFound.get().setPassword(cliente.getPassword());

					clienteRepository.save(clienteFound.get());
			}
		}

	}
	

