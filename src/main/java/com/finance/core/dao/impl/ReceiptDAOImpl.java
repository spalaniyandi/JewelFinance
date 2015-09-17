package com.finance.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.finance.core.dao.ReceiptDAO;
import com.finance.core.entity.Receipt;
import com.finance.web.domain.ReceiptModel;
import com.finance.web.domain.ReceiptQueryModel;

@Repository
public class ReceiptDAOImpl extends AbstractDAOImpl implements ReceiptDAO {

	@Override
	public void addReceipt(Receipt receipt) {
		this.sessionFactory.getCurrentSession().save(receipt);
	}

	@Override
	public Receipt getReceipt(long receiptId) {
		
		return (Receipt) this.sessionFactory.getCurrentSession().get(Receipt.class, receiptId);
	}

	@Override
	public List<Receipt> searchReceipts(ReceiptQueryModel receiptQuery) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Receipt.class);
		if (receiptQuery.getReceiptId() != 0) {
			criteria.add(Restrictions.eq("id", receiptQuery.getReceiptId()));
		}
		if (receiptQuery.getLoanAmount() != 0) {
			criteria.add(Restrictions.eq("loanAmount", receiptQuery.getLoanAmount()));
		}
		if (receiptQuery.getLoanDate() != null) {
			criteria.add(Restrictions.eq("loanDate", receiptQuery.getLoanDate()));
		}		
		criteria.createAlias("customer", "customer");
		if (receiptQuery.getFirstName() != null && !receiptQuery.getFirstName().isEmpty()) {
			criteria.add(Restrictions.ilike("customer.firstName", receiptQuery.getFirstName()));
		}
		if (receiptQuery.getLastName() != null && !receiptQuery.getLastName().isEmpty()) {
			criteria.add(Restrictions.ilike("customer.lastName", receiptQuery.getLastName()));
		}
		criteria.createAlias("phone", "phone");
		if (receiptQuery.getPhone().getPhoneNumber() != null && !receiptQuery.getPhone().getPhoneNumber().isEmpty()) {
			criteria.add(Restrictions.like("phone.phoneNumber", receiptQuery.getPhone().getPhoneNumber()));
			
			if (receiptQuery.getPhone().getPhoneTypeInString() != null) {
				criteria.add(Restrictions.like("phone.phoneType", receiptQuery.getPhone().getPhoneTypeInString()));
			}
		}
		criteria.createAlias("idCard", "idCard");
		if (receiptQuery.getIdCard().getIdNumber() != null && !receiptQuery.getIdCard().getIdNumber().isEmpty()) {
			criteria.add(Restrictions.ilike("idCard.idNumber", receiptQuery.getIdCard().getIdNumber()));
			
			if (receiptQuery.getIdCard().getIDTypeInString() != null) {
				criteria.add(Restrictions.like("idCard.idType", receiptQuery.getIdCard().getIDTypeInString()));
			}
		}
		return (List<Receipt>)criteria.list();
	}

}
