package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Orden;
import pe.isil.repository.OrdenRepository;

import java.util.List;

@Service
public class OrdenService {

  @Autowired
  private OrdenRepository ordenRepository;

  public void createOrUpdate(Orden orden) {
    ordenRepository.save(orden);
  }

  public void delete(Long id) {
    ordenRepository.deleteById(id);
  }

  public Orden findById(Long id) {
    return ordenRepository.findById(id).orElse(null);
  }

  public List<Orden> findAll(){
    return ordenRepository.findAll();
  }

}
