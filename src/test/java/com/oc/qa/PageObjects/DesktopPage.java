package com.oc.qa.PageObjects;
	import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

	public class DesktopPage extends BasePage {
		public DesktopPage(WebDriver driver)
		{
			super (driver);	
		}
		
//Locators
		@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/descendant::a[text()=\"Desktops\"]")
		WebElement Desktop;
		@FindBy(xpath="//a[text()=\"Show AllDesktops\"]")
		WebElement AllDesktop;
		@FindBy(xpath="//div[@class=\"list-group\"]/a")
		WebElement Table;
		@FindBy(xpath="//h2[text()=\"Desktops\"]")
		WebElement DesktopsText;
		@FindBy(xpath="//a[text()=\"Mac (1)\"]")
		WebElement Mac;
		@FindBy(xpath="//select[@id=\"input-sort\"]")
		WebElement Sortby;
		@FindBy(xpath="//select[@id=\"input-limit\"]")
		WebElement Limit;
		
		Actions act=new Actions(driver);
		
		public void desktop()
		{
			act.moveToElement(Desktop).build().perform();
		}
		public void showalldesktop()
		{
			act.moveToElement(AllDesktop).click().build().perform();
		}
		public void tabletext()
		{
			Table.getText();	
		}
		public void desktoptext()
		{
			DesktopsText.getText();	
		}
		public void mac()
		{
			Mac.click();
		}
		public void sortby()
		{
			Select sel=new Select(Sortby);
			List<WebElement>options=sel.getOptions();
			for(WebElement opt:options)
			{
				System.out.println(opt.getText());
			}
			sel.selectByVisibleText("Price (Low > High)");
		}
		public void limit()
		{
			Select sel=new Select(Limit);
			List<WebElement>options=sel.getOptions();
			for(WebElement opt:options)
			{
				System.out.println(opt.getText());
			}
			sel.selectByVisibleText("25");
		}
		
}
