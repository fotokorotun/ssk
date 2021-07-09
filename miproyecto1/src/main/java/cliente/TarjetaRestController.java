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

public class TarjetaRestController {

	
	
	

	@RestController
	@RequestMapping("/webapi")
	public class TarjetaRestController {

		@Autowired
		TarjetaRepository tarjetaRepository;

		// ---------------------- crud: READ -------------------------------------------
		// -----------------------------------------------------------------------------
		@GetMapping("/allTarjeta")
		public Iterable<Carjeta> getAllTarjeta() {

			return tarjetaRepository.findAll();
		}

		// ---------------------- crud: READ (by Id) ---------------------------------
		// ---------------------------------------------------------------------------
		@GetMapping("/getTarjeta/{id}")
		public Tarjeta findById(@PathVariable int id) {

			Optional<Tarjeta> tarjetaFound = tarjetaRepository.findById(id);

			if (tarjetaFound.isPresent()) {

				return tarjetaFound.get();
			}

			return null;
		}

		// ---------------------- crud: DELETE (by Id) -------------------------------
		// ----------------------------------------------------------------------------
		@DeleteMapping("/deleteTarjeta/{id}")
		public void deletTarjeta(@PathVariable int id) {

			Optional<Tarjeta> tarjetaFound = tarjetaRepository.findById(id);

			if (tarjetaFound.isPresent()) {

				tarjetaRepository.deleteById(id);
			}

		}

		// ---------------------- crud: CREATE (by Id) -------------------------------
		// ---------------------------------------------------------------------------
		@PostMapping(path = "/addTarjeta", consumes = "application/json")
		public void insertTarjeta(@RequestBody Tarjeta tarjeta) {

			// System.out.println(book);
			tarjetaRepository.save(tarjeta);
		}

		// ---------------------- crud: UPADATE (by Id) -------------------------------
		// ----------------------------------------------------------------------------
		@PutMapping("/updateTarjeta/{id}")
		public void upadateTarjeta(@RequestBody Tarjeta tarjeta, @PathVariable int id) {

			Optional<Tarjeta> tarjetaFound = tarjetaRepository.findById(id);

			if (tarjetaFound.isPresent()) {

				if (!tarjeta.getName().equals(tarjetaFound.get().getName()))
					tarjetaFound.get().setName(tarjeta.getName());

				if (!tarjeta.getSurname().equals(tarjetaFound.get().getSurname()))
					tarjetaFound.get().setSurname(tarjeta.getSurname());

				if (tarjeta.getAge() != tarjetaFound.get().getAge())
					tarjetaFound.get().setAge(tarjeta.getAge());

				if (!tarjeta.getEmail().equals(tarjetaFound.get().getEmail()))
					tarjetaFound.get().setEmail(tarjeta.getEmail());

				if (tarjeta.getMonthSalary() != tarjetaFound.get().getMonthSalary())
					tarjetaFound.get().setMonthSalary(tarjeta.getMonthSalary());

				if (!tarjeta.getPassword().equals(tarjetaFound.get().getPassword()))
					tarjetaFound.get().setPassword(tarjeta.getPassword());

				tarjetaRepository.save(tarjetaFound.get());
			}
		}

	}
	


}
