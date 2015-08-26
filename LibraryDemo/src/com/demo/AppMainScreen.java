package com.demo;

import biz.trustpay.objects.Request;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;
import java.util.Date;
import net.rim.device.api.ui.component.TextField;

public class AppMainScreen extends MainScreen {
	final TextField amount = new TextField();
	final TextField currency = new TextField();
	final TextField description = new TextField();
	public final TextField result = new TextField();

	public AppMainScreen() {
		setTitle("TrustPay");
		amount.setLabel("Amount:");
		amount.setText("3");
		add(amount);
		currency.setLabel("Currency:");
		currency.setText("ZAR");
		add(currency);
		description.setLabel("Description:");
		description.setText("BlackBerry test transaction");
		add(description);
		ButtonField load = new ButtonField("Load");
		load.setChangeListener(new FieldChangeListener() {

			public void fieldChanged(Field field, int context) {
				Request req = new Request();
				req.amount = amount.getText();
				req.app_id = "ap.2f0e6617-902b-4bf2-9c09-90853629b4aa";
				Date now = new Date();
				req.app_ref = String.valueOf(now.getTime());
				req.currency = currency.getText();
				req.istest = false;
				req.tx_description = description.getText();
				Start(req);
			}

		});
		add(load);
		add(result);

	}

	private void Start(Request req) {
		UsageDemo demo = new UsageDemo();
		demo.SetParent(this);
		demo.SubmitPayment(req);
	}
}
