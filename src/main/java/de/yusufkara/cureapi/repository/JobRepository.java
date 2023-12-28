package de.yusufkara.cureapi.repository;

import de.yusufkara.cureapi.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JobRepository extends JpaRepository<Job, Long> {

}
