package cliente;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/cliente")
	public class ClienteController {
		
		@Autowired
		ClienteRepository clienteRepository;
		
		
		
		//------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------
		@RequestMapping("/allClientes")
		public String getAllClientes(Model boxToView) {
			
			
			
			//System.out.println(clienteRepository.findAll());
			boxToView.addAttribute("clienteListfromControllerAndDB", clienteRepository.findAll() );
			//boxToView.addAttribute("message", "hi from NORWAY");
			//boxToView.addAttribute("smoker", true);
			//boxToView.addAttribute("taxesIVA", 21.00);
			
			
			
			
			return "cliente.html";
		}
	
		//------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------

	@RequestMapping("/*")
	public String notFound (Model model) {
		
		String pattern = "yyyy-MM-dd HH:mm:ssZ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		model.addAttribute("serverTime", simpleDateFormat.format(new Date()));
		
		return "notFound.html";
	}
	
	
	//------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------

	@RequestMapping("/deleteCliente")
	public String removeCliente(int id, Model model) {
		
		//System.out.println("inside removeCliente" + id);
		Optional<Cliente> clienteFound = findOneClienteById(id);
		
		//System.out.println("find inside removeCliente" + clienteFound.get());
		
		if (clienteFound.isPresent()) {
			
			clienteRepository.deleteById(id);
			model.addAttribute("message", "deleted employee confirmation");
			model.addAttribute( "clienteDeleted", clienteFound.get());
		}
		
		else {
			model.addAttribute("message", "deleted cliente error, maybe there is no id .... or network connection ..");
		}
		
		
		
		
		
		//System.out.println("finishing removeCliente" + id);
		return "redirect:/cliente/allClientes";
	}
	
	
	
	
	//--------------------------------------------------------------------------------
	//------------------------- service to controller --------------------------------
	//--------------------------------------------------------------------------------

		public Optional<Cliente> findOneClienteById(int id) {

			
			Optional<Cliente> clienteFound = clienteRepository.findById(id);
			
			return clienteFound;
	
		
		}
		
		@RequestMapping("/addCliente")
		public String inserCliente(Cliente cliente) {

			clienteRepository.save(cliente);

			return "redirect:/cliente/allClientes";
	}
	
		@RequestMapping("/newCliente")
		public String newCliente() {

			return "newcliente.html";
		}

		@RequestMapping("/updateCliente")
		public String updateCliente(int id, Model model) {

			Optional<Cliente> clienteFound = findOneClienteById(id);

			if (clienteFound.isPresent()) {

				model.addAttribute("clientefromController", clienteFound.get());
				return "updatecliente";
			}

			else
				return "notfound.html";
		}

		@PostMapping("/replaceCliente/{idFromView}")
		public String replaceCliente(@PathVariable("idFromView") int id, Cliente cliente) {

			Optional<Cliente> clienteFound = findOneClienteById(id);

			if (clienteFound.isPresent()) {

				if (cliente.getName() != null)
					clienteFound.get().setName(cliente.getName());
				if (cliente.getSurname() != null)
					clienteFound.get().setSurname(cliente.getSurname());
				if (cliente.getPassword() != null)
					clienteFound.get().setPassword(cliente.getPassword());
				if (cliente.getEmail() != null)
					clienteFound.get().setEmail(cliente.getEmail());
				if (cliente.getAge() != 0)
					clienteFound.get().setAge(cliente.getAge());
				if (cliente.getMonthSalary() != 0.0)
					clienteFound.get().setMonthSalary(cliente.getMonthSalary());

				clienteRepository.save(clienteFound.get());
				return "redirect:/cliente/allClientes";

			} else
				return "notfound.html";

		}
			@RequestMapping("/detailCliente")
			public String detailCliente(int id, Model model) {

				Optional<Cliente> clienteFound = findOneClienteById(id);

				if (clienteFound.isPresent()) {

					model.addAttribute("clientefromController", clienteFound.get());
					return "detailcliente";
				}

				else
					return "notfound.html";
		}
	
	
	}
	
	
	
	