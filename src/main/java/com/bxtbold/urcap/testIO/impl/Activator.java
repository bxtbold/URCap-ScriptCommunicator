package com.bxtbold.urcap.testIO.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.bxtbold.urcap.testIO.impl.test_io.TestIOProgramService;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;

public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		bundleContext.registerService(SwingProgramNodeService.class, new TestIOProgramService(), null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	}
}
