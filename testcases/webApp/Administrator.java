package webApp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Administrator {

	@Test(groups = "web")
	public void Admin_01_Create_New_Author() {
		Assert.assertTrue(true);
	}

	@Test(groups = "web", dependsOnMethods = "Admin_01_Create_New_Author")
	public void Admin_02_View_Author() {

	}

	@Test(groups = "web", dependsOnMethods = { "Admin_01_Create_New_Author", "Admin_02_View_Author" })
	public void Admin_03_Update_Author() {
		Assert.assertTrue(false);
	}

	@Test(groups = "web", dependsOnMethods = "Admin_03_Update_Author")
	public void Admin_04_Delete_Author() {
	}
}
