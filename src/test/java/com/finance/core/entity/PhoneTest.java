package com.finance.core.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneTest {
	Phone phone;
	
	@Before
	public void setUp() {
		phone = new Phone();
	}
	
	@Test
	public void testPhoneSetters() {
		Assert.assertNotNull(phone);
		phone.setPhoneType("mobile");
		Assert.assertEquals("mobile", phone.getPhoneType());
		phone.setPhoneNumber("98432");
		Assert.assertEquals("98432", phone.getPhoneNumber());
		Assert.fail("testing");
	}
}
