package com.bionic.edu;


import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	@PersistenceContext
	private EntityManager em;



	
	
}
