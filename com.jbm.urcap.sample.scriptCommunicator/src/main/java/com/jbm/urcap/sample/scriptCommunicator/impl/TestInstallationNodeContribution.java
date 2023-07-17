package com.jbm.urcap.sample.scriptCommunicator.impl;

import com.jbm.urcap.sample.scriptCommunicator.communicator.ScriptCommand;
import com.jbm.urcap.sample.scriptCommunicator.communicator.ScriptExporter;
import com.jbm.urcap.sample.scriptCommunicator.communicator.ScriptSender;
import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.domain.script.ScriptWriter;

public class TestInstallationNodeContribution implements InstallationNodeContribution {

	private final TestInstallationNodeView view;

	private final ScriptSender sender;
	private final ScriptExporter exporter;

	public TestInstallationNodeContribution(TestInstallationNodeView view) {
		this.view = view;
		this.sender = new ScriptSender();
		this.exporter = new ScriptExporter();
	}

	public void onIO() {
		ScriptCommand onCommand = new ScriptCommand("onIOSend");
		onCommand.setAsSecondaryProgram();
		onCommand.appendLine("set_digital_out(0,True)");
		sender.sendScriptCommand(onCommand);
	}

	public void offIO() {
		ScriptCommand offCommand = new ScriptCommand("offIOSend");
		offCommand.setAsSecondaryProgram();
		offCommand.appendLine("set_digital_out(0,False)");
		sender.sendScriptCommand(offCommand);
	}

	@Override
	public void openView() {
	}

	@Override
	public void closeView() {
	}

	@Override
	public void generateScript(ScriptWriter writer) {
	}

}
