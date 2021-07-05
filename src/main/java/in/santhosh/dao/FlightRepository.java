package in.santhosh.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.santhosh.model.FlightDetail;

@Repository
public interface FlightRepository extends CrudRepository<FlightDetail, Integer>{

}
