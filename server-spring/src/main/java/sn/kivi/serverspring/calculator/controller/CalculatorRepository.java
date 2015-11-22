/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.calculator.controller;

import sn.kivi.serverspring.calculator.persistence.entities.Calculator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steppo
 */
@Repository
public interface CalculatorRepository extends CrudRepository<Calculator, Integer>{
//    public List<Calculator> findAll(Integer result);
//    Page<Calculator> findAll(Pageable page);
//    List<Calculator> findByResult(Integer lastName);
}
