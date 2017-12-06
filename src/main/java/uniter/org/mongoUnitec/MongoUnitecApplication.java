package uniter.org.mongoUnitec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoUnitecApplication implements CommandLineRunner{

    @Autowired RepositorioMensajito repoMensa;

	public static void main(String[] args) {
	    SpringApplication.run(MongoUnitecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	    Mensajito mensa = new Mensajito("Primero","Mi primer mensajito");
	    repoMensa.save(mensa);
        System.out.println("Mensaje guardado");
    }
}
