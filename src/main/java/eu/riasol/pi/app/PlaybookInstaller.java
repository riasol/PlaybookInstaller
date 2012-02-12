package eu.riasol.pi.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import eu.riasol.pi.commands.InstallApplicationCommand;
import eu.riasol.pi.commands.InstallTokenCommand;
import eu.riasol.pi.model.PlaybookConfig;

public class PlaybookInstaller extends JFrame {
	private JPanel contentPane;
	private JTextField playbooksdk;
	private JLabel lblPlaybookSdk;
	private JLabel lblDevicePin;
	private JLabel lblDedugTokenPath;
	private JLabel lblDeviceIp;
	private JLabel lblDevicePassword;
	private JTextField devicepin;
	private JTextField debugtokenpath;
	private JTextField deviceip;
	private JPasswordField devPasswd;
	private JButton button;
	private JButton btnInstallToken;
	public PlaybookConfig config;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public PlaybookInstaller() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		config = new PlaybookConfig();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		playbooksdk = new JTextField();
		playbooksdk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setSdkDir(playbooksdk.getText());
			}
		});
		playbooksdk.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				config.setSdkDir(playbooksdk.getText());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				config.setSdkDir(playbooksdk.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				config.setSdkDir(playbooksdk.getText());
			}
		});
		playbooksdk.setText(config.getSdkDir());
		contentPane.add(playbooksdk);
		playbooksdk.setColumns(10);
		JButton btnSelect = new JButton("select path");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSelect, -10, SpringLayout.EAST, contentPane);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(playbooksdk.getText());
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = fc.showDialog(PlaybookInstaller.this, "select direcory");
				if (result == JFileChooser.APPROVE_OPTION) {
					playbooksdk.setText(fc.getSelectedFile().getPath());
					config.setSdkDir(playbooksdk.getText());
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSelect, 0, SpringLayout.NORTH, contentPane);
		contentPane.add(btnSelect);
		lblPlaybookSdk = new JLabel("Playbook sdk");
		sl_contentPane.putConstraint(SpringLayout.WEST, playbooksdk, 50, SpringLayout.EAST, lblPlaybookSdk);
		sl_contentPane.putConstraint(SpringLayout.NORTH, playbooksdk, 1, SpringLayout.NORTH, btnSelect);
		sl_contentPane.putConstraint(SpringLayout.EAST, playbooksdk, -6, SpringLayout.WEST, btnSelect);

		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPlaybookSdk, 4, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPlaybookSdk, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblPlaybookSdk);
		lblDevicePin = new JLabel("Device pin");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDevicePin, 15, SpringLayout.SOUTH, lblPlaybookSdk);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDevicePin, 0, SpringLayout.WEST, lblPlaybookSdk);
		contentPane.add(lblDevicePin);
		lblDedugTokenPath = new JLabel("Debug token path");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDedugTokenPath, 15, SpringLayout.SOUTH, lblDevicePin);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDedugTokenPath, 0, SpringLayout.WEST, lblPlaybookSdk);
		contentPane.add(lblDedugTokenPath);
		lblDeviceIp = new JLabel("Device ip");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDeviceIp, 15, SpringLayout.SOUTH, lblDedugTokenPath);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDeviceIp, 0, SpringLayout.WEST, lblPlaybookSdk);
		contentPane.add(lblDeviceIp);
		lblDevicePassword = new JLabel("Device password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDevicePassword, 15, SpringLayout.SOUTH, lblDeviceIp);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDevicePassword, 0, SpringLayout.WEST, lblPlaybookSdk);
		contentPane.add(lblDevicePassword);
		lblApplicationPath = new JLabel("Application path");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblApplicationPath, 0, SpringLayout.WEST, lblPlaybookSdk);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblApplicationPath, 15, SpringLayout.SOUTH, lblDevicePassword);
		contentPane.add(lblApplicationPath);
		devicepin = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, devicepin, 0, SpringLayout.NORTH, lblDevicePin);
		sl_contentPane.putConstraint(SpringLayout.EAST, devicepin, 0, SpringLayout.EAST, playbooksdk);
		sl_contentPane.putConstraint(SpringLayout.WEST, devicepin, 0, SpringLayout.WEST, playbooksdk);
		devicepin.setText(config.getPin());
		devicepin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setPin(devicepin.getText());
			}
		});
		devicepin.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				config.setPin(devicepin.getText());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				config.setPin(devicepin.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				config.setPin(devicepin.getText());
			}
		});
		devicepin.setColumns(10);
		contentPane.add(devicepin);
		debugtokenpath = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, debugtokenpath, 0, SpringLayout.NORTH, lblDedugTokenPath);
		sl_contentPane.putConstraint(SpringLayout.EAST, debugtokenpath, 0, SpringLayout.EAST, playbooksdk);
		sl_contentPane.putConstraint(SpringLayout.WEST, debugtokenpath, 0, SpringLayout.WEST, playbooksdk);
		debugtokenpath.setText(config.getTokenPath());
		debugtokenpath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setTokenPath(debugtokenpath.getText());
			}
		});
		debugtokenpath.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				config.setTokenPath(debugtokenpath.getText());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				config.setTokenPath(debugtokenpath.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				config.setTokenPath(debugtokenpath.getText());
			}
		});
		debugtokenpath.setColumns(10);
		contentPane.add(debugtokenpath);
		deviceip = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, deviceip, 0, SpringLayout.EAST, playbooksdk);
		sl_contentPane.putConstraint(SpringLayout.NORTH, deviceip, 0, SpringLayout.NORTH, lblDeviceIp);
		sl_contentPane.putConstraint(SpringLayout.WEST, deviceip, 0, SpringLayout.WEST, playbooksdk);
		deviceip.setText(config.getDeviceIp());
		deviceip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setDeviceIp(deviceip.getText());
			}
		});
		deviceip.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				config.setDeviceIp(deviceip.getText());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				config.setDeviceIp(deviceip.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				config.setDeviceIp(deviceip.getText());
			}
		});
		deviceip.setColumns(10);
		contentPane.add(deviceip);
		devPasswd = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.EAST, devPasswd, 0, SpringLayout.EAST, playbooksdk);
		sl_contentPane.putConstraint(SpringLayout.WEST, devPasswd, 0, SpringLayout.WEST, playbooksdk);
		sl_contentPane.putConstraint(SpringLayout.NORTH, devPasswd, 0, SpringLayout.NORTH, lblDevicePassword);
		devPasswd.setText(config.getDevicePassword());
		devPasswd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setDevicePassword(devPasswd.getText());
			}
		});
		devPasswd.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				config.setDevicePassword(devPasswd.getText());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				config.setDevicePassword(devPasswd.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				config.setDevicePassword(devPasswd.getText());
			}
		});
		devPasswd.setColumns(10);
		contentPane.add(devPasswd);
		button = new JButton("select path");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(debugtokenpath.getText());
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fc.showDialog(PlaybookInstaller.this, "select file");
				if (result == JFileChooser.APPROVE_OPTION) {
					debugtokenpath.setText(fc.getSelectedFile().getPath());
					config.setTokenPath(debugtokenpath.getText());
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, debugtokenpath);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, btnSelect);
		contentPane.add(button);
		btnInstallToken = new JButton("1. Install token");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnInstallToken, 50, SpringLayout.SOUTH, lblApplicationPath);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnInstallToken, 0, SpringLayout.WEST, lblPlaybookSdk);
		btnInstallToken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\ntoken installing, wait...\n");
				Thread cmdThread=new Thread() {
					@Override
					public void run() {
						InstallTokenCommand cmd = new InstallTokenCommand();
						cmd.execute();
						textArea.append(cmd.textual);
					};
				};
				cmdThread.start();
			}
		});
		contentPane.add(btnInstallToken);
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, btnInstallToken);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 11, SpringLayout.SOUTH, btnInstallToken);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 303, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -14, SpringLayout.EAST, contentPane);
		btnInstallApplication = new JButton("2. Install application");
		btnInstallApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\ninstalling, wait...\n");
				Thread cmdThread=new Thread() {
					@Override
					public void run() {
						InstallApplicationCommand cmd = new InstallApplicationCommand();
						cmd.execute();
						textArea.append(cmd.textual);
					};
				};
				cmdThread.start();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnInstallApplication, 6, SpringLayout.EAST, btnInstallToken);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnInstallApplication, 0, SpringLayout.SOUTH, btnInstallToken);
		contentPane.add(btnInstallApplication);
		applicationPath = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, applicationPath, 0, SpringLayout.EAST, playbooksdk);
		sl_contentPane.putConstraint(SpringLayout.NORTH, applicationPath, 0, SpringLayout.NORTH, lblApplicationPath);
		sl_contentPane.putConstraint(SpringLayout.WEST, applicationPath, 0, SpringLayout.WEST, playbooksdk);
		applicationPath.setText(config.getApplicationPath());
		applicationPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setApplicationPath(applicationPath.getText());
			}
		});
		applicationPath.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				config.setApplicationPath(applicationPath.getText());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				config.setApplicationPath(applicationPath.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				config.setApplicationPath(applicationPath.getText());
			}
		});
		contentPane.add(applicationPath);
		applicationPath.setColumns(10);
		btnSelect_1 = new JButton("select path");
		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(applicationPath.getText());
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fc.showDialog(PlaybookInstaller.this, "select file");
				if (result == JFileChooser.APPROVE_OPTION) {
					applicationPath.setText(fc.getSelectedFile().getPath());
					config.setApplicationPath(applicationPath.getText());
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSelect_1, 0, SpringLayout.NORTH, applicationPath);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSelect_1, 9, SpringLayout.EAST, applicationPath);
		contentPane.add(btnSelect_1);
		instance = this;
	}
	private static PlaybookInstaller instance;
	private JTextArea textArea;
	private JButton btnInstallApplication;
	private JLabel lblApplicationPath;
	private JTextField applicationPath;
	private JButton btnSelect_1;
	public static PlaybookInstaller getInstance() {
		return instance;
	}
}
