package myObservatoryUiAutomation.Appium;

public class Xpath_Locator {
	//Pop-ups page locator
	public static final String disclaimer = "//*[contains(@resource-id,'txt_title') and contains(@text,'Disclaimer')]";
	public static final String privacyPolicyStatements = "//*[contains(@resource-id,'txt_title') and contains(@text,'Privacy Policy Statements')]";
	public static final String agreeBtn = "//*[contains(@resource-id,'btn_agree')]";
	public static final String permissionMessage = "//*[contains(@resource-id,'permission_message') and contains(@text,'Allow MyObservatory to send you notifications?')]";
	public static final String permissionDenyButton = "//*[contains(@resource-id,'permission_deny_button') and contains(@text,\"Don't allow\")]";
	public static final String backgroundAlert = "//*[contains(@resource-id,'alertTitle') and contains(@text,'Background Access to Location Information')]";
	public static final String okBtn = "//*[contains(@resource-id,'button1') and contains(@text,'OK')]";
	public static final String locationPermissionMessage = "//*[contains(@resource-id,'permission_message') and contains(@text,'Allow MyObservatory to access this device’s location?')]";
	public static final String exitNextBtn = "//*[contains(@resource-id,'exit_btn')]";

	//Apps content locator
	public static final String MyObservatory = "//*[@text='MyObservatory']";
	public static final String menuBtn = "//*[contains(@content-desc,'Navigate up')]";
	public static final String forecastCategory = "//*[contains(@resource-id,'title') and contains(@text, 'Forecast & Warning Services')]";
	public static final String nineDayForecastBtn = "//*[contains(@resource-id,'title') and @text='9-Day Forecast']";
	public static final String nineDayForecastTab = "//*[@content-desc='9-Day Forecast' and ./child::*[contains(@text,'9-Day Forecast')]]";
}