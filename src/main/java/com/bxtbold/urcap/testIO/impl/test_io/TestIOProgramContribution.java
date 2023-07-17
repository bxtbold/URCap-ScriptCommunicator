package com.bxtbold.urcap.testIO.impl.test_io;

import com.bxtbold.urcap.testIO.communicator.ScriptCommand;
import com.bxtbold.urcap.testIO.communicator.ScriptSender;
import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;


public class TestIOProgramContribution implements ProgramNodeContribution {

	private final ScriptSender sender;

  public TestIOProgramContribution(
      ProgramAPIProvider apiProvider, TestIOProgramView view, DataModel model) {
    this.sender = new ScriptSender();
  }

  @Override
  public void openView() {}

  @Override
  public void closeView() {
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
  public boolean isDefined() {
    return true;
  }

  public String getTitle() {
    return "Test IO";
  }

  @Override
  public void generateScript(ScriptWriter writer) {
  }
}
