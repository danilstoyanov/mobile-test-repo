package com.travels.searchtravels;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.travels.searchtravels.activity.MainActivity;
import com.travels.searchtravels.utils.Constants;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class AutomatedTests {
	@Rule
	public IntentsTestRule<MainActivity> mainActivityRule=new IntentsTestRule<>(MainActivity.class);

	void checkTownTestUtil(String searchCategory, String town, String townInRussian){
		try {
			mainActivityRule.getActivity().loadByCategory(searchCategory);

			Thread.sleep(3500);

			onView(withId(R.id.cityTV)).check(matches(withText(townInRussian)));

			Assert.assertEquals(Constants.PICKED_CITY_EN, town);
			Assert.assertEquals(Constants.PICKED_CITY_RU, townInRussian);
		} catch (Exception exception) {
			Assert.fail(exception.toString());
		}
	}

	@Test
	public void checkSeaCategory() {
		checkTownTestUtil("sea", "Yalta", "Ялта");
	}

	@Test
	public void checkMountainCategory() {
		checkTownTestUtil("mountain", "Sochi","Сочи");
	}

	@Test
	public void checkSnowCategory() {
		checkTownTestUtil("snow", "Helsinki","Хельсинки");
	}

	@Test
	public void checkOceanCategory() {
		checkTownTestUtil("ocean", "Сasablanca","Касабланка");
	}

	@Test
	public void checkBeachCategory() {
		checkTownTestUtil("beach", "Anapa","Анапа");
	}
}
