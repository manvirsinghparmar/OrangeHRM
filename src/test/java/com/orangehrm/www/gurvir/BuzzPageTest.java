package com.orangehrm.www.gurvir;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.www.Base.TestBase;
import com.orangehrm.www.Utils.ExcelUtils;
import com.orangehrm.www.pages.BuzzPage;
import com.orangehrm.www.pages.DashboardPage;
import com.orangehrm.www.pages.LoginPage;

public class BuzzPageTest extends TestBase {

	LoginPage lp;
	DashboardPage dp;
	BuzzPage bp;

	@BeforeMethod
	public void intialise() {
		setUp();
		lp = new LoginPage();
		dp = lp.clickLoginBtn();
		bp = dp.clickBuzzBtn();
	}

	@Test(dataProvider = "Buzz")
	public void post(String message) {
		bp.inputPost(message);
		bp.clickPostBtn();
		Assert.assertEquals(bp.getPostedText(), message);

	}

	@DataProvider(name = "Buzz")
	public String[][] dataProviderForBuzzPost() throws Exception {
		String path = "C:\\Users\\Owner\\Desktop\\ContactUs.xlsx";
		int rowsCount = ExcelUtils.getRowCount(path, "Sheet1");
		int cellCount = ExcelUtils.getCellCount(path, "Sheet1", rowsCount);

		String[][] data = new String[rowsCount][cellCount];

		for (int i = 1; i <= rowsCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);

			}

		}

		return data;

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
