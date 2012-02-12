package eu.riasol.pi.model;


public class PlaybookConfig {
	private PropertiesWrapper storage;
 public PlaybookConfig() {
	 storage=PropertiesWrapper.get("PlaybookInstaller");
	 storage.load();
 }
	public String getPin() {
		pin=storage.read("pin");
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
		storage.save("pin", pin);
	}
	public String getSdkDir() {
		sdkDir=storage.read("sdkDir");
		return sdkDir;
	}
	public void setSdkDir(String sdkDir) {
		this.sdkDir = sdkDir;
		storage.save("sdkDir",sdkDir );
	}
	public String getTokenPath() {
		tokenPath=storage.read("tokenPath");
		return tokenPath;
	}
	public void setTokenPath(String tokenPath) {
		this.tokenPath = tokenPath;
		storage.save("tokenPath", tokenPath);
	}
	public String getDeviceIp() {
		deviceIp=storage.read("deviceIp");
		return deviceIp;
	}
	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
		storage.save("deviceIp", deviceIp);
	}
	public String getDevicePassword() {
		devicePassword=storage.read("devicePassword");
		return devicePassword;
	}
	public void setDevicePassword(String devicePassword) {
		this.devicePassword = devicePassword;
		storage.save("devicePassword", devicePassword);
	}
	public void setApplicationPath(String applicationPath) {
		this.applicationPath = applicationPath;
		storage.save("applicationPath", applicationPath);
	}
	public String getApplicationPath() {
		applicationPath=storage.read("applicationPath");
		return applicationPath;
	}
	private String pin;
	private String sdkDir;
	private String tokenPath;
	private String deviceIp;
	private String devicePassword;
	private String applicationPath;


}
