package org.dnyanyog.Enum;

public enum ResponseCodes {
	Notification_Sent_SUCCESS("Success","Notification sent successfully","0000" ),
	Notification_Sent_Fail("Fail","Incomplete data sent","NOTI0002"),
	Notification_Sent_Failed("Fail","invalid email address for to email","NOTI0003"),
	Notification_Sent_Error_occur("Fail","Error occurred while saving or sending notification","NOTI0004");
	
	private final String status;
	private final String message;
	private final String code;
	private ResponseCodes(String status, String message, String code) {
		this.status = status;
		this.message = message;
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public String getCode() {
		return code;
	}
	
}
