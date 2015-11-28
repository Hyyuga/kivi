/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steppo
 */
@Repository
public interface MitgliederRepository extends CrudRepository<Mitglieder, Integer>{
    Mitglieder findBynachname(String nachname);
    @Query("SELECT me FROM mitglieder_ergebnisse me where me.id =:id")
    List<MitgliedErgebnisse> findErgebnisse(@Param("id") Integer mitgliedId);
}
