//package com.example.springbootproductmanagement;
//
//import com.example.springbootproductmanagement.model.Role;
//import com.example.springbootproductmanagement.model.User;
//import com.example.springbootproductmanagement.service.role.IRoleService;
//import com.example.springbootproductmanagement.service.user.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootApplication
//public class DemoApplication {
//    @Autowired
//    private IUserService userService;
//    @Autowired
//    private IRoleService roleService;
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//    @PostConstruct
//    public void init() {
//        List<User> users = (List<User>) userService.findAll();
//        List<Role> roleList = (List<Role>) roleService.findAll();
//        if (roleList.isEmpty()) {
//            Role roleAdmin = new Role();
//            roleAdmin.setId(1L);
//            roleAdmin.setName("ROLE_ADMIN");
//            roleService.save(roleAdmin);
//            Role roleUser = new Role();
//            roleUser.setId(2L);
//            roleUser.setName("ROLE_USER");
//            roleService.save(roleUser);
//        }
//        if (users.isEmpty()) {
//            User admin = new User();
//            List<Role> roles = new ArrayList<>();
//            Role roleAdmin = new Role();
//            roleAdmin.setId(1L);
//            roleAdmin.setName("ROLE_ADMIN");
//            roles.add(roleAdmin);
//            admin.setUsername("admin");
//            admin.setPassword("123456");
//            admin.setRoles(roles);
//            userService.save(admin);
//        }
//    }
//
//}
