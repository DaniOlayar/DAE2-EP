package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Cliente;
import pe.isil.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  public void createOrUpdate(Cliente cliente) {
    clienteRepository.save(cliente);
  }

  public void delete(Long id) {
    clienteRepository.deleteById(id);
  }

  public Cliente findById(Long id) {
    return clienteRepository.findById(id).orElse(null);
  }

  public List<Cliente> findAll(){
    return clienteRepository.findAll();
  }

}
