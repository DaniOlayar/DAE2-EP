package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Cliente;
import pe.isil.service.ClienteService;

@Controller
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping("/clientes")
  public String clienteList(Model model) {
    model.addAttribute("clientes", clienteService.findAll());
    return "cliente";
  }

  @GetMapping("clientes/add")
  public String clienteAdd(Model model) {
    model.addAttribute("cliente", new Cliente());
    return "clienteAdd";
  }

  @PostMapping("clientes/save")
  public String clienteSave(Cliente cliente){
    clienteService.createOrUpdate(cliente);
    return "redirect:/clientes";
  }

  @GetMapping("/clientes/edit/{id}")
  public String clienteEdit(@PathVariable Long id, Model model) {
    model.addAttribute("cliente", clienteService.findById(id));
    return "clienteAdd";
  }

  @GetMapping("clientes/delete/{id}")
  public String clienteDelete(@PathVariable Long id) {
    clienteService.delete(id);
    return "redirect:/clientes";
  }

}
