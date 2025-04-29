package com.ClementEischen.webAtrio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ClementEischen.webAtrio.Entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {}
