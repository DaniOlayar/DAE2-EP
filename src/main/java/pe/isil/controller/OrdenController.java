package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Orden;
import pe.isil.service.ClienteService;
import pe.isil.service.OrdenService;

@Controller
public class OrdenController {

  @Autowired
  private OrdenService ordenService;

  @Autowired
  private ClienteService clienteService;

  @GetMapping("index")
  public String index() {
    return "index";
  }

  @GetMapping("/ordenes")
  public String ordenList(Model model) {
    model.addAttribute("ordenes", ordenService.findAll());
    return "orden";
  }

  @GetMapping("ordenes/add")
  public String ordenAdd(Model model) {
    model.addAttribute("orden", new Orden());
    model.addAttribute("clientes", clienteService.findAll());
    return "ordenAdd";
  }

  @PostMapping("ordenes/save")
  public String ordenSave(Orden orden){
    ordenService.createOrUpdate(orden);
    return "redirect:/ordenes";
  }

  @GetMapping("/ordenes/edit/{id}")
  public String ordenEdit(@PathVariable Long id, Model model) {
    model.addAttribute("orden", ordenService.findById(id));
    return "ordenAdd";
  }

  @GetMapping("ordenes/delete/{id}")
  public String ordenDelete(@PathVariable Long id) {
    ordenService.delete(id);
    return "redirect:/ordenes";
  }

}
