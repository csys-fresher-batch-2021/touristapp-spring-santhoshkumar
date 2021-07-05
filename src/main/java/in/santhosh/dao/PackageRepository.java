package in.santhosh.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.santhosh.model.TourPackageDetail;

@Repository
public interface PackageRepository extends CrudRepository<TourPackageDetail, Integer> {

}
