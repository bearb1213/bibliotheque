package mg.itu.spring.service;

import mg.itu.spring.entity.Department;
import mg.itu.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    public DepartmentService() {
    }

    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department create(String name) {
        return departmentRepo.save(new Department(name));
    }

    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    public Department getByName(String name) {
        return departmentRepo.findByName(name);
    }

    public void delete(int id) {
        departmentRepo.deleteById(id);
    }

    // Exemple de logique métier
    public boolean departmentExists(String name) {
        return departmentRepo.findByName(name) != null;
    }

    public DepartmentRepository getDepartmentRepo() {
        return departmentRepo;
    }

    public void setDepartmentRepo(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }
}
