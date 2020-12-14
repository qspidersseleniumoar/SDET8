package com.comcast.commonutils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *  This class contains webDriver specific libarraies , which used to handle DropdWon , Popups . wait statmnet , action
 * @author Deepak
 *
 */
public class WebDriverUTils {
	/**
	 *  used to select the value from the dropDwon based on visible text
	 * @param element
	 * @param data
	 */
	public void select(WebElement element , String data) {
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}
	
	/**
	 *  used to select the value from the dropDwon based on index
	 * @param element
	 * @param data
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

}
