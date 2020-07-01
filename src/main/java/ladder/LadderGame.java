package ladder;

import ladder.domain.ladder.Game;
import ladder.domain.ladder.Height;
import ladder.domain.play.Players;
import ladder.domain.play.Playing;
import ladder.domain.play.Prizes;
import ladder.util.ConvertUtils;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        Players players = Players.of(ConvertUtils.split(InputView.doInputParticipants()));
        Prizes prizes = Prizes.of(ConvertUtils.split(InputView.doInputPrizes()));
        Playing playing = Playing.of(players, prizes);
        Height height = Height.of(InputView.doInputLadderHeight());

        Game game = Game.play(playing, height);

        String targetPlayer = "";
        ResultView.printResult(game);
        while (!Players.PLAYERS_ALL.equals(targetPlayer)) {
            targetPlayer = InputView.doInputWantToSeeResult();
            ResultView.printResults(game.makeResults(targetPlayer));
        }
    }
}