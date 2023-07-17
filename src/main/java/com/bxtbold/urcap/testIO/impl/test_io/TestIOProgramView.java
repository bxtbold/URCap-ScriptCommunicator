package com.bxtbold.urcap.testIO.impl.test_io;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;


public class TestIOProgramView implements SwingProgramNodeView<TestIOProgramContribution> {

  public TestIOProgramView() {
  }

  @Override
  public void buildUI(JPanel panel, ContributionProvider<TestIOProgramContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(createOnButton(provider));
		panel.add(createOffButton(provider));
  }

	private Box createOnButton(final ContributionProvider<TestIOProgramContribution> provider) {
		Box box = Box.createVerticalBox();

		JButton button = new JButton("ON BUTTON");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				provider.get().onIO();
			}
		});

		box.add(createSpacer(10));
		box.add(button);

		return box;
	}

	private Box createOffButton(final ContributionProvider<TestIOProgramContribution> provider) {
		Box box = Box.createVerticalBox();

		// create a button
		JButton button = new JButton("OFF BUTTON");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				provider.get().offIO();
			}
		});

		box.add(createSpacer(10));
		box.add(button);

		return box;
	}

	private Component createSpacer(int height) {
		return Box.createRigidArea(new Dimension(0, height));
	}
}
