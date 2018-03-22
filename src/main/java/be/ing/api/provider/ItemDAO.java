package be.ing.api.provider;

import org.springframework.data.repository.CrudRepository;

public interface ItemDAO extends CrudRepository<ReceiptEntity,Long > {


}
