package uniter.org.mongoUnitec;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioMensajito extends MongoRepository<Mensajito, String> {
}