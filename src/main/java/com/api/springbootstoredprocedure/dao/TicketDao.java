package com.api.springbootstoredprocedure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.springbootstoredprocedure.model.Ticket;

import jakarta.persistence.EntityManager;

@Repository
public class TicketDao {
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Ticket> getTicketInfo() {
		return em.createNamedStoredProcedureQuery("firstProcedure").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> getTicketInfoByCatagory(String input) {
		return em.createNamedStoredProcedureQuery("secondProcedure").setParameter("tcatagory", input).getResultList();
	}
}
