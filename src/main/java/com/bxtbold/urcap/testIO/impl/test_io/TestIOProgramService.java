package com.bxtbold.urcap.testIO.impl.test_io;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.data.DataModel;


public class TestIOProgramService
    implements SwingProgramNodeService<TestIOProgramContribution, TestIOProgramView> {
  @Override
  public String getId() {
    return "TestIO";
  }

  @Override
  public void configureContribution(ContributionConfiguration configuration) {
  }

  @Override
  public String getTitle(Locale locale) {
    return "IO Test";
  }

  @Override
  public TestIOProgramView createView(ViewAPIProvider provider) {
    return new TestIOProgramView();
  }

  @Override
  public TestIOProgramContribution createNode(ProgramAPIProvider provider,
      TestIOProgramView view, DataModel model, CreationContext context) {
    return new TestIOProgramContribution(provider, view, model);
  }
}
