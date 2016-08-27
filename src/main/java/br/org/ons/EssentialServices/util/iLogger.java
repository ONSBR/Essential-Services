package br.org.ons.EssentialServices.util;

import org.apache.log4j.Logger;

public interface iLogger {
	Logger getLogger();
	void debug(Object msg);
	void init(Class clazz);
}
