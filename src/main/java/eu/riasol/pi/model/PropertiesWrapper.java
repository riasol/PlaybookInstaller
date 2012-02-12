package eu.riasol.pi.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesWrapper {
	private static ArrayList<PropertiesWrapper> instances = new ArrayList<PropertiesWrapper>();

	public static PropertiesWrapper get(String key) {
		for (PropertiesWrapper element : instances) {
			if (element.getKey().equals(key)) {
				return element;
			}
		}
		PropertiesWrapper w = new PropertiesWrapper(key);
		instances.add(w);
		return w;
	}

	private String key;
	private Properties properties = new Properties();

	public String getKey() {
		return key;
	}

	private PropertiesWrapper(String key) {
		this.key = key;
		setFileName(System.getProperty("user.home") + "/." + key + ".ini");
	}

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void save(String p, String v, boolean flush) {
		properties.setProperty(p, v);
		if(flush) {
			flush();
		}
	}
public void flush() {
	try {
		properties.store(new FileOutputStream(new File(fileName)),"");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	public void save(String p, String v) {
		save(p, v, true);
	}

	public String read(String p) {
		return read(p, "");
	}

	public String read(String p, String defaultValue) {
		return properties.getProperty(p, defaultValue);
	}

	public void load() {
		File f = new File(fileName);
		if (f.isFile()) {
			try {
				properties.load(new FileInputStream(f));
				// TODO Real logging
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
