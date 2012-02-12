package eu.riasol.pi.commands;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import eu.riasol.pi.app.PlaybookInstaller;
import eu.riasol.pi.model.PlaybookConfig;

public class InstallTokenCommand{
	public String textual;
	public void execute() {
		PlaybookConfig config = PlaybookInstaller.getInstance().config;
		List<String> cmd = new ArrayList<String>();
		cmd.add(System.getProperty("java.home")+"/bin/java.exe");
		cmd.add("-classpath");
		cmd.add(config.getSdkDir()+"/lib/EccpressoJDK15ECC.jar;"+config.getSdkDir()+"/lib/EccpressoAll.jar;"+config.getSdkDir()+"/lib/BarSigner.jar;"+config.getSdkDir()+"/lib/BarDeploy.jar;"+config.getSdkDir()+"/lib/BarAir.jar;"+config.getSdkDir()+"/lib/BarPackager.jar");
		//cmd.add("-verbose");
		cmd.add("com.qnx.bbt.airpackager.BarAirPackager");
		cmd.add("-installDebugToken");
		cmd.add(config.getTokenPath());
		cmd.add("-device");
		cmd.add(config.getDeviceIp());
		cmd.add("-password");
		cmd.add(config.getDevicePassword());
		ProcessBuilder pb = new ProcessBuilder(cmd);
		pb.redirectErrorStream(true);
		try {
			Process process = pb.start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer lines = new StringBuffer();
			String line;
			textual="";
			while ((line = br.readLine()) != null) {
				textual+=line+"\n";
				lines.append(line);
				lines.append("\n");
			}
			System.out.print(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
