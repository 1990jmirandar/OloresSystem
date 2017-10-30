package com.sinergiass.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class guestPreferences {


	private String layout = "teal";
	private String theme = "teal";
	private boolean overlayMenu = true;
	private boolean darkMenu = false;
	private boolean orientationRTL = false;

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public boolean isOverlayMenu() {
		return overlayMenu;
	}

	public void setOverlayMenu(boolean overlayMenu) {
		this.overlayMenu = overlayMenu;
	}

	public boolean isOrientationRTL() {
		return orientationRTL;
	}

	public void setOrientationRTL(boolean orientationRTL) {
		this.orientationRTL = orientationRTL;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public boolean isDarkMenu() {
		return darkMenu;
	}

	public void setDarkMenu(boolean darkMenu) {
		this.darkMenu = darkMenu;
	}
	

	
	
	
}
