package xtech.qrvenus;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QrVenusApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrVenusApplication.class, args);
    }

    @Bean // Bean ile birlikte buranın bir nesne ve IOC'nin ihtiyacı olduğunu anlar ve oluşturup ekler.
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
