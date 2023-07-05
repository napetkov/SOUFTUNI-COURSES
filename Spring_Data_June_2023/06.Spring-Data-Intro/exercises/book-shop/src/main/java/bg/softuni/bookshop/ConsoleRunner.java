package bg.softuni.bookshop;

import bg.softuni.bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//after suc compilation of our program run method will be run.
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;

    @Autowired
    public ConsoleRunner(SeedService seedService) {
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllData();
    }
}
