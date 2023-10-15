package potslotty.tournaments;

import common.BaseTest;
import constants.ConstantGlobal;
import drivers.DriverManager;
import org.testng.annotations.Test;
import potslotty.pages.CommonPage;
import potslotty.pages.HomePage;
import potslotty.pages.TournamentPage;
import utils.LogUtils;

import static keywords.Keyword.openURL;
import static keywords.Keyword.sleep;

public class PlayTournament {
    public ScreenManager screenManager;
    public TournamentPage tournamentPage;
    public CommonPage commonPage;
    public HomePage homePage;

    public PlayTournament(){
        screenManager = new ScreenManager();
        tournamentPage = new TournamentPage();
        commonPage = new CommonPage();
    }

    @Test
    public void testGame(){
        for (int n =1 ; n < 11 ; n++){
            LogUtils.info("Profile =======================> " + n);

            for (int tournamentIndex = 3; tournamentIndex < 5 ; tournamentIndex++){
                LogUtils.info("Tounament======================> " +tournamentIndex);
                for (int rejoin = 7; rejoin > 0 ; rejoin--){
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
    @Test
    public void testProfile(){
        for (int n =1 ; n < 11 ; n++){
            LogUtils.info("Profile =======================> " + n);
            BaseTest.createProfileDriver(n);
            openURL(ConstantGlobal.URL);
            LogUtils.info("Profile: " + n + " Balance: " + commonPage.getBalance());
            sleep(30);
            BaseTest.closeDriver();
        }
    }
}
