package de.yusufkara.cureapi.repository;

import de.yusufkara.cureapi.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface JobRepository extends JpaRepository<Job, Long> {
    // Fetch jobs by name
    List<Job> findByName(@Param("name") String name);
}
