package mg.itu.spring;

//import mg.itu.spring.config.AppConfig;
import mg.itu.spring.service.DepartmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\n========== MAIN START ===========\n");

        // version utilisant AppConfig comme fichier de configuration
        /*ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        departmentService.create("Nouveau dept 2");*/

        // version utilisant beans.xml comme fichier de configuration
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //DepartmentService departmentService = context.getBean(DepartmentService.class);
        //departmentService.create("New dept");
//
        //System.out.println("\n========== MAIN END ===========\n");
    }
}
