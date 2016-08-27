/**
 * 
 */
package br.org.ons.EssentialServices.util;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.repository.server.EssentialRepository;

/**
 * @author coichedid
 *
 */
public class LoggerImpl implements iLogger {

	private Logger LOGGER;
	/**
	 * 
	 */
	public LoggerImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.util.iLogger#getLogger()
	 */
	@Override
	public Logger getLogger() {
		return LOGGER;
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.util.iLogger#debug(java.lang.Object)
	 */
	@Override
	public void debug(Object msg) {
		LOGGER.debug(msg);
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.util.iLogger#init(java.lang.Class)
	 */
	@Override
	public void init(Class clazz) {
		LOGGER = Logger.getLogger(clazz); 
	}

}
