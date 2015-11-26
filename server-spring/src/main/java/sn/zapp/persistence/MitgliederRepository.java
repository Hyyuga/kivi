/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steppo
 */
@Repository
public interface MitgliederRepository extends CrudRepository<Mitglieder, Integer>{
    Mitglieder findBynachname(String nachname);
}
