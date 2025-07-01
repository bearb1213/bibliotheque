package mg.itu.spring.controller;

import mg.itu.spring.entity.Employe;
import mg.itu.spring.entity.Department;
import mg.itu.spring.repository.EmployeRepository;
import mg.itu.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/employes")
    public String listeEmployes(Model model) {
        model.addAttribute("employes", employeRepository.findAll());
        model.addAttribute("employe", new Employe());
        model.addAttribute("departements", departmentRepository.findAll());
        return "employe/liste";
    }

    @PostMapping("/employes")
    public String ajouterEmploye(@ModelAttribute Employe employe, 
                                @RequestParam(name="departmentId",required = false) Integer departmentId) {
        if (departmentId != null) {
            Department department = departmentRepository.findById(departmentId).orElse(null);
            employe.setDepartment(department);
        }
        employeRepository.save(employe);
        return "redirect:/employes";
    }

    @GetMapping("/employes/supprimer")
    public String supprimerEmploye(@RequestParam(name = "id") Integer id) {
        employeRepository.deleteById(id);
        return "redirect:/employes";
    }

    @GetMapping("/employes/modifier")
    public String modifierEmployeForm(@RequestParam (name="id") Integer id, Model model) {
        Employe employe = employeRepository.findById(id).orElseThrow();
        model.addAttribute("employe", employe);
        model.addAttribute("departements", departmentRepository.findAll());
        return "employe/modifier";
    }

    @PostMapping("/employes/modifier")
    public String modifierEmploye(@ModelAttribute Employe employe, 
                                 @RequestParam(name="departmentId",required = false) Integer departmentId) {
        if (departmentId != null) {
            Department department = departmentRepository.findById(departmentId).orElse(null);
            employe.setDepartment(department);
        }
        employeRepository.save(employe);
        return "redirect:/employes";
    }
}