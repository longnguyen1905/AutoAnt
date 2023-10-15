package potslotty.tournaments;

import common.BaseTest;
import constants.ConstantGlobal;
import drivers.DriverManager;
import helpers.ExcelHelper;
import org.testng.annotations.Test;
import potslotty.pages.CommonPage;
import potslotty.pages.HomePage;
import potslotty.pages.ProfilePage;
import potslotty.pages.TournamentPage;
import utils.LogUtils;

import static keywords.Keyword.openURL;
import static keywords.Keyword.sleep;

public class PlayTournament {
    public ScreenManager screenManager;
    public TournamentPage tournamentPage;
    public CommonPage commonPage;
    public HomePage homePage;
    public ProfilePage profilePage;
    public ExcelHelper excelHelper;
    String balance;
    String account;
    public PlayTournament(){
        screenManager = new ScreenManager();
        tournamentPage = new TournamentPage();
        commonPage = new CommonPage();
    }

    @Test
    public void testGame(){
        for (int n =8 ; n < 21 ; n++){
            LogUtils.info("Profile =======================> " + n);

            for (int tournamentIndex = 3; tournamentIndex < 5 ; tournamentIndex++){
                LogUtils.info("Tounament======================> " +tournamentIndex);
                for (int rejoin = 1; rejoin > 0 ; rejoin--){
                    BaseTest.createProfileDriver(n);
                    openURL(ConstantGlobal.URL);
                    LogUtils.info("Rejoin ============================> " +rejoin);
                    screenManager.setFilePath(tournamentPage.getGameName(tournamentIndex));
                    screenManager.selectGame(tournamentPage.getGameName(tournamentIndex), tournamentIndex);
                    BaseTest.closeDriver();
                }
            }
        }

    }
//    @Test
//    public void testProfile(){
//        for (int n =1 ; n < 11 ; n++){
//            excelHelper = new ExcelHelper();
//            excelHelper.setExcelFile("src/test/resources/datatest/DataTest.xlsx", "data");
//            BaseTest.createProfileDriver(n);
//            openURL(ConstantGlobal.URL);
//            commonPage.clickAvtar();
//            balance = commonPage.getBalance();
//            excelHelper.setCellData("Profile " + n, n, "Profile");
//            excelHelper.setCellData(balance, n, "Balance");
//            BaseTest.closeDriver();
//        }
//    }
}
