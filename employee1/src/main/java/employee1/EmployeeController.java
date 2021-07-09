package employee1;



	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/cliente")
	public class ClientesController {
		
		@Autowired
		EmployeeRepository clienteRepository;
		
		@RequestMapping("/allClientes")
		public String getAllClientes(Model boxToView) {
			
			
			//System.out.println(clienteRepository.findAll());
			boxToView.addAttribute("clientesListfromControllerAndDB", clienteRepository.findAll() );
			//boxToView.addAttribute("message", "hi from NORWAY");
			//boxToView.addAttribute("smoker", true);
			//boxToView.addAttribute("taxesIVA", 21.00);
			
			
			return "cliente.html";
		}

	}

