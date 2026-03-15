package com.long1dep.trai_cay_ngon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraiCayNgonApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraiCayNgonApplication.class, args);
        printStartupInfo();
    }

    /**
     * Print startup information to console
     */
    private static void printStartupInfo() {
        System.out.println("""
                
                ╔═══════════════════════════════════════════════════════════╗
                ║                                                           ║
                ║   🍎                 MÂM NGŨ QUẢ                    🍎   ║
                ║   🍎 FRUIT MANAGEMENT SYSTEM - STARTED SUCCESSFULLY 🍎   ║
                ║                                                           ║
                ╠═══════════════════════════════════════════════════════════╣
                ║                                                           ║
                ║  📌 Server:    http://localhost:6969                      ║
                ║  📚 Swagger:   http://localhost:6969/swagger-ui.html      ║
                ║                                                           ║
                ║  🔑 Login Credentials:                                    ║
                ║     • Username: admin                                     ║
                ║     • Password: 123456                                    ║
                ║                                                           ║
                ║  ✅ 30 Sample Fruits Pre-loaded in Database              ║
                ║                                                           ║
                ║  🚀 API Endpoints:                                        ║
                ║     • POST   /api/auth/login                              ║
                ║     • GET    /api/fruits                                  ║
                ║     • GET    /api/fruits/{id}                             ║
                ║     • GET    /api/fruits/search                           ║
                ║     • POST   /api/fruits                                  ║
                ║     • PUT    /api/fruits/{id}                             ║
                ║     • DELETE /api/fruits/{id}                             ║
                ║                                                           ║
                ╚═══════════════════════════════════════════════════════════╝
                """);
    }

}


