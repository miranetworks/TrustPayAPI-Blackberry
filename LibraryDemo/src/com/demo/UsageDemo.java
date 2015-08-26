package com.demo;

import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngine;
import biz.trustpay.WrapperScreen;
import biz.trustpay.interfaces.PaymentListener;
import biz.trustpay.objects.Request;
import biz.trustpay.objects.TransactionResponse;

public class UsageDemo implements PaymentListener {
	AppMainScreen ams = null;

	public void SetParent(AppMainScreen ms) {
		ams = ms;
	}

	public void Result(TransactionResponse response) {
		System.out.println("*************************");
		System.out.println("*   Status:" + response.getStatusCode());
		System.out.println("*   Desc:" + response.getErrDescription());
		System.out.println("*   TxId:" + response.getTransactionId());
		System.out.println("*   Error:" + response.getErrCode());
		System.out.println("*************************");
		ams.result.setText(response.getStatusCode() + ":"
				+ response.getErrDescription());

	}

	public void SubmitPayment(Request req) {
		UiEngine ui = Ui.getUiEngine();
		WrapperScreen ws = new WrapperScreen(req, this);
		ui.pushGlobalScreen(ws, 1, UiEngine.GLOBAL_MODAL);
	}

}
