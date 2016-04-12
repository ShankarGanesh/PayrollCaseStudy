package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.usecase.usecases.pay.fullfill.fullfillers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.entity.PayCheck;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.secondary.database.TransactionalRunner;

public class PaymasterPaymentFulfiller implements PaymentFulfiller {
	private Log log = LogFactory.getLog(getClass());

	private TransactionalRunner transactionalRunner;

	public PaymasterPaymentFulfiller(TransactionalRunner transactionalRunner) {
		this.transactionalRunner = transactionalRunner;
	}

	@Override
	public void fulfillPayment(PayCheck payCheck) {
		transactionalRunner.executeInTransaction(() -> {
			log.info("(Mock) Paymaster payment record added for:" + payCheck);
		});
	}

}
