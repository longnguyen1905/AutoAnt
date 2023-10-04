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
        for (int n =5 ; n < 11 ; n++){
            LogUtils.info("Profile =======================> " + n);

            for (int tournamentIndex = 1; tournamentIndex < 5 ; tournamentIndex++){
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
}
