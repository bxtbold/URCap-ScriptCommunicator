package com.jbm.urcap.sample.scriptCommunicator.impl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeView;

public class TestInstallationNodeView implements SwingInstallationNodeView<TestInstallationNodeContribution>{

	private JLabel RETURN_VALUE = new JLabel();

	@Override
	public void buildUI(JPanel panel, TestInstallationNodeContribution contribution) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(createOnButton(contribution));
		panel.add(createSpacer(40));
		panel.add(createOffButton(contribution));
	}

	public void setReturnValue(String value) {
		RETURN_VALUE.setText(value);
	}

	private Box createOnButton(final TestInstallationNodeContribution contribution) {
		Box box = Box.createVerticalBox();

		JButton button = new JButton("ON BUTTON");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contribution.onIO();
			}
		});

		box.add(createSpacer(10));
		box.add(button);

		return box;
	}

	private Box createOffButton(final TestInstallationNodeContribution contribution) {
		Box box = Box.createVerticalBox();

		JButton button = new JButton("OFF BUTTON");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contribution.offIO();
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
