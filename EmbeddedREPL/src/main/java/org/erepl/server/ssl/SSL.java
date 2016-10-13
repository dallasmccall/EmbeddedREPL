package org.erepl.server.ssl;

import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class SSL {
	
	public static final SSLContext createInsecureContext() {
		SSLContext ctx;
		try {
			KeyStore ks = KeyStore.getInstance("pkcs12");
			ks.load(null, new char[0]);
			
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(ks, new char[0]);
			
			TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			tmf.init(ks);
			
			ctx = SSLContext.getInstance("TLSv1.2");
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
		} catch (Exception e) {
			e.printStackTrace();
			ctx = null;
		}
		return ctx;
	}
	
	public static void main(String[] args) {
		System.out.println("SSLContext: " + createInsecureContext());
	}
}